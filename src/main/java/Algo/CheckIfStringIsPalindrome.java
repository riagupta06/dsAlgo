package Algo;

import java.util.stream.IntStream;

public class CheckIfStringIsPalindrome {

    public static void main(String[] args) {
        String input = "treaert1";

        //usual way
        System.out.println(isPalindrome(input));

        //java8
        boolean allMatch = IntStream.range(0, input.length() / 2)
                .allMatch(i -> input.charAt(i) == input.charAt(input.length() - 1 - i));
        System.out.println(allMatch);
    }

    private static boolean isPalindrome(String input) {
        int length = input.length();
        if(length > 1) {
            if(input.charAt(0) == input.charAt(length-1)) {
                return isPalindrome(input.substring(1, length-1));
            } else {
                return false;
            }
        } else {
            return true;
        }
    }

}
