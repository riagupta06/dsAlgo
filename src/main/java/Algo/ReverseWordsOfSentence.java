package Algo;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ReverseWordsOfSentence {

    public static String reverseAString(String sentence) {


        String[] strings = sentence.split(" ");

        StringBuilder sb = new StringBuilder();
        for(int i = strings.length-1; i>=0; i--) {
            if(i == 0) {
                sb.append(strings[i]);
            } else {
                sb.append(strings[i]).append(" ");
            }
        }
        return sb.toString();



    }

    public static void main(String[] args) {
        String sentence = "I am good boy";
        String[] strings = sentence.split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i = strings.length-1; i>=0; i--) {
            if(i == 0) {
                sb.append(strings[i]);
            } else {
                sb.append(strings[i]).append(" ");
            }
        }
        System.out.println(sb);
    }

}
