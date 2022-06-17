package com.clarivate.test.alliteration.impl;

import com.clarivate.test.aliteration.AlliterationService;
import com.clarivate.test.aliteration.impl.AlliterationServiceImpl;
import com.clarivate.test.exceptions.TextNotEmptyException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class AlliterationServiceTest {

  private AlliterationService alliterationService = new AlliterationServiceImpl();

  @Test
  void getAlliterationMaxPercentageWithEmptyText() {

    // given
    String text = "";

    // when then
    TextNotEmptyException exception =
      assertThrows(TextNotEmptyException.class, () -> {
        alliterationService.getAlliterationMaxPercentage("");
      });

    assertEquals("Text cannot be blank.", exception.getMessage());
  }

  @Test
  void getAllAlliterationPercentagesOrderedDescWithEmptyText() {

    // given
    String text = "";

    // when then
    TextNotEmptyException exception =
      assertThrows(TextNotEmptyException.class, () -> {
        alliterationService.getAlliterationPercentagesOrderedDesc("");
      });

    assertEquals("Text cannot be blank.", exception.getMessage());
  }

  @Test
  void getAlliterationMaxPercentageWithNotEmptyText() {

    // given
    String expectedResult = "y 41.67 %";
    String text = "Yarvis yanked his ankle at yoga, and Yolanda yelled out in surprise.";

    // when
    String result = alliterationService.getAlliterationMaxPercentage(text);

    //then
    assertEquals(expectedResult, result);
  }

  @Test
  void getAllAlliterationPercentagesOrderedDescWithNotEmptyText() {

    // given
    String expectedResult =
      "y 41.67 %\n" +
      "a 25.00 %\n" +
      "s 8.33 %\n" +
      "h 8.33 %\n" +
      "i 8.33 %\n" +
      "o 8.33 %\n";
    String text = "Yarvis yanked his ankle at yoga, and Yolanda yelled out in surprise.";

    // when
    String result = alliterationService.getAlliterationPercentagesOrderedDesc(text);

    //then
    assertEquals(expectedResult, result);
  }

}
