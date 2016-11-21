package com.github.christophemaldivi.insertheader;

class InsertHeader {

  String insert(String oldText, String header) {
    int insertIndex = findInsertIndex(oldText);
    return oldText.substring(0, insertIndex) +
            header +
            oldText.substring(insertIndex, oldText.length());
  }

  private int findInsertIndex(String oldText) {
    int packageIndex = oldText.indexOf("package ");
    int nextLineIndex = oldText.substring(packageIndex).indexOf(";\n");
    return nextLineIndex + 2;
  }
}
