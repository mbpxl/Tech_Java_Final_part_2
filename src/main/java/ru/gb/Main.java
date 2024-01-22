package ru.gb;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main {
  public static void main(String[] args) {
    int[] field = {0, 1, 2, 3, 0, 1, 2, 3, 0};

    try (DataOutputStream outputStream = new DataOutputStream(new FileOutputStream("file.txt"))) {
      for (int i = 0; i < field.length; i+=3) {
        byte value = (byte) ((byte) (field[i] << 6) | (field[i+1] << 4) | (field[i+2] << 2));
        outputStream.writeByte(value);
      }
    } catch (FileNotFoundException e) {
      throw new RuntimeException(e);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}