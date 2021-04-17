package array;

public class SortArrayOf0And1 {

    public static void main(String[] args) {
        int[] arr = {1,1,1,0,0,0,1,0,0,1};
        int i = 0;
        int j = arr.length-1;
        while(i<j) {
            if(arr[i] == 0) {
                i++;
            }
            if(arr[j] == 1) {
                j--;
            }
            if(arr[i] > arr[j]) {
                arr[i] = 0;
                arr[j] = 1;
                i++; j--;
            }
        }
        for(int k=0; k<arr.length; k++)
            System.out.println(arr[k]);
    }

}
