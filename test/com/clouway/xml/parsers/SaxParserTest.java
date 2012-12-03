package com.clouway.xml.parsers;

import com.clouway.xml.Employee;
import org.junit.Before;
import org.junit.Test;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class SaxParserTest {
    private SaxParser saxParser;

    @Before
    public void setUp() throws SAXException, FileNotFoundException {
        saxParser = new SaxParser();
        new XmlValidator().validateXmlFile(getClass().getResourceAsStream("employees.xml"), "employeeSchemaDefinition.xsd");
    }

    @Test(expected = FileNotFoundException.class)
    public void tryToParseNotExistingXml() throws SAXException, ParserConfigurationException, FileNotFoundException {
        saxParser.parseXml(getClass().getResourceAsStream("car.xml"));
    }

    @Test
    public void parseWrongElementSequence() throws SAXException, FileNotFoundException, ParserConfigurationException {
        saxParser.parseXml(getClass().getResourceAsStream("wrong_element_sequence_employee.xml"));
        List<Employee> employeeList = saxParser.getAllEmployees();
        assertThat("John", is(equalTo(employeeList.get(0).getFirstName())));
        assertThat("Smith", is(equalTo(employeeList.get(0).getLastName())));
    }

    @Test
    public void getAllEmployees() throws IOException, SAXException, ParserConfigurationException {
        saxParser.parseXml(getClass().getResourceAsStream("employees.xml"));
        List<Employee> employeeList = saxParser.getAllEmployees();
        int employeeTagOccurs = new TagCounter().countAllTagOccurs("<employee>", "employees.xml");
        assertThat(employeeList.size(), is(equalTo(employeeTagOccurs)));
    }
}
