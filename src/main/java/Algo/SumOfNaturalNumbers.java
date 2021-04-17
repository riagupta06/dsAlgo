package Algo;

import java.util.stream.IntStream;

public class SumOfNaturalNumbers {

    public static int getSumOfNaturalNumber(int n) {
        int sum = 0;
        for(int i = 1; i <= n; i++) {
            sum += i;
        }
        return sum;
    }

    public static void main(String args[]) {
        int n = 4;

        //basic
        System.out.println(getSumOfNaturalNumber(n));

        //java8
        int sum1 = IntStream.range(1, n + 1)
                .sum();
        System.out.println(sum1);
    }

}
