package com.fubiye.edgar.tools.reader;

import com.fubiye.edgar.tools.config.FormConfig;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.Arrays;

import static com.fubiye.edgar.tools.constant.FormConstants.*;
import static org.junit.jupiter.api.Assertions.*;

class FormFilingReaderTest {
  private static final String FORM_FILE = "edgar/data/v212238_8-k.htm";
  private FilingReader reader;


  @BeforeEach
  public void setup(){
    File formFiling = FileUtils.toFile(this.getClass().getClassLoader().getResource(FORM_FILE));
    FormConfig config = new FormConfig();
    config.setStructures(Arrays.asList(TYPE, SEQUENCE,FILE_NAME));
    reader = new FormFilingReader(formFiling, config);
  }

  @Test
  public void testReadMeta(){
    var meta = reader.readMeta();
    assertEquals("8-K", meta.getType());
    assertEquals("1", meta.getSequence());
    assertEquals("v212238_8-k.htm", meta.getFilename());
  }

  @Test
  public void testReadContent(){
    var content = reader.readContent();
  }
}