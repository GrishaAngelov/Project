package com.clouway.tddmicroexercises.textconvertor;

import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class UnicodeFileToHtmlTextConverterTest {
  private File file;
  private UnicodeFileToHtmlTextConverter converter;

  @Before
  public void setUp() {
    file = new File("file.txt");
    converter = new UnicodeFileToHtmlTextConverter(file.getPath());
  }

  @Test
  public void oneLineOfPlainTextIsConvertedToHTML() throws Exception {
    writeToFile("hello");
    assertThat("hello<br />",is(converter.convertToHtml()));
  }

  @Test
  public void twoLinesOfPlainTextAreConvertedToHTML() throws IOException {
    writeToFile("hello\nJohn");
    assertThat("hello<br />John<br />", is(converter.convertToHtml()));
  }

  @Test
  public void emptyLineCanNotBeConvertedToHTML() throws IOException {
    writeToFile("");
    assertThat("",is(converter.convertToHtml()));
  }

  private void writeToFile(String message) throws FileNotFoundException {
    PrintWriter writer = new PrintWriter(file);
    try {
      writer.print(message);
    } finally {
      writer.close();
    }
  }
}
