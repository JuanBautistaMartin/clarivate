package com.clarivate.test.loadbalancer.impl;

import com.clarivate.test.loadbalancer.LoadBalancerService;
import org.springframework.stereotype.Service;

@Service
public class LoadBalancerServiceImpl implements LoadBalancerService {

  public boolean loadBalancer(Integer[] requests) {
    int sumAux = 0;
    int requestCounter = 0;
    int requestCounterAux = 0;
    int sumCounter = 0;
    boolean result = false;
    boolean sumWithOneRequest = false;

    int numberOfRequest = requests.length - 1;

    for(int i = 0; i <= numberOfRequest; i++) {

      if(sumCounter >= 3) {
        if(requestCounter <= requests.length - 2
        || requestCounter == requests.length -1 && sumWithOneRequest) {
          result = true;
        }
      }

      sumWithOneRequest = false;
      sumCounter = 0;
      requestCounter = 0;
      requestCounterAux = 0;
      sumAux = 0;

      for(int j = 0; j <= numberOfRequest; j++) {
          sumAux += requests[j];
          requestCounterAux++;

          if(sumAux == i) {

            if(requestCounterAux == 1) {
              sumWithOneRequest = true;
            }

            sumAux = 0;
            sumCounter++;
            requestCounter += requestCounterAux;
            requestCounterAux = 0;

          } else if(sumAux > i) {
            sumAux = 0;
            requestCounterAux = 0;
          }
      }
    }
    return result;
  }
}
