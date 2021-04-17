package algo;

import java.util.HashSet;
import java.util.Set;

public class Hackerrank_SalesByMatch {

    // Complete the sockMerchant function below.
    static int sockMerchant(int n, int[] ar) {
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < n; i++) {
            if(set.contains(ar[i])) {
                set.remove(ar[i]);
            } else {
                set.add(ar[i]);
            }
        }
        return set.size();
    }

    public static void main(String[] args)  {

        int[] ar = {1, 1, 3, 1, 2, 1, 3, 3, 3, 3};

        int result = sockMerchant(ar.length, ar);
        System.out.println(result);
    }

}
