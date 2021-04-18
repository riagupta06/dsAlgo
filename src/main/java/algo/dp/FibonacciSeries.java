package algo.dp;

import java.util.Arrays;

public class FibonacciSeries {

    public static void main(String[] args) {
        printFirstKNumbers(10);
    }

    private static void printFirstKNumbers(int n) {
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            if(i <= 1)
                arr[i] = i;
            else
                arr[i] = arr[i-1] + arr[i-2];
        }
        Arrays.stream(arr).forEach(System.out::println);
    }

}
