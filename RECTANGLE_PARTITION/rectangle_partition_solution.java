import java.util.*;
import java.io.*;
import java.math.*;
import java.util.ArrayList;
import java.util.List;

class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int w = in.nextInt();
        int h = in.nextInt();
        int countX = in.nextInt();
        int countY = in.nextInt();
        
        List<Integer> listX = new ArrayList<Integer>();
        List<Integer> listY = new ArrayList<Integer>();

        Map<Integer, Integer> listVecX = new HashMap<Integer, Integer>();
        Map<Integer, Integer> listVecY = new HashMap<Integer, Integer>();

        listX.add(0);
        listY.add(0);

        for (int i = 0; i < countX; i++) {
            int x = in.nextInt();
            listX.add(x);
        }

        for (int i = 0; i < countY; i++) {
            int y = in.nextInt();
            listY.add(y);
        }

        listX.add(w);
        listY.add(h);


        int k = 0;
        for (int i = 1; i < listX.size(); i++) {
            for(int j = 0; j < i; j++){
                k = listX.get(i) - listX.get(j);
                if (!listVecX.containsKey(k))
                    listVecX.put(k, 0);
                listVecX.put(k, listVecX.get(k) + 1);
                
            }
        }

        int p = 0;
        for (int i = 1; i < listY.size(); i++) {
            for(int j = 0; j < i; j++){
                p = listY.get(i) - listY.get(j);
                if (!listVecY.containsKey(p))
                    listVecY.put(p,0);    
                listVecY.put(p, listVecY.get(p) + 1);
            }
        }

        int sizeN = 0; 

        if ( listVecX.size() < listVecY.size()){
            sizeN = listVecX.size();
        }
        else {
            sizeN = listVecY.size();
        }

        int sum = 0; 

        for(int i : listVecX.keySet()){
            if(listVecX.get(i) != null && listVecY.get(i) != null){
                sum += listVecX.get(i) * listVecY.get(i);
                
            }
        }

        System.out.println(sum);
    }
}
