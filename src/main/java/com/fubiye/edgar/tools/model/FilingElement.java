package com.fubiye.edgar.tools.model;

import lombok.Data;

import java.util.List;

@Data
public class FilingElement<T> {
  private String type;
  private List<T> payload;
  private boolean separator;
}
