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

  private final AlliterationService alliterationService;

  public AlliterationController(AlliterationService alliterationService) {
    this.alliterationService = alliterationService;
  }

  @PostMapping("/alliteration/all")
  public String getAllAlliterationPercentagesOrderedAsc(@RequestBody String text) {
    if(text.isBlank()) {
      throw new TextNotEmptyException("Text cannot be empty");
    }
    return alliterationService.getAlliterationPercentagesOrderedDesc(text);
  }

  @PostMapping("/alliteration/max")
  public ResponseEntity<String> getAlliterationMaxPercentage(@RequestBody String text) {
    if(text.isBlank()) {
      throw new TextNotEmptyException("Text cannot be empty");
    }
    return new ResponseEntity<>(alliterationService.getAlliterationMaxPercentage(text), HttpStatus.OK);
  }

}
