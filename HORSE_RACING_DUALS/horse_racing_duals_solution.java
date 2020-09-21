import java.util.*;
import java.io.*;
import java.math.*;

class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();

        int N = in.nextInt();
        for (int i = 0; i < N; i++) {
            int pi = in.nextInt();
            list.add(pi);
        }

        Collections.sort(list);

        int diff = 0;
        int dmin = 10000000;

        for(int i = 0; i < list.size() - 1; i++) {
            diff = list.get(i) - list.get(i+1);
            diff = Math.abs(diff);
            if (diff < dmin) {
                dmin = diff;
            }
        
        }

        System.out.println(dmin);
    }
}
