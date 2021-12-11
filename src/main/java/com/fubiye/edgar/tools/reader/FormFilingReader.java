package com.fubiye.edgar.tools.reader;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import com.fubiye.edgar.tools.config.FormConfig;
import com.fubiye.edgar.tools.exception.DocParseException;
import com.fubiye.edgar.tools.exception.DocReadException;
import com.fubiye.edgar.tools.model.FilingDocContent;
import com.fubiye.edgar.tools.model.FilingMeta;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.reflect.FieldUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import static com.fubiye.edgar.tools.constant.FormConstants.DOCUMENT;
import static com.fubiye.edgar.tools.constant.FormConstants.TEXT;

@Slf4j
public class FormFilingReader extends AbstractFilingReader {
  protected Document document;
  protected Elements currElements;
  protected FormConfig config;

  public FormFilingReader(File file, FormConfig config) {
    super(file);
    this.config = config;
    parse();
  }

  private void parse() {
    log.info("Start parsing file: {}", file.getName());
    try {
      this.document = Jsoup.parse(file, StandardCharsets.UTF_8.name());
      currElements = document.select(DOCUMENT);
    } catch (IOException e) {
      throw new DocParseException(e);
    }
  }

  @Override
  public FilingMeta readMeta() {
    FilingMeta meta = new FilingMeta();
    for(var node :config.getStructures()){
      try{
        currElements = currElements.select(node);
        var value = currElements.first().ownText();
        FieldUtils.writeField(meta, node, value,true);
      } catch (Exception e){
        throw new DocReadException(e);
      }
    }
    return meta;
  }

  @Override
  public FilingDocContent readContent() {
    FilingDocContent content = new FilingDocContent();
    currElements = document.select(DOCUMENT).select(TEXT);
    for(var elements: currElements.first().children()){
      System.out.println(elements.tag());
    }
    return content;
  }
  
}
