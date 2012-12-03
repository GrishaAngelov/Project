package com.clouway.xml.parsers;

import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class TagCounter {
    public int countAllTagOccurs(String tag, String xmlFileName) throws FileNotFoundException {
        Scanner scanner = new Scanner(getClass().getResourceAsStream(xmlFileName));
        int count = 0;
        try {
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                if (line.contains(tag)) {
                    count++;
                }
            }
        } finally {
            scanner.close();
        }
        return count;
    }
}
