package com.fubiye.edgar.tools.model;

import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@ToString
public class FilingDocContent {
  List<FilingElement<String>> elements;
}
