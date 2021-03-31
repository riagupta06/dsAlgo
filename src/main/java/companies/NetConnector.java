package companies;


import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NetConnector {

    public static int getSumOfNaturalNumber(int naturalNumber) {

        return IntStream
                .range(0, naturalNumber+1).sum();


    }

    public static int[] sorthingWithoutThirdVariable(int[] inArr) {

        int j,k;

//        for(j=0;j<inArr.length;j++) {
//            for(k=j;k<inArr.length;k++) {
//                if(inArr[j]>inArr[k]) {
//                    inArr[j]=inArr[j]+inArr[k];
//                    inArr[k]=inArr[j]-inArr[k];
//                    inArr[j]=inArr[j]-inArr[k];
//
//                }
//            }
//
//        }

        return inArr;
    }

    public static void swapUsingThirdVariable(int a, int b) {
        a = a + b;
        b = a - b;
        a = a - b;

        System.out.println("Reversed Numbers a: "+a+"b :"+b);
    }

    public static String reverseAString(String sentence) {


        String[] sentenceArr = sentence.split(" ");

        return IntStream
                .range(0, sentenceArr.length)
                .map(i -> sentenceArr.length-1 - i)
                .mapToObj(a -> sentenceArr[a])
                .collect(Collectors.joining(" "));


    }

    public static boolean identifyIfPalindrome(String string) {


        String tempString  = string.toLowerCase();
        return IntStream.range(0, tempString.length() / 2)
                .noneMatch(i -> tempString.charAt(i) != tempString.charAt(tempString.length() - i - 1));


    }





    public static void main(String[] args) {
        String arr = "lakshey";
        System.out.println(identifyIfPalindrome("I am the good bou"));
    }
}

