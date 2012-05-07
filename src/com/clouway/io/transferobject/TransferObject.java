package com.clouway.io.transferobject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class TransferObject {
  /**
   *
   * @param in - InputStream object
   * @param out - OutputStream object
   * @param numberOfBytes - number of read bytes
   * @param offset - how many bytes to skip before start the transfer
   * @return total number of transferred bytes
   * @throws IOException
   */
  public int transfer(InputStream in, OutputStream out, int numberOfBytes, int offset) throws IOException {

    int totalTransferredBytes = 0;
    int readByte;
    try {
      if (numberOfBytes == -1) {
        while ((readByte = in.read()) != -1) {
          out.write(readByte);
          totalTransferredBytes++;
        }
      } else {
        in.skip(offset);
        while ((readByte = in.read()) != -1) {
          out.write(readByte);
          totalTransferredBytes++;
        }

      }
    } finally {
      in.close();
      out.close();
    }
    return totalTransferredBytes;
  }
}
