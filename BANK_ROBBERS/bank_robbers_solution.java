import java.util.*;
import java.io.*;
import java.math.*;

class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int R = in.nextInt();
        int V = in.nextInt();
        double result = 0;
        int res = 0;
        int maxRes = 0;

        List<Integer> list = new ArrayList<>();

        List<Integer> listMax = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            int C = in.nextInt();
            int N = in.nextInt();
            result = Math.pow(5,(C-N)) * Math.pow(10,N);
            res = (int)result;
            list.add(res);
        }

        int i = 0;

        if(R < V) {
            while(list.size() > 0 && i < R){
                int max = list.get(0);
                listMax.add(max);
                list.remove(list.get(0));
                i++;
            }

            while(list.size() > 0) {
                int min = Collections.min(listMax);
                int max = list.get(0);
                min += max;
                list.remove(list.get(0));
                listMax.remove(Collections.min(listMax));
                listMax.add(min);
            }

            maxRes = Collections.max(listMax);
        }
        else {
            int max = Collections.max(list);
            maxRes = max;
        }

        System.out.println(maxRes);
    }
}
