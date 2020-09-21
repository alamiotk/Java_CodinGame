import java.util.*;
import java.io.*;
import java.math.*;

class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        long r1 = in.nextLong();
        long r2 = in.nextLong();
        long n = 20000000;

        Map<Long, Integer> map1 = new HashMap<>();
        Map<Long, Integer> map2 = new HashMap<>();

        map1.put(r1, 1);
        map2.put(r2, 1);

        boolean p = condition(r1,r2, map1, map2);

        while (p == false){
  
            r1 = calculateR1(r1);
            r2 = calculateR2(r2);

            map1.put(r1,1);
            map2.put(r2,1);
            
            p = condition(r1, r2, map1, map2);
        }      
    }


    static boolean condition(long r1, long r2, Map<Long, Integer> map1, Map<Long, Integer> map2) {
        if (map1.containsKey(r2)){
            System.out.println(r2);
            return true;
        }
        else if (map2.containsKey(r1)){
            System.out.println(r1);
            return true;
        }
        else {
            return false;
        }
    }


    static long calculateR1(long r1) {

        String r1S = Long.toString(r1);

        String[] arr1 = r1S.split("");

        long sum1 = 0;

        for(int i = 0; i < arr1.length; i++){
            long digit1 = Long.parseLong(arr1[i]);
            sum1 += digit1;
        }


        return r1 += sum1;
    }

     static long calculateR2(long r2) {

        String r2S = Long.toString(r2);

        String[] arr2 = r2S.split("");

        long sum2 = 0;

        for(int i = 0; i < arr2.length; i++){
            long digit2 = Long.parseLong(arr2[i]);
            sum2 += digit2;
        }

        return r2 += sum2;
    }


}
