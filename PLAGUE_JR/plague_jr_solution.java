import java.util.*;
import java.io.*;
import java.math.*;


class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);

        List<Integer> list = new ArrayList<>();
        Map<Integer, List<Integer> > map = new HashMap<>();
        Map<Integer, Integer> BFSmap = new HashMap<>();

        int N = in.nextInt();
        for (int i = 0; i < N; i++) {
            int A = in.nextInt();
            int B = in.nextInt();

            map.computeIfAbsent(A, tempA -> new ArrayList<>()).add(B);
            map.computeIfAbsent(B, tempB -> new ArrayList<>()).add(A);          
        }

        for (Integer key : map.keySet()){
            BFS(key, BFSmap, map);
        }

        int min = Collections.min(BFSmap.values());
        System.out.println(min);
    }

    static void BFS (int firstParent, Map<Integer, Integer> BFSmap, Map<Integer, List<Integer> > map) {
        List<Integer> toVisit = new ArrayList<>();
        Map<Integer, Integer> visited = new HashMap<>();
        int parentDistance = 0; 
        toVisit.add(firstParent);
        visited.put(firstParent, parentDistance);
        int parent = 0;
        int number = 0;
        int p = 0;

        while(toVisit.size() > 0){
            p++;
            parent = toVisit.get(0);
            parentDistance = visited.get(parent);

            if (map.containsKey(parent)) {
                List<Integer> value = map.get(parent);

                for (int i = 0; i < value.size(); i++) {
                    int child = value.get(i);
                    
                    int parentDistance2 = parentDistance;

                    if(!visited.containsKey(child)){
                        toVisit.add(child);
                        visited.put(child, parentDistance2 += 1);
                    }
                }
            }
            toVisit.remove(toVisit.get(0));
        }
        BFSmap.put(firstParent, parentDistance);
    }
}
