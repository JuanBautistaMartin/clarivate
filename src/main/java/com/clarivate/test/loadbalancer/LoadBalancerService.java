package com.clarivate.test.loadbalancer;

public interface LoadBalancerService {
  boolean loadBalancer(Integer[] requests);
}
