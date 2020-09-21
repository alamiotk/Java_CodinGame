import java.util.*;
import java.io.*;
import java.math.*;

class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        List<Integer> listNx = new ArrayList<>();
        List<Integer> listMx = new ArrayList<>();

        int n = in.nextInt();
        int m = in.nextInt();
        int c = in.nextInt();

        for (int i = 0; i < n; i++) {
            int nx = in.nextInt();
            listNx.add(nx);
        }
        for (int i = 0; i < m; i++) {
            int mx = in.nextInt();
            listMx.add(mx);
        }
        calculate(listNx, listMx, c);
    }

    public static int calculate(List<Integer> listNx, List<Integer> listMx, int c){
        int number = 0;
        int maxNumber = 0;
        List<Integer> items = new ArrayList<>();

        for (Integer item : listMx) {
            items.add(item);
            if (Collections.frequency(items, item) % 2 == 0){
                number -= listNx.get(item - 1);
            }
            else{
                number += listNx.get(item - 1);
                if (number > maxNumber) {
                    maxNumber = number;
                }
                if (number > c){
                    System.out.println("Fuse was blown.");
                    return 1;
                } 
            }
        }  
        System.out.println("Fuse was not blown.");
        System.out.println("Maximal consumed current was " + maxNumber + " A.");
        return 1;
    }
}
