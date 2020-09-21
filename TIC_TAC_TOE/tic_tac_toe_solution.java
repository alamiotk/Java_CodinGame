import java.util.*;
import java.io.*;
import java.math.*;

class Solution {

    public static void main(String args[]) {

        String[][] array = new String[3][3];
       

        String[] lineString = new String[3];
        Scanner in = new Scanner(System.in);

        for (int i = 0; i < 3; i++) {
            String line = in.nextLine();
            lineString[i] = line;
            String[] tempArr = line.split("");
            for (int j = 0; j < tempArr.length; j++) {
                array[i][j] = tempArr[j];    
            }
        }

        calculate(array, lineString); 
    }


    static int calculate(String[][] array, String[] lineString) {
        int numberHeightO = 0;
        int numberWidthO = 0;
        int numberWidthX = 0;
        int numberHeightX = 0;
        int numberO = 0;

        for (int i = 0; i < 3; i++){
            for (int s = 0; s < 3; s++){
                
                if(array[i][s].equals("O")){
                    numberWidthO++;
                    numberO++;
                }
                else if(array[i][s].equals("X")){
                    numberWidthX++;
                }
                if(array[s][i].equals("O")){
                    numberHeightO++;
                    numberO++;
                }
                else if(array[s][i].equals("X")){
                    numberHeightX++;
                } 
            }
            if(numberWidthO == 2 && numberWidthX == 0){
                printW(lineString, i);
                return 1;
            }
            if(numberHeightO == 2 && numberHeightX == 0){
                printH(array, i);
                return 1;
            }
            numberWidthO = 0;
            numberHeightO = 0;
        }
        

        int f = 0;
        numberHeightO = 0;
        numberHeightX = 0;

        for(int i = 0; i < 3; i++, f++){
            if(array[i][f].equals("O")){
                numberHeightO++;
            }
            else if(array[i][f].equals("X")){
                numberHeightX++;
            }
            if(numberHeightO == 2 && numberHeightX == 0){
                printD0(array);
                return 1;
            }
            else if(numberHeightX >= 1){
                System.out.println("false");
                return 1;
            }
        }

        numberHeightO = 0;
        numberHeightX = 0;
        f = 0;
        
        for(int i = 2; i >= 0; i--, f++){
            if(array[i][f].equals("O")){
                numberHeightO++;
            }
            else if(array[i][f].equals("X")){
                numberHeightX++;
            }
            if(numberHeightO == 2 && numberHeightX == 0){
                printD2(array);
                return 1;
            }
            else if(numberHeightX >= 1){
                System.out.println("false");
                return 1;
            }
        }

        if (numberO == 0){
            System.out.println("false");
            return 1;
        }
       
        return 0;
    }

    static void printW(String[] lineString, int i){
        for(int k = 0; k < 3; k++){
            if(i == k){
                System.out.println("OOO");
            }
            else{
                System.out.println(lineString[k]);   
            }
        }
    }

    static void printH(String[][] array, int j){
        String temp = "";
        for(int k = 0; k < 3; k++){
            temp = "";
            for(int m = 0; m < 3; m++){
                if(m == j){
                    temp += "O";
                }
                else{
                    temp += array[k][m];
                }
                
            }
            System.out.println(temp);
           
        }
    }

    static void printD0(String[][] array){
        String temp = "";
        for(int k = 0; k < 3; k++){
            temp = "";
            for(int m = 0; m < 3; m++){
                if(k == m){
                    temp += "O";
                }
                else{
                    temp += array[k][m];
                }
            }
            System.out.println(temp);
        }
    }

    static void printD2(String[][] array){
        String temp = "";
        int p = 2;
        
        for(int k = 0; k < 3; k++, p--){
            temp = "";
            for(int m = 0; m < 3; m++){
                if(k + m == 2){
                    temp += "O";
                }
                else{
                    temp += array[k][m];
                }
                
            }
            System.out.println(temp);
           
        }
    }
}
