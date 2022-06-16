package com.clarivate.test.alliteration.controllers;

import com.clarivate.test.aliteration.AlliterationService;
import com.clarivate.test.aliteration.controllers.AlliterationController;
import com.clarivate.test.exceptions.TextNotEmptyException;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class AlliterationControllerTest {

  @Mock
  private final AlliterationService alliterationServiceMock = mock(AlliterationService.class);

  private final AlliterationController alliterationController = new AlliterationController(alliterationServiceMock);

  @Test
  void getAlliterationMaxPercentageWithNotEmptyText() {
    // given
    String expectedResult = "y 41.67 %";
    String text = "Yarvis yanked his ankle at yoga, and Yolanda yelled out in surprise.";

    // when
    when(alliterationServiceMock.getAlliterationMaxPercentage(text)).thenReturn(expectedResult);
    ResponseEntity<String> result = alliterationController.getAlliterationMaxPercentage(text);

    // then
    verify(alliterationServiceMock, times(1)).getAlliterationMaxPercentage(text);
    assertEquals(expectedResult, result.getBody());
  }

  @Test
  void getAllAlliterationPercentagesOrderedWithEmptyText() {
    // given
    String text = "";

    // when then
    TextNotEmptyException exception = assertThrows(TextNotEmptyException.class, () -> {
      alliterationController.getAlliterationMaxPercentage(text);
    });

    assertEquals("Text cannot be empty", exception.getMessage());
    verify(alliterationServiceMock, times(0)).getAlliterationMaxPercentage(text);
  }

  @Test
  void getAllAlliterationPercentagesWithNotEmptyText() {
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
    when(alliterationServiceMock.getAlliterationPercentagesOrderedDesc(text)).thenReturn(expectedResult);
    ResponseEntity<String> result = alliterationController.getAllAlliterationPercentagesOrderedDesc(text);

    // then
    verify(alliterationServiceMock, times(1)).getAlliterationPercentagesOrderedDesc(text);
    assertEquals(expectedResult, result.getBody());
  }

  @Test
  void getAllAlliterationPercentagesOrderedDescWithEmptyText() {
    // given
    String text = "";

    // when then
    TextNotEmptyException exception = assertThrows(TextNotEmptyException.class, () -> {
      alliterationController.getAllAlliterationPercentagesOrderedDesc(text);
    });

    assertEquals("Text cannot be empty", exception.getMessage());
    verify(alliterationServiceMock, times(0)).getAlliterationPercentagesOrderedDesc(text);
  }

}

