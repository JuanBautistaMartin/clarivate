package com.clarivate.test.aliteration.controllers;

import com.clarivate.test.aliteration.AlliterationService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AlliterationController {

  private final AlliterationService alliterationService;

  public AlliterationController(AlliterationService alliterationService) {
    this.alliterationService = alliterationService;
  }

  @PostMapping("/alliteration")
  public String getAllAlliterationPercentagesOrderedAsc(@RequestBody String text) {
    return alliterationService.getAlliterationPercentagesOrderedDesc(text);
  }

}
