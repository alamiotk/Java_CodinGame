import java.util.*;
import java.io.*;
import java.math.*;


class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        String MESSAGE = in.nextLine();

        String binary = toBinary(MESSAGE);

        String result = toSubstring(binary);

        System.out.println(result.trim());
    }


    static String toSubstring(String binary) {
        int N = binary.length();
        String encodeString = "";
        String tempSubString = "";
        int number = 1;
        String encode = "";

        for(int i = 1; i < N; i++) {
            if (binary.charAt(i-1) == binary.charAt(i)) {
                number++;
            }
            else {
                tempSubString = binary.substring(i-number, i);
                encode += toEncode(tempSubString, encodeString);
                number = 1; 
                if(i == N-1){
                    tempSubString = binary.substring(i);
                    encode += toEncode(tempSubString, encodeString);
                    number = 1; 
                }
            }
        }
        if(number >=2){
              tempSubString = binary.substring(N-1-number, N-1);
                encode += toEncode(tempSubString, encodeString);   
        }
    
        return encode;
    }


    static String toEncode(String temp, String encodeString){
        int N = temp.length();
        
        String zero = "0";

        if(temp.contains("1")) {
            encodeString += "0 " + zero.repeat(N);

        }
        else{
            encodeString += "00 " + zero.repeat(N);
        }

        encodeString += " ";
        return encodeString;
    }

    static String toBinary(String MESSAGE){
        int N = MESSAGE.length();
        String binary = "";
        String binary1 = "";

        for(int i = 0; i < N; i++) {
            int val = Integer.valueOf(MESSAGE.charAt(i));

            binary = Integer.toBinaryString(val);
            String zero = "0";

            if (binary.length() < 7) {
                binary = zero.repeat(7-binary.length()) + binary;
            }
        binary1 += binary;
            
        }    
        return binary1;
    }
}
