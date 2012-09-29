package com.clouway.tddmicroexercises.textconvertor;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */

import org.apache.commons.lang.StringEscapeUtils;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class UnicodeFileToHtmlTextConverter {
  private String filePath;

  public UnicodeFileToHtmlTextConverter(String filePath) {
    this.filePath = filePath;
  }

  public String convertToHtml() throws IOException {
    Scanner scanner = new Scanner(new File(filePath));
    String html = "";
    try {
      while (scanner.hasNextLine()) {
        String textLine = scanner.nextLine();
        html += StringEscapeUtils.escapeHtml(textLine);
        html += "<br />";
      }
    } finally {
      scanner.close();
    }
    return html;
  }
}
