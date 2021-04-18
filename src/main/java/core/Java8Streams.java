package core;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.Map;
import java.util.stream.Collectors;

public class Java8Streams {

    public static void main(String[] args) {
        int[] arr = {1,2,3,3,2,4,1,2,4,5};
        //summaryStatistics
        IntSummaryStatistics intSummaryStatistics = Arrays.stream(arr)
                .summaryStatistics();
        System.out.println(intSummaryStatistics.getAverage());
        System.out.println(intSummaryStatistics.getMax());
        System.out.println(intSummaryStatistics.getCount());
        System.out.println(intSummaryStatistics.getMin());
        System.out.println(intSummaryStatistics.getSum());

        /*
         * given array of numbers, find occurrence of each number
         * i.e. group by array elements and count
         */
        Map<Integer, Long> collect = Arrays.stream(arr)
                .boxed()
                .collect(Collectors.groupingBy(s -> s, Collectors.counting()));
        System.out.println(collect);

    }

}
