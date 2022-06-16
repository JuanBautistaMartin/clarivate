package com.clarivate.test.aliteration.controllers;

import com.clarivate.test.aliteration.AlliterationService;
import com.clarivate.test.exceptions.TextNotEmptyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AlliterationController {

  private static final String TEXT_EMPTY = "Text cannot be empty";

  private final AlliterationService alliterationService;

  public AlliterationController(AlliterationService alliterationService) {
    this.alliterationService = alliterationService;
  }

  @PostMapping("/alliteration/all")
  public ResponseEntity<String> getAllAlliterationPercentagesOrderedDesc(@RequestBody String text) {
    if(text.isBlank()) {
      throw new TextNotEmptyException(TEXT_EMPTY);
    }
    return new ResponseEntity<>(alliterationService.getAlliterationPercentagesOrderedDesc(text), HttpStatus.OK);
  }

  @PostMapping("/alliteration/max")
  public ResponseEntity<String> getAlliterationMaxPercentage(@RequestBody String text) {
    if(text.isBlank()) {
      throw new TextNotEmptyException(TEXT_EMPTY);
    }
    return new ResponseEntity<>(alliterationService.getAlliterationMaxPercentage(text), HttpStatus.OK);
  }

}
