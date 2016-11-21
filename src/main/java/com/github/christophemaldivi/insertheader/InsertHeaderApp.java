package com.github.christophemaldivi.insertheader;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.Collection;

public class InsertHeaderApp {

  public static void main(String[] args) throws IOException {
    Parameters parameters = null;
    try {
      parameters = buildParameters(args);
    } catch (IOException | ArrayIndexOutOfBoundsException e) {
      e.printStackTrace();
      System.out.println("\n\nUsage: cmd source-directory header.txt\n");
    }

    for (File file : parameters.sourceDirectory) {
      System.out.println("Update '" + file.getAbsolutePath() + "'");
      insertHeader(file, parameters);
    }
  }

  private static void insertHeader(File file, Parameters parameters) throws IOException {
    InsertHeader insertHeader = new InsertHeader();
    String oldText = FileUtils.readFileToString(file);
    String newText =
      insertHeader.insert(oldText, parameters.header);
    FileUtils.writeStringToFile(file, newText);
  }

  private static Parameters buildParameters(String[] args) throws IOException {
    Collection<File> sourceDirectory = FileUtils.listFiles(new File(args[0]), new String[]{"java"}, true);
    String header = FileUtils.readFileToString(new File(args[1]));
    return new Parameters(sourceDirectory, header);
  }
}
