public class CheckIfStringIsPalindrome {

    public static void main(String[] args) {
        String input = "treaert1";
        boolean isPalindrome = isPalindrome(input);
        System.out.println(isPalindrome);
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
