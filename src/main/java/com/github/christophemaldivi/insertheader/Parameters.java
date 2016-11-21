package com.github.christophemaldivi.insertheader;

import java.io.File;
import java.util.Collection;

class Parameters {
  final Collection<File> sourceDirectory;
  final String header;

  Parameters(Collection<File> sourceDirectory, String header) {
    this.sourceDirectory = sourceDirectory;
    this.header= header;
  }
}
