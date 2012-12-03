package com.clouway.xml.parsers;

import org.junit.Before;
import org.junit.Test;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

import java.io.FileNotFoundException;
import java.io.InputStream;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class XmlValidatorTest {
    private XmlValidator xmlValidator;
    private InputStream xmlIs;

    @Before
    public void setUp() {
        xmlValidator = new XmlValidator();
        xmlIs = getClass().getResourceAsStream("employees.xml");
    }

    @Test
    public void validateValidXml() throws SAXException, FileNotFoundException {
        boolean isValid = xmlValidator.validateXmlFile(xmlIs, "employeeSchemaDefinition.xsd");
        assertThat(isValid, is(true));
    }

    @Test(expected = FileNotFoundException.class)
    public void tryToValidateNotExistingXml() throws SAXException, FileNotFoundException {
        xmlValidator.validateXmlFile(getClass().getResourceAsStream("car.xml"), "employeeSchemaDefinition.xsd");
    }

    @Test(expected = FileNotFoundException.class)
    public void tryToValidateAgainstNotExistingXsd() throws SAXException, FileNotFoundException {
        xmlValidator.validateXmlFile(xmlIs, "mySchemaDefinition.xsd");
    }

    @Test(expected = SAXParseException.class)
    public void tryToValidateStringInsteadInteger() throws SAXException, FileNotFoundException {
        xmlValidator.validateXmlFile(getClass().getResourceAsStream("incorrect_data_employee.xml"), "employeeSchemaDefinition.xsd");
    }

    @Test(expected = SAXParseException.class)
    public void tryToValidateWrongElementSequence() throws SAXException, FileNotFoundException {
        xmlValidator.validateXmlFile(getClass().getResourceAsStream("wrong_element_sequence_employee.xml"), "employeeSchemaDefinition.xsd");
    }

    @Test(expected = SAXParseException.class)
    public void tryToValidateMissingElementXml() throws SAXException, FileNotFoundException {
        xmlValidator.validateXmlFile(getClass().getResourceAsStream("missing_element_employee.xml"), "employeeSchemaDefinition.xsd");
    }
}
