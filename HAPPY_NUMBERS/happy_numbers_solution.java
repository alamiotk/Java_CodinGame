import java.util.*;
import java.io.*;
import java.math.*;

class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        
        List<String> list = new ArrayList<String>();
       
        int N = in.nextInt();

        if (in.hasNextLine()) {
            in.nextLine();
        }
        for (int i = 0; i < N; i++) {
            String x = in.nextLine();

            list.add(x);
        }



        for (String temp : list) { 
            int layer = 0;  

            boolean p = recursive(temp, layer);

            if(p == true){
            System.out.println(temp + " :)");
            }
            
            else{
            System.out.println(temp + " :(");
            }
        }
    }

    static boolean recursive(String temp, int layer) {
        String[] arr = temp.split("");
        int sum = 0; 
            for (int j = 0; j < arr.length; j++) {
                int digit = Integer.parseInt(arr[j]);
                sum += Math.pow(digit, 2);
            }

            String sumS = Integer.toString(sum);
            

            if(sumS.equals("1")){
                return true;
            }
            else if(layer == 1000) {
                return false;

            }

            else{ 
                layer++;
                return recursive(sumS, layer);
            }
        
    }
}
