package com.clarivate.test.loadbalancer;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class LoadBalancerServiceImpl implements LoadBalancerService {

  public boolean loadBalancer(Integer[] requests) {
      int sumAux = 0;
      int requestCounterAux = 0;
      boolean result = false;

      if(this.checkIfRequestArrayIsNull(requests)) {
        Map<Integer, Integer> numberOfRequestsPerSum = new HashMap<>();

        int numberOfRequest = requests.length - 1;

        for (int i = 0; i <= numberOfRequest; i++) {

          if (numberOfRequestsPerSum.values().size() >= 3) {
            result = checkIfTwoRequestsCanBeDropped(numberOfRequestsPerSum, requests.length);
          }

          numberOfRequestsPerSum = new HashMap<>();
          requestCounterAux = 0;
          sumAux = 0;

          for (int j = 0; j <= numberOfRequest; j++) {
            sumAux += requests[j];
            requestCounterAux++;

            if (sumAux == i) {
              numberOfRequestsPerSum.put(j, requestCounterAux);
              sumAux = 0;
              requestCounterAux = 0;

            } else if (sumAux > i) {
              sumAux = 0;
              requestCounterAux = 0;
            }
          }
        }
      }
      return result;
  }

  private boolean checkIfTwoRequestsCanBeDropped(Map<Integer, Integer> numberOfRequestsPerSum, Integer numberOfRequests) {
    Boolean result = false;

    Integer totalRequestsUsedInSum =
      numberOfRequestsPerSum.values().stream()
        .reduce(0, Integer::sum);

    if(totalRequestsUsedInSum > numberOfRequests - 2) {
      for(Map.Entry<Integer, Integer> entry : numberOfRequestsPerSum.entrySet()) {
        if(totalRequestsUsedInSum - entry.getValue() == numberOfRequests - 2) {
          if(numberOfRequestsPerSum.size() - 1 == 3) {
            result = true;
          } else {
            result = false;
          }
        }
      }

    } else if(totalRequestsUsedInSum == numberOfRequests - 2) {
      result = true;
    }

    return result;
  }

  private boolean checkIfRequestArrayIsNull(Integer[] requests) {
    return requests != null;
  }
}
