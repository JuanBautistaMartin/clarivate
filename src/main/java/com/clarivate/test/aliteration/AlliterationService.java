package com.clarivate.test.aliteration;

public interface AlliterationService {

  /**
   * Get all the alliteration percentages from a text, ordered desc
   *
   * @param text text from which alliteration percentage will be calculated
   * @return a list with all the alliteration percentages of the text ordered desc
   */
  String getAlliterationPercentagesOrderedDesc(String text);

  /**
   * Get the maximum alliteration percentage from a text
   *
   * @param text text from which alliteration percentage will be calculated
   * @return the maximum percentage
   */
  String getAlliterationMaxPercentage(String text);

}
