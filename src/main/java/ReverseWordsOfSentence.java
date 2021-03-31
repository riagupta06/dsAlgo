public class ReverseWordsOfSentence {

    public static void main(String[] args) {
        String sentence = "I am good boy";
        String[] strings = sentence.split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i = strings.length-1; i>=0; i--) {
            sb.append(strings[i]).append(" ");
        }
        System.out.println(sb.substring(0, sb.toString().length()-1));
    }

}
