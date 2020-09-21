import java.util.*;
import java.io.*;
import java.math.*;


class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int r1 = in.nextInt();
        int rGap = 1;
        int temp = 0;
        
        while(temp != 3 && rGap < r1){
            int rNew = r1 - rGap;
            int sum1 = calculate(rNew);
            if(sum1 == rGap ){
                temp++;
            }
            rGap++;   
        }

        if(temp >= 1) {
                System.out.println("YES");
        }
        else{
            System.out.println("NO");
        }
    }


    static Integer calculate(int r1){

        String r1String = Integer.toString(r1);
        String[] arr1 = r1String.split("");
        int sum1 = 0;

        for(int i = 0; i < arr1.length; i++){
            int digit = Integer.parseInt(arr1[i]);
            sum1 += digit;
        }

        return sum1;

    }
}
