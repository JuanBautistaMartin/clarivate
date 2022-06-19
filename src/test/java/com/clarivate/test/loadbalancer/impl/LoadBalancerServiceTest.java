package com.clarivate.test.loadbalancer.impl;

import com.clarivate.test.loadbalancer.LoadBalancerService;
import com.clarivate.test.loadbalancer.LoadBalancerServiceImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

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

  @Test
  void loadBalancerCanBalanceAndNumberOfRequestInSumAreHigherThanRequestLengthPlusTwoDropped() {
    // given
    Integer[] requests = {1,3,4,2,2,2,1,1,2};

    // when
    boolean result = loadBalancerService.loadBalancer(requests);

    // then
    assertTrue(result);
  }

  @Test
  void loadBalancerCanBalanceAndNumberOfRequestInSumAreEqualsToRequestLengthMinusTwoDropped() {
    // given
    Integer[] requests = {1,2,2,2,2,1,1,2};

    // when
    boolean result = loadBalancerService.loadBalancer(requests);

    // then
    assertTrue(result);
  }

  @Test
  void loadBalancerCannotDistributeRequestProperly() {
    // given
    Integer[] requests = {1,1,1,1,1,1};

    // when
    boolean result = loadBalancerService.loadBalancer(requests);

    // then
    assertFalse(result);
  }

}
