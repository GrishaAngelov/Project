package com.clouway.xml.parsers;

import com.clouway.xml.Address;
import com.clouway.xml.Employee;
import com.clouway.xml.Employer;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class XmlParser {
    private DocumentBuilder documentBuilder;
    private Document document;

    public void initParser() throws ParserConfigurationException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        documentBuilder = factory.newDocumentBuilder();
    }

    public Document parseXml(InputStream xmlIs) throws IOException, SAXException {
        if (xmlIs == null) {
            throw new FileNotFoundException();
        }
        document = documentBuilder.parse(xmlIs);
        return document;
    }

    public List<Employee> getAllEmployees() {
        List<Employee> employeeList = new ArrayList<Employee>();

        NodeList employees = document.getElementsByTagName("employee");
        for (int i = 0; i < employees.getLength(); i++) {
            Element employeeElement = (Element) employees.item(i);

            String firstName = employeeElement.getElementsByTagName("firstName").item(0).getTextContent();
            String lastName = employeeElement.getElementsByTagName("lastName").item(0).getTextContent();
            int age = Integer.parseInt(employeeElement.getElementsByTagName("age").item(0).getTextContent());
            String position = employeeElement.getElementsByTagName("position").item(0).getTextContent();

            NodeList employerNodeList = employeeElement.getElementsByTagName("employer");
            List<Employer> employerList = getEmployerList(employerNodeList);

            NodeList addressNodeList = employeeElement.getElementsByTagName("address");
            List<Address> addressList = getAddressList(addressNodeList);

            employeeList.add(new Employee(firstName, lastName, age, position, employerList, addressList));
        }
        return employeeList;
    }

    private List<Address> getAddressList(NodeList addresses) {
        List<Address> addrList = new ArrayList<Address>();

        for (int i = 0; i < addresses.getLength(); i++) {
            Element addressElement = (Element) addresses.item(i);

            String street = addressElement.getElementsByTagName("street").item(0).getTextContent();
            int streetNo = Integer.parseInt(addressElement.getElementsByTagName("streetNo").item(0).getTextContent());
            int section = Integer.parseInt(addressElement.getElementsByTagName("section").item(0).getTextContent());
            String city = addressElement.getElementsByTagName("city").item(0).getTextContent();

            addrList.add(new Address(street, streetNo, section, city));
        }
        return addrList;
    }

    private List<Employer> getEmployerList(NodeList employerList) {
        List<Employer> emplrList = new ArrayList<Employer>();

        for (int i = 0; i < employerList.getLength(); i++) {
            Element employerElement = (Element) employerList.item(i);

            String employerName = employerElement.getElementsByTagName("name").item(0).getTextContent();
            String startDate = employerElement.getElementsByTagName("startDate").item(0).getTextContent();
            String endDate = employerElement.getElementsByTagName("endDate").item(0).getTextContent();

            emplrList.add(new Employer(employerName, startDate, endDate));
        }
        return emplrList;
    }
}
