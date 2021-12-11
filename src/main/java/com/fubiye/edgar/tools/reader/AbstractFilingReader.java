package com.fubiye.edgar.tools.reader;

import java.io.File;

import com.fubiye.edgar.tools.model.FilingDoc;
import com.fubiye.edgar.tools.model.FilingMeta;

public abstract class AbstractFilingReader implements FilingReader {
  protected File file;
  protected FilingDoc doc = new FilingDoc();

  public AbstractFilingReader(File file) {
    this.file = file;
  }

  public FilingDoc read() {
    doc.setMeta(readMeta());
    readContent();
    return doc;
  }
  protected abstract void readContent();
  
}
