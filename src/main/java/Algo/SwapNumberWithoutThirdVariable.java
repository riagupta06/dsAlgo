package Algo;

public class SwapNumberWithoutThirdVariable {

    public static void main (String[] args) {
        int a = 3;
        int b = 8;
        System.out.println(a + " " + b);
        b = a+b; //11
        a = b-a; //8
        b = b-a; //3
        System.out.println(a + " " + b);
    }

}
