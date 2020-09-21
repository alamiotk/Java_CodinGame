import java.util.*;
import java.io.*;
import java.math.*;

class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);

        Set<Integer> digits = new HashSet<>();
        Set<Integer> digitsColumns = new HashSet<>();
        Set<Integer> subgrid = new HashSet<>();

        int n = 0;
        int[][] arr = new int[9][9];
        int[][] subgridSquere = new int[3][3];

        try{
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    arr[i][j] = in.nextInt();
                    digits.add(arr[i][j]);
                }
                if(digits.size() != 9) {
                    throw new Exception(); 
                }
                digits.clear();
            }

            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    n = arr[j][i];
                    digitsColumns.add(n);
                }
                if(digitsColumns.size() != 9) {
                    throw new Exception(); 
                }
                digitsColumns.clear();
            }    

            for (int i = 0; i < 9; i += i+3) {
                for (int j = i; j < i + 3; j++) {
                    n = arr[i][j];
                    subgrid.add(n);
                    n = arr[i+1][j];
                    subgrid.add(n);
                    n = arr[i+2][j];
                    subgrid.add(n);
                
                }
                if(subgrid.size() != 9) {
                    throw new Exception(); 
                }
                subgrid.clear();
            }
       
        System.out.println("true");


        }
        catch(Exception e) {
            System.out.println("false");
        }

    }
}
