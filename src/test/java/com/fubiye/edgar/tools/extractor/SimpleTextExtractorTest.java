package com.fubiye.edgar.tools.extractor;

import org.jsoup.Jsoup;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SimpleTextExtractorTest {
  private ChunkExtractor<String> extractor;

  @BeforeEach
  public void setup(){
    extractor = new SimpleTextExtractor();
  }

  @Test
  public void testExtractSimpleText(){
    var html = """
        <div style="DISPLAY: block; MARGIN-LEFT: 0pt; TEXT-INDENT: 0pt; MARGIN-RIGHT: 0pt; TEXT-ALIGN: center">
                                <div style="DISPLAY: block; MARGIN-LEFT: 0pt; TEXT-INDENT: 0pt; MARGIN-RIGHT: 0pt; TEXT-ALIGN: center"><font style="DISPLAY: inline; FONT-SIZE: 12pt; FONT-FAMILY: Times New Roman"><font style="DISPLAY: inline; TEXT-DECORATION: underline"><font style="DISPLAY: inline; FONT-SIZE: 10pt; FONT-FAMILY: Times New Roman">RWT HOLDINGS, INC.</font></font></font></div>
                            </div>
        """;
    var elements = Jsoup.parse(html).select("body").first().children();
    var ele = extractor.extract(elements.first());
    assertEquals("div", ele.getType());
    assertEquals("RWT HOLDINGS, INC.", ele.getPayload().get(1));
  }

  @Test
  public void testExtractSimpleTextContainsMultipleEle(){
    var html = """
        <p style="margin:0in;margin-bottom:.0001pt;"><font face="Times New Roman" lang="EN-US" style="font-size:9.0pt;">The Gateway Net Lease Portfolio Mortgage Loan, the Starwood
                                  Capital Group Hotel Portfolio Mortgage Loan, the 211 Main Street Mortgage Loan</font><i><font face="Times New Roman" lang="EN-US" style="font-size:9.0pt;">pari
                                  passu</font></i><font face="Times New Roman" lang="EN-US" style="font-size:9.0pt;">Agreement.&nbsp; The responsibilities of Midland Loan Services, a Division of
                                  PNC Bank, National Association.&nbsp; Thus, the servicer compliance statement provided by Midland Loan Services</font></p>
        """;
    var elements = Jsoup.parse(html).select("body").first().children();
    var ele = extractor.extract(elements.first());
    assertEquals("p", ele.getType());
    assertEquals(3, ele.getPayload().size());
    assertEquals("pari passu", ele.getPayload().get(1));
  }

}