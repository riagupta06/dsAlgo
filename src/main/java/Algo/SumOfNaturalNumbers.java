package Algo;

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
        int sum = 0;
        for(int i = 1; i <= n; i++) {
            sum += i;
        }
        System.out.println(sum);
    }

}
