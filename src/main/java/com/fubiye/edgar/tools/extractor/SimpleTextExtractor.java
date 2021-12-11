package com.fubiye.edgar.tools.extractor;

import com.fubiye.edgar.tools.model.FilingElement;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.Node;
import org.jsoup.nodes.TextNode;
import org.jsoup.select.NodeVisitor;

import java.util.*;

public class SimpleTextExtractor implements ChunkExtractor<String> {
  @Override
  public FilingElement<String> extract(Element element) {
    var ele = new FilingElement<String>();
    ele.setType(element.tagName());
    ele.setPayload(extractTexts(element));
    return ele;
  }

  public List<String> extractTexts(Element element){
    List<String> texts = new ArrayList<>();
    element.traverse(new NodeVisitor(){
      @Override
      public void head(Node node, int depth) {
        if(node instanceof TextNode text){
          texts.add(String.valueOf(text));
        }
      }

      @Override
      public void tail(Node node, int depth) {

      }
    });
    return texts;
  }

}
