import java.util.*;
import java.io.*;
import java.math.*;

class Solution {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int result = 0;

        List<Integer> listA = new ArrayList<>();

        int N = in.nextInt();
        int L = in.nextInt();

        if (in.hasNextLine()) {
            in.nextLine();
        }
        for (int i = 0; i < N; i++) {
            String LINE = in.nextLine();
            String[] arr = LINE.split(" ");      

            for (int j = 0; j < N; j++){
                if (arr[j].equals("C")){
                    listA.add(i);
                    listA.add(j);
                }
            }
        }
        int number = 0;

        for(int i = 0; i < N; i++){
            for(int j = 0; j < N; j++){
                result = calculate(i, j,listA, L);

                if(result == 0){
                    number++;
                }
            }
        }
        System.out.println(number);
    }

    static Integer calculate(Integer i, Integer j, List<Integer> listA, Integer L) {
        int result = 0; 
        for(int row = 0; row < listA.size()-1; row += 2){
            if(i == listA.get(row) && j == listA.get(row+1)){
                return result = 1;
            }
            
            double res = Math.max(Math.abs(i - listA.get(row)), Math.abs(j - listA.get(row+1)));
            double Ld = L;

            if(res < Ld){
                result += 1;
            } 
            if(res >= Ld) {
                result += 0;
            } 
        }
        return result;
    }

}
