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
public class XmlParserTest {
    private XmlParser xmlParser;

    @Before
    public void setUp() throws ParserConfigurationException, SAXException, FileNotFoundException {
        xmlParser = new XmlParser();
        xmlParser.initParser();
        new XmlValidator().validateXmlFile(getClass().getResourceAsStream("employees.xml"), "employeeSchemaDefinition.xsd");
    }

    @Test(expected = FileNotFoundException.class)
    public void tryToParseNotExistingXml() throws IOException, SAXException {
        xmlParser.parseXml(getClass().getResourceAsStream("car.xml"));
    }

    @Test(expected = NullPointerException.class)
    public void parseMissingEmployeeFirstName() throws IOException, SAXException {
        xmlParser.parseXml(getClass().getResourceAsStream("missing_element_employee.xml"));
        List<Employee> employeeList = xmlParser.getAllEmployees();
        employeeList.get(0).getFirstName();
    }

    @Test
    public void parseWrongElementSequence() throws IOException, SAXException {
        xmlParser.parseXml(getClass().getResourceAsStream("wrong_element_sequence_employee.xml"));
        List<Employee> employeeList = xmlParser.getAllEmployees();
        assertThat("John", is(equalTo(employeeList.get(0).getFirstName())));
        assertThat("Smith", is(equalTo(employeeList.get(0).getLastName())));
    }

    @Test
    public void getAllEmployees() throws IOException, SAXException {
        xmlParser.parseXml(getClass().getResourceAsStream("employees.xml"));
        List<Employee> employeeList = xmlParser.getAllEmployees();
        int employeeTagOccurs = new TagCounter().countAllTagOccurs("<employee>", "employees.xml");
        assertThat(employeeList.size(), is(equalTo(employeeTagOccurs)));
        assertThat("John", is(equalTo(employeeList.get(0).getFirstName())));
    }
}
