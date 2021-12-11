package com.fubiye.edgar.tools.model;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class FilingDoc {
    private FilingMeta meta;
    private FilingDocContent content;
}
