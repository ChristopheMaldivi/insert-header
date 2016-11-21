package com.github.christophemaldivi.insertheader;

import org.fest.assertions.Assertions;
import org.junit.Test;

public class InsertHeaderTest {

  @Test
  public void insert_header_after_package() {
    // Given
    InsertHeader insertHeader = new InsertHeader();
    String oldText = "package x.y.z;\n\npublic some code";
    String header = "/**\n  * Copyright\n  */\n";

    // When
    String newText = insertHeader.insert(oldText, header);

    // Then
    Assertions.assertThat(newText).isEqualTo(
            "package x.y.z;\n/**\n  * Copyright\n  */\n\npublic some code"
    );
  }
}
