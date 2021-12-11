package com.fubiye.edgar.tools.extractor;

import com.fubiye.edgar.tools.model.FilingElement;
import org.jsoup.nodes.Element;


public interface ChunkExtractor<T> {
  FilingElement<T> extract(Element element);
}
