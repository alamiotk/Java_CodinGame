import java.util.*;
import java.io.*;
import java.math.*;
import static java.lang.Math.*;

class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int min = 1000000;
        int n = in.nextInt(); // the number of temperatures to analyse
        
        int[] tab = new int[n];

        for (int i = 0; i < n; i++) {
            tab[i]= in.nextInt(); // a temperature expressed as an integer ranging from -273 to 5526
        }

        if(tab.length != 0) {
            for (int i = 0; i < n; i++) {
                if (tab[i] < 0){
                    if(abs(tab[i]) < abs(min)){
                        min = tab[i];
                    }
                }
                else if (tab[i] <= abs(min)){
                    min = tab[i];
                }
            }       
        }
        else {
            min = 0;
        }

        System.out.println(min);
    }
}
