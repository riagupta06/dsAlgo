package core;

import java.util.*;
import java.util.stream.Collectors;

public class HashMapSortByValues {

    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("Ria", 2);
        map.put("Rishabh", 1);
        map.put("Kiran", 3);

        //sort by values
        List<Map.Entry<String, Integer>> collect = map.entrySet().stream().sorted(Comparator.comparingInt(value -> value.getValue())).collect(Collectors.toList());
        System.out.println(collect);

        //reverse sort
        Comparator<Map.Entry<String, Integer>> reversed = getComparator().reversed();
        List<Map.Entry<String, Integer>> collectList = map.entrySet().stream().sorted(reversed).collect(Collectors.toList());
        System.out.println(collectList);
    }

    private static Comparator<Map.Entry<String, Integer>> getComparator() {
        return Comparator.comparingInt(value -> value.getValue());
    }

}
