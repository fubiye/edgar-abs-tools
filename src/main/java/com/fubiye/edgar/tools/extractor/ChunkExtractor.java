package com.fubiye.edgar.tools.extractor;

import com.fubiye.edgar.tools.model.FilingElement;
import org.jsoup.select.Elements;


public interface ChunkExtractor<T> {
  FilingElement<T> extract(Elements elements);
}
