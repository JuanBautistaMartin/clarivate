package com.clarivate.test.aliteration.impl;

import com.clarivate.test.aliteration.AlliterationService;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class AlliterationServiceImpl implements AlliterationService  {

  public static final String SEPARATOR = " ";
  public static final String WORDS_REGEXP = "\\W+";
  public static final String PERCENTAGE_SYMBOL = " %";
  private static final DecimalFormat decimalFormat = new DecimalFormat("0.00");

  @Override
  public String getAlliterationPercentagesOrderedDesc(String text) {
    Objects.requireNonNull(text, "Text cannot be null.");

    String[] splittedText = text.split(WORDS_REGEXP);
    Integer numberOfWords = splittedText.length;

    Map<String, Integer> alliterationMap = fillMapWithFirstLettersAndRepetitionCount(splittedText);

    List<Map.Entry<String, Integer>> alliterationList = orderLettersByCount(alliterationMap);

    return prepareResultString(alliterationList, numberOfWords);

  }

  @Override
  public String getAlliterationMaxPercentage(String text) {
    Objects.requireNonNull(text, "Text cannot be null.");

    String[] splittedText = text.split(WORDS_REGEXP);
    Integer numberOfWords = splittedText.length;

    Map<String, Integer> alliterationMap = fillMapWithFirstLettersAndRepetitionCount(splittedText);

    return prepareResultString(alliterationMap, numberOfWords);

  }

  private List<Map.Entry<String, Integer>> orderLettersByCount(Map<String, Integer> alliterationMap) {
    return alliterationMap.entrySet()
            .stream()
            .sorted((k1, k2) -> k2.getValue().compareTo(k1.getValue()))
            .collect(Collectors.toList());
  }

  private Map<String, Integer> fillMapWithFirstLettersAndRepetitionCount(String[] textArray) {
    Map<String, Integer> alliterationMap = new HashMap<>();
    Arrays.stream(textArray)
      .forEach(word -> {
        var firstLetter = word.substring(0, 1).toLowerCase();
        if(alliterationMap.containsKey(firstLetter)) {
          alliterationMap.put(firstLetter, alliterationMap.get(firstLetter) + 1);
        } else {
          alliterationMap.put(firstLetter, 1);
        }
      });

    return alliterationMap;
  }

  private String getPercentage(Double numberOfRepetitions, Double numberOfWords) {
    return decimalFormat.format((numberOfRepetitions / numberOfWords) * 100);
  }

  private String prepareResultString(List<Map.Entry<String, Integer>> alliterationList, Integer numberOfWords) {
    var alliterationResult = new StringBuilder();

    alliterationList.forEach(entry ->
      alliterationResult.append(entry.getKey())
        .append(SEPARATOR)
        .append(getPercentage(entry.getValue().doubleValue(), (double) numberOfWords))
        .append(PERCENTAGE_SYMBOL)
        .append("\n"));

    return alliterationResult.toString();
  }

  private String prepareResultString(Map<String, Integer> alliterationMap, Integer numberOfWords) {
    return alliterationMap.entrySet().stream()
      .max((entry1, entry2) -> entry1.getValue().compareTo(entry2.getValue()))
      .map(entry -> entry.getKey() + SEPARATOR + getPercentage((double) entry.getValue(), (double) numberOfWords))
      .orElse(null);
  }
}
