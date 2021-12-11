package com.fubiye.edgar.tools.reader;

import com.fubiye.edgar.tools.model.FilingDoc;
import com.fubiye.edgar.tools.model.FilingMeta;

public interface FilingReader {
    FilingDoc read();
    FilingMeta readMeta();
}
