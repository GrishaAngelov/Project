package com.clouway.jdbc.task2_1;

import com.mysql.jdbc.exceptions.jdbc4.MySQLSyntaxErrorException;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.sql.*;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;


/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class BookstoreOperatorTest {
    private String URL = "jdbc:mysql://localhost:3306/Bookstore";
    private String USERNAME = "root";
    private String PASSWORD = "123456";
    private BookstoreOperator bookstoreOperator;
    private BookstoreUtil bookstoreUtil;

    @Before
    public void setUp() throws SQLException {
        bookstoreOperator = new BookstoreOperator();
        bookstoreOperator.configureDataSource(URL, USERNAME, PASSWORD);

        bookstoreUtil = new BookstoreUtil();
        bookstoreUtil.configureDataSource(URL, USERNAME, PASSWORD);
        bookstoreUtil.fillTable();
    }

    @After
    public void tearDown() throws SQLException, FileNotFoundException {
        bookstoreUtil.close();
        bookstoreOperator.close();
    }

    @Test
    public void createTable() throws SQLException {
        String tableName = "customer";
        bookstoreOperator.createTable(tableName, "id integer not null auto_increment primary key, name varchar (20),time timestamp");
        assertThat(true, is(bookstoreUtil.checkIfTableExists("Bookstore", tableName)));
    }

    @Test
    public void selectColumn() throws SQLException {
        ResultSet resultSet = bookstoreOperator.selectFromBookTable("author FROM book");
        assertNotNull(resultSet);
    }

    @Test(expected = MySQLSyntaxErrorException.class)
    public void selectNotExistingColumn() throws SQLException {
        bookstoreOperator.selectFromBookTable("address FROM book");
    }

    @Test
    public void updateTable() throws SQLException {
        int updatedRowCount = bookstoreOperator.updateBook("price = 20.42 where id=5");
        assertThat(1, is(updatedRowCount));
    }

    @Test(expected = MySQLSyntaxErrorException.class)
    public void updateTableWithIncorrectValue() throws SQLException {
        bookstoreOperator.updateBook("price = asd where id=5");
    }

    @Test
    public void insertRowIntoTable() throws SQLException {

        int rowsCountBeforeInsertion = bookstoreUtil.countRowsInResultSet(bookstoreOperator.selectFromBookTable("* FROM book"));

        bookstoreOperator.insertBook("The Adventures of Huckleberry Finn", "Mark Twain", "15.33");

        int rowsCountAfterInsertion = bookstoreUtil.countRowsInResultSet(bookstoreOperator.selectFromBookTable("* FROM book"));

        assertThat(rowsCountAfterInsertion, is(rowsCountBeforeInsertion + 1));
    }

    @Test
    public void deleteRowFromTable() throws SQLException {

        int rowsCountBeforeDeletion = bookstoreUtil.countRowsInResultSet(bookstoreOperator.selectFromBookTable("* FROM book"));

        bookstoreOperator.deleteFromBook("id=5");

        int rowsCountAfterDeletion = bookstoreUtil.countRowsInResultSet(bookstoreOperator.selectFromBookTable("* FROM book"));

        assertThat(rowsCountAfterDeletion, is(rowsCountBeforeDeletion - 1));
    }

    @Test
    public void dropTable() throws SQLException {

        int numberOfTablesBeforeDrop = bookstoreUtil.countTablesInDB("Bookstore");

        bookstoreOperator.dropTable("book");

        int numberOfTablesAfterDrop = bookstoreUtil.countTablesInDB("Bookstore");

        assertThat(numberOfTablesAfterDrop, is(numberOfTablesBeforeDrop - 1));
    }

    @Test
    public void addColumn() throws SQLException {

        int columnCountBeforeAdd = bookstoreUtil.countColumnsInTable("book");

        bookstoreOperator.addColumnToTable("book", "year", "INTEGER");

        int columnCountAfterAdd = bookstoreUtil.countColumnsInTable("book");

        assertThat(columnCountAfterAdd, is(columnCountBeforeAdd + 1));
    }

    @Test
    public void deleteColumn() throws SQLException {

        int columnCountBeforeDelete = bookstoreUtil.countColumnsInTable("book");

        bookstoreOperator.deleteColumnFromTable("book", "author");

        int columnCountAfterDelete = bookstoreUtil.countColumnsInTable("book");

        assertThat(columnCountAfterDelete, is(columnCountBeforeDelete - 1));
    }

    @Test
    public void findData() throws SQLException {
        ResultSet resultSet = bookstoreOperator.findBook("title", "author LIKE \"A%\"");
        ResultSet rs = bookstoreUtil.executeQuery("SELECT title FROM book WHERE author LIKE \"A%\"");
        assertThat(bookstoreUtil.countRowsInResultSet(rs), is(bookstoreUtil.countRowsInResultSet(resultSet)));
    }


    class BookstoreUtil {
        private Statement statement;
        private Connection connection;

        public void configureDataSource(String url, String username, String password) throws SQLException {
            MysqlDataSource dataSource = new MysqlDataSource();
            dataSource.setURL(url);
            dataSource.setUser(username);
            dataSource.setPassword(password);
            connection = dataSource.getConnection();
            statement = connection.createStatement();
        }

        public void fillTable() throws SQLException {
            List<String> queries = Arrays.asList(
                    "DROP TABLE IF EXISTS book,customer",
                    "CREATE TABLE book (id INTEGER NOT NULL AUTO_INCREMENT,title VARCHAR(50),author VARCHAR (20),price DECIMAL(5,2), PRIMARY KEY(id))",
                    "INSERT INTO book VALUES (null,\"Sherlock Holmes\",\"Arthur Conan Doyle\",25.63)",
                    "INSERT INTO book VALUES (null, \"The Three Musketeers\", \"Alexandre Dumas\",16.45)",
                    "INSERT INTO book VALUES (null, \"The Adventures of Tom Sawyer\", \"Mark Twain\",30.25)",
                    "INSERT INTO book VALUES (null, \"Winnie The Pooh\", \"A. A. Milne\",18.35)",
                    "INSERT INTO book VALUES (null, \"Alice Adventures in Wonderland\", \"Lewis Carroll\",20.45)"
            );

            for (String query : queries) {
                statement.addBatch(query);
            }
            statement.executeBatch();
        }

        public int countTablesInDB(String databaseName) throws SQLException {
            int countTables = 0;
            String countTablesQuery = "SELECT COUNT(*) AS count FROM information_schema.tables WHERE table_schema='" + databaseName + "'";

            ResultSet resultSet = statement.executeQuery(countTablesQuery);
            if (resultSet.next()) {
                countTables = Integer.parseInt(resultSet.getString("count"));
            }
            return countTables;
        }

        public int countColumnsInTable(String table) throws SQLException {
            String selectQuery = "SELECT * FROM " + table + " LIMIT 1";
            ResultSet resultSet = statement.executeQuery(selectQuery);
            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
            return resultSetMetaData.getColumnCount();
        }

        public int countRowsInResultSet(ResultSet resultSet) throws SQLException {
            int count = 0;
            while (resultSet.next()) {
                count++;
            }
            return count;
        }

        public boolean checkIfTableExists(String database, String tableName) throws SQLException {
            boolean isExists = false;
            ResultSet resultSet = statement.executeQuery("SELECT table_name FROM information_schema.tables WHERE table_schema= \"" + database + "\"");
            while (resultSet.next()) {
                if (resultSet.getString("table_name").equals(tableName)) {
                    isExists = true;
                    break;
                }
            }
            return isExists;
        }

        public ResultSet executeQuery(String query) throws SQLException {
            return statement.executeQuery(query);
        }

        public void close() throws SQLException {
            statement.close();
            connection.close();
        }
    }
}
