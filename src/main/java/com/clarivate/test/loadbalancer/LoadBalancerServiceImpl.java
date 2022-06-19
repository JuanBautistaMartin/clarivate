package com.clarivate.test.loadbalancer;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class LoadBalancerServiceImpl implements LoadBalancerService {

  public boolean loadBalancer(Integer[] requests) {
      var result = false;

      if(this.checkIfRequestArrayIsNull(requests)) {
        var sumAux = 0;
        var requestCounterAux = 0;
        Map<Integer, Integer> numberOfRequestsPerSum = new HashMap<>();

        int numberOfRequest = requests.length - 1;

        for (var i = 0; i <= numberOfRequest; i++) {

          if (numberOfRequestsPerSum.values().size() >= 3) {
            result = checkIfTwoRequestsCanBeDropped(numberOfRequestsPerSum, requests.length);
          }

          // In this Map, one entry will be key=j, because we don't need an specific key, just unique one.
          // And value will be the number of request that match A[i]
          numberOfRequestsPerSum = new HashMap<>();

          // Variable to store the number of request for a given sum of A[j]
          requestCounterAux = 0;

          // Variable to store the sum of A[j] for given i
          sumAux = 0;

          for (var j = 0; j <= numberOfRequest; j++) {
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

  /**
   * Checking if there are more than A[K] subArray of request and if two request can be removed in order to
   * check if the loadBalancer can manage the full request array.
   *
   * @param numberOfRequestsPerSum the number of request that a worker can manage
   * @param numberOfRequests total number of requests
   * @return if it's possible for the loadBalcer to manage the full array of requests
   */
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
