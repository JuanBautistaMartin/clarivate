package com.clarivate.test.loadbalancer.controllers;

import com.clarivate.test.loadbalancer.LoadBalancerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoadBalancerController {

  private final LoadBalancerService loadBalancerService;

  public LoadBalancerController(LoadBalancerService loadBalancerService) {
    this.loadBalancerService = loadBalancerService;
  }

  @PostMapping("/loadbalancer")
  public ResponseEntity<Boolean> getAllAlliterationPercentagesOrderedDesc(@RequestBody Integer[] requests) {
    return new ResponseEntity<>(loadBalancerService.loadBalancer(requests), HttpStatus.OK);
  }

}
