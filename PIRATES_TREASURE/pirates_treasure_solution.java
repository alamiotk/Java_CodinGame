import java.util.*;
import java.io.*;
import java.math.*;

class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int W = in.nextInt();
        int H = in.nextInt();

        int[][] arr = new int[H][W];
        

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                arr[i][j] = in.nextInt();
            }
        }

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if (arr[i][j] == 0){
                    int number = checkTreasure(i, j, W, H, arr);
                    if (number == 8){
                        System.out.println(j + " " + i);
                        System.exit(0);
                    }
                }
            }
        }
    }

    static int checkTreasure(int i, int j, int W, int H, int[][] arr){
        int[][] ones = {{-1,-1}, {-1,0}, {-1,1}, {0,1}, {1,1}, {1,0}, {1,-1}, {0,-1}};
        int k = 0;
        int number = 0;

        for (int p = 0; p < 8; p++){
            int iTemp = i + ones[p][k];
            int jTemp = j + ones[p][k + 1];

            if ( (iTemp >= H)|| (iTemp < 0) || 
                (jTemp >= W) || (jTemp < 0) ||
                (arr[iTemp][jTemp] != 0) ){
                    number++;
            }
            else {
                return 0;
            }
        }
        return number;
    }
}

