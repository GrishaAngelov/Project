package com.clouway.xml.parsers;

import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class XmlValidator {
    public boolean validateXmlFile(InputStream xml, String schemaDefinition) throws SAXException, FileNotFoundException {
        if (xml == null || getClass().getResource(schemaDefinition) == null) {
            throw new FileNotFoundException();
        }

        boolean isXmlValid = false;
        Source xmlFile = new StreamSource(xml);
        SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        Schema schema = schemaFactory.newSchema(getClass().getResource(schemaDefinition));
        Validator validator = schema.newValidator();
        try {
            validator.validate(xmlFile);
            isXmlValid = true;
        } catch (IOException e) {

        }
        return isXmlValid;
    }
}
