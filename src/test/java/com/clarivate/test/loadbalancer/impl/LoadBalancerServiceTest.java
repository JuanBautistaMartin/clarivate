package com.clarivate.test.loadbalancer.impl;

import com.clarivate.test.loadbalancer.LoadBalancerService;
import com.clarivate.test.loadbalancer.LoadBalancerServiceImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;

class LoadBalancerServiceTest {

  private final LoadBalancerService loadBalancerService = new LoadBalancerServiceImpl();

  @Test
  void loadBalancerWithNullArrayOfRequests() {
    // given
    Integer[] requests = {};

    // when
    boolean result = loadBalancerService.loadBalancer(null);

    // then
    assertFalse(result);
  }

  @Test
  void loadBalancerWithEmptyArrayOfRequests() {
    // given
    Integer[] requests = {};

    // when
    boolean result = loadBalancerService.loadBalancer(requests);

    // then
    assertFalse(result);
  }

}
