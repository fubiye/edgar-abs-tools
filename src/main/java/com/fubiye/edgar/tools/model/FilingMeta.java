package com.fubiye.edgar.tools.model;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class FilingMeta {
  private String type;
  private String sequence;
  private String filename;
}
