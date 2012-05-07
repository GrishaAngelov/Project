package com.clouway.io.dataclass;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

/**
 * @author Grisha Angelov <grisha.angelov@clouway.com>
 */
public class DataClass {

  /**
   * DataClass provides methods for storing object state into binary data (serialization)
   * and rebuilding the object from the saved data
   */


  private ObjectOutputStream objectOutputStream;

  /**
   * Method uses OutputStream "out" to store Obejct "o" state
   * @param out - OutputStream
   * @param o - Object
   * @throws IOException
   */
  public void saveObject(OutputStream out, Object o) throws IOException {
    try {
      objectOutputStream = new ObjectOutputStream(out);
      objectOutputStream.writeObject(o);
    } finally {
      objectOutputStream.close();
    }
  }

  private ObjectInputStream objectInputStream;
  private Object object;

  /**
   * Method uses InputStream "in" to reconstruct the original object
   * @param in - InputStream
   * @return reconstructed object
   * @throws IOException
   * @throws ClassNotFoundException
   */
  public Object getObject(InputStream in) throws IOException, ClassNotFoundException {
    try {
      objectInputStream = new ObjectInputStream(in);
      object = objectInputStream.readObject();
    } finally {
      objectInputStream.close();
    }
    return object;
  }
}
