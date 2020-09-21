import java.util.*;
import java.io.*;
import java.math.*;


class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();

        List<Horse> list = new ArrayList<>();
        
        int diff = 0;
        int dmin = 10000000;

        for (int i = 0; i < N; i++) {
            int V = in.nextInt();
            int E = in.nextInt();

            Horse horse = new Horse(V,E);
            list.add(horse);
        }

        for (int i = 0 ; i < list.size(); i++) {
            for(int j = i + 1; j < list.size(); j++){
                diff = Math.abs(list.get(j).velocity - list.get(i).velocity) + 
		Math.abs(list.get(j).elegance - list.get(i).elegance);
                if(diff < dmin) {
                    dmin = diff;
                }
            }
        }

        System.out.println(dmin);
    }
}

class Horse{
    public int velocity;
    public int elegance;

    Horse(int velocity, int elegance) {
        this.velocity = velocity;
        this.elegance = elegance;
    }
}
