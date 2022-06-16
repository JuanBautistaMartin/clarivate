package com.clarivate.test.aliteration;

public interface AlliterationService {

  /**
   * Get all the alliteration percentages from a text, ordered desc
   *
   * @param text text from which alliteration percentage will be calculated
   * @return the maximum percentage
   */
  String getAlliterationPercentagesOrderedDesc(String text);

}
