package com.clouway.xml.parsers;

import com.clouway.xml.Address;
import com.clouway.xml.Employee;
import com.clouway.xml.Employer;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class SaxParser extends DefaultHandler {
    private StringBuffer stringBuffer = new StringBuffer();
    private Map<Integer, Multimap<String, String>> employeeMap;
    private Multimap<String, String> values;
    private int employeeCount = 0;

    public void parseXml(InputStream xmlIs) throws SAXException, ParserConfigurationException, FileNotFoundException {
        if (xmlIs == null) {
            throw new FileNotFoundException();
        }
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        SAXParser saxParser = saxParserFactory.newSAXParser();
        try {
            saxParser.parse(xmlIs, this);
        } catch (IOException ignored) {

        }
    }

    @Override
    public void startDocument() {
        employeeMap = new HashMap<Integer, Multimap<String, String>>();
        values = ArrayListMultimap.create();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) {
        stringBuffer.setLength(0);
    }

    @Override
    public void characters(char[] chars, int start, int length) {
        stringBuffer.append(chars, start, length);
    }

    @Override
    public void endElement(String uri, String localName, String qName) {

        if (!qName.equals("employer") && !qName.equals("address") && !qName.equals("employee_info")) {
            if (!qName.equals("employee")) {
                values.put(qName, stringBuffer.toString());
            } else {
                employeeMap.put(employeeCount, values);
                values = ArrayListMultimap.create();
                employeeCount++;
            }
        }
    }

    public List<Employee> getAllEmployees() {
        List<Employee> employeeList = new ArrayList<Employee>();

        for (int i = 0; i < employeeMap.size(); i++) {
            Multimap<String, String> map = employeeMap.get(i);
            Map<String, Iterator> iteratorMap = getIteratorMap(map);

            String firstName = getListFromIterator(iteratorMap.get("firstName")).get(0);
            String lastName = getListFromIterator(iteratorMap.get("lastName")).get(0);
            int age = Integer.parseInt(getListFromIterator(iteratorMap.get("age")).get(0));
            String position = getListFromIterator(iteratorMap.get("position")).get(0);

            List<String> employerNameList = getListFromIterator(iteratorMap.get("name"));
            List<String> startDateList = getListFromIterator(iteratorMap.get("startDate"));
            List<String> endDateList = getListFromIterator(iteratorMap.get("endDate"));
            List<Employer> employerList = getAllEmployers(employerNameList, startDateList, endDateList);

            List<String> streetList = getListFromIterator(iteratorMap.get("street"));
            List<String> streetNoList = getListFromIterator(iteratorMap.get("streetNo"));
            List<String> sectionList = getListFromIterator(iteratorMap.get("section"));
            List<String> cityList = getListFromIterator(iteratorMap.get("city"));
            List<Address> addressList = getAllAddresses(streetList, streetNoList, sectionList, cityList);

            employeeList.add(new Employee(firstName, lastName, age, position, employerList, addressList));
        }
        return employeeList;
    }

    private Map<String, Iterator> getIteratorMap(Multimap<String, String> map) {
        List<String> employeeElementList = Arrays.asList("firstName", "lastName", "age", "position", "name", "startDate", "endDate",
                "street", "streetNo", "section", "city");
        Map<String, Iterator> iteratorMap = new Hashtable<String, Iterator>();
        for (String employeeElement : employeeElementList) {
            iteratorMap.put(employeeElement, map.get(employeeElement).iterator());
        }
        return iteratorMap;
    }

    private List<String> getListFromIterator(Iterator iterator) {
        List<String> list = new ArrayList<String>();
        while (iterator.hasNext()) {
            list.add((String) iterator.next());
        }
        return list;
    }

    private List<Address> getAllAddresses(List<String> streetList, List<String> streetNoList, List<String> sectionList,
                                          List<String> cityList) {
        List<Address> addressList = new ArrayList<Address>();
        for (int i = 0; i < streetList.size(); i++) {
            String street = streetList.get(i);
            int streetNo = Integer.parseInt(streetNoList.get(i));
            int section = Integer.parseInt(sectionList.get(i));
            String city = cityList.get(i);
            addressList.add(new Address(street, streetNo, section, city));
        }
        return addressList;
    }

    private List<Employer> getAllEmployers(List<String> employerNameList, List<String> startDateList, List<String> endDateList) {
        List<Employer> emplrList = new ArrayList<Employer>();
        for (int i = 0; i < employerNameList.size(); i++) {
            String employerName = employerNameList.get(i);
            String startDate = startDateList.get(i);
            String endDate = endDateList.get(i);
            emplrList.add(new Employer(employerName, startDate, endDate));
        }
        return emplrList;
    }
}
