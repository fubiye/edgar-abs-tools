package com.fubiye.edgar.tools.model;

import lombok.Data;

import java.util.List;

@Data
public class FilingDocContent {
  List<FilingElement> elements;
}
