package Algo;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class DocumentChunking {

    static int pow2(long N) {
        int ans = 0;
        for (int i = 0; i < 64; i++) {
            long x = 1;
            if ((N & (x << i)) > 0) ans++;
        }
        return ans;
    }


    public static int minimumChunksRequired(long total, List<List<Long>> uploadedChunks) {

        //sorting the uploaded chunks
        Collections.sort(uploadedChunks , new Comparator<List<Long>>() {
            public int compare(List<Long> l1 , List<Long> l2){
                return (int) (l1.get(0)-l2.get(0));
            }
        });

        long lastChunkNum = 1;
        int ans = 0;
        for (int i = 0; i < uploadedChunks.size(); i++) {
            long start = uploadedChunks.get(i).get(0);
            long end = uploadedChunks.get(i).get(1);
            ans+=pow2(start-lastChunkNum);
            lastChunkNum = end+1;
        }

        if(uploadedChunks.get(uploadedChunks.size()-1).get(1)!=total){
            ans+=pow2(total - uploadedChunks.get(uploadedChunks.size()-1).get(1));
        }
        return ans;
    }

    public static void main(String[] args) {
//        List<List<Long>> list = new ArrayList<>();
//        List<Long> list1 = new ArrayList<>();
//        list1.add(1L);
//        list1.add(2L);
//        List<Long> list2 = new ArrayList<>();
//        list2.add(9L);
//        list2.add(10L);
//        list.add(list1);
//        list.add(list2);
//        minimumChunksRequired(10, list);


        List<List<Long>> list = new ArrayList<>();
        List<Long> list1 = new ArrayList<>();
        list1.add(9L);
        list1.add(17L);

        list.add(list1);
        minimumChunksRequired(18, list);

    }
}
