package com.clouway.buildtools.ant;

import org.apache.log4j.Logger;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class MyClass {
    public static void main(String[] args) {
        Logger logger = Logger.getLogger(MyClass.class);
        logger.trace("Trace Message");
        System.out.println("This is MyClass");
    }
}
