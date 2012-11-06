package com.clouway.jdbc.task2_2;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.List;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class TouristDBTool {
    private Connection connection;
    private Statement statement;

    public void configureDataSource(String url, String username, String password) throws SQLException {
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setURL(url);
        dataSource.setUser(username);
        dataSource.setPassword(password);
        connection = dataSource.getConnection();
        statement = connection.createStatement();
    }

    public void fillTouristDB() throws SQLException {
        try {
            List<String> queryList = Arrays.asList(
                    "create table if not exists people (name VARCHAR(20),egn VARCHAR (10) NOT NULL,PRIMARY KEY (egn), age INTEGER, email VARCHAR(30))",
                    "insert into people values (\"John\",\"8912103265\",23,\"john@mail.com\")",
                    "insert into people values (\"James\",\"8710122354\",25,\"james@mail.com\")",
                    "insert into people values (\"Peter\",\"8218122165\",30,\"peter@mail.com\")",
                    "insert into people values (\"Kelly\",\"8715122354\",25,\"kelly@mail.com\")",
                    "insert into people values (\"Tina\",\"8410122354\",28,\"tina@mail.com\")",
                    "insert into people values (\"Diana\",\"8405122354\",28,\"diana@mail.com\")",
                    "insert into people values (\"Robin\",\"8405182354\",28,\"robin@mail.com\")",
                    "insert into people values (\"Steve\",\"8405212354\",28,\"steve@mail.com\")",
                    "insert into people values (\"Simon\",\"8405232354\",28,\"simon@mail.com\")",
                    "create table if not exists trip (egn VARCHAR(10) NOT NULL, FOREIGN KEY (egn) REFERENCES people(egn), arrive_date DATE, leave_date DATE, city VARCHAR(20))",
                    "insert into trip values (\"8912103265\",'2012-10-18','2012-10-22',\"New York\")",
                    "insert into trip values (\"8710122354\",'2012-10-18','2012-10-22',\"New York\")",
                    "insert into trip values (\"8218122165\",'2012-10-18','2012-10-25',\"Boston\")",
                    "insert into trip values (\"8715122354\",'2012-10-18','2012-10-25',\"Boston\")",
                    "insert into trip values (\"8410122354\",'2012-10-18','2012-10-25',\"Boston\")",
                    "insert into trip values (\"8405122354\",'2012-10-18','2012-10-25',\"Washington\")",
                    "insert into trip values (\"8405182354\",'2012-10-18','2012-10-25',\"Washington\")",
                    "insert into trip values (\"8405212354\",'2012-10-18','2012-10-25',\"Washington\")",
                    "insert into trip values (\"8405232354\",'2012-10-18','2012-10-25',\"Washington\")"
            );

            for (String query : queryList) {
                statement.addBatch(query);
            }

            statement.executeBatch();

        } finally {
            statement.close();
            connection.close();
        }
    }

}
