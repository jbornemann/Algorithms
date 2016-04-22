package com.jborn.algorithms.dynamic;


import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static java.util.Map.Entry;

public class MapReduceSublist {

    public static void longestAscendingSublist() {
        printResults(Arrays.asList(1, 2, 3, 5, 1, 2, 3, 4, 5));
        printResults(Arrays.asList(0));
        printResults(Arrays.asList(0, 1));
    }

    private static void printResults(List<Integer> inputList) {
        Map<Integer, Integer> map = map(inputList);
        System.out.println(map.toString());

        Map<Integer, Integer> reduceMap = reduce(map);
        System.out.println(reduceMap.toString());

        Entry entry = reduceMap.entrySet().iterator().next();
        System.out.println(inputList.subList(((Integer)entry.getKey() - (Integer)entry.getValue()) + 1, (Integer)entry.getKey() + 1));
    }


    private static Map<Integer, Integer> map(List<Integer> list) {
        Map entries = new HashMap<Integer, Integer>();
        if(list.isEmpty()) {
            entries.put(0, 0);
            return entries;
        }
        //First entry will always have a counter of 1 in a sublist
        entries.put(0, 1);
        int counter = 1;
        for(int index = 1; index < list.size(); index++) {
            int curr = list.get(index);
            if(curr == (list.get(index - 1) + 1)){
                counter++;
            }
            else {
                counter = 1;
            }
            entries.put(index, counter);
        }
        return entries;
    }

    private static Map<Integer, Integer> reduce(Map<Integer, Integer> map) {
        int bestCaseKey = 0;
        int bestCaseValue = 0;
        Set<Integer> keySet = map.keySet();
        for(int key : keySet) {
            int curr = map.get(key);
            if(curr > bestCaseValue) {
                bestCaseValue = curr;
                bestCaseKey = key;
            }
        }
        Map<Integer, Integer> reduced = new HashMap<Integer, Integer>();
        reduced.put(bestCaseKey, bestCaseValue);
        return reduced;
    }
}
