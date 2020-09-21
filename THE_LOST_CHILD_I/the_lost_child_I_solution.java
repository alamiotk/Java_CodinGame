import java.util.*;
import java.io.*;
import java.math.*;
import java.util.Arrays;

class Solution {

    public static void main(String args[]) {

        String[][] arr = new String[10][10];
        List<Point> toVisit = new ArrayList<>();
        List<Point> points = new ArrayList<>();

        int[][] distances = new int[10][10];

        for (int[] row : distances) {
            Arrays.fill(row, 9999999);
        }
        Point M = new Point(0, 0);
    
        Scanner in = new Scanner(System.in);
        for (int i = 0; i < 10; i++) {
            String row = in.nextLine();
            String[] arrTemp = row.split("");
            for (int j = 0; j < arrTemp.length; j++){
                arr[i][j] = arrTemp[j];

                if(arr[i][j].equals("C")) {
                    Point point = new Point(i, j);
                    toVisit.add(point);
                    distances[i][j] = 0;
                }
                else if(arr[i][j].equals("M")){
                    M.x = i;
                    M.y = j;
                }
            }
        }

        int dist = 10;
        Point point1 = new Point(-1,0);
        Point point2 = new Point(0,1);
        Point point3 = new Point(1,0);
        Point point4 = new Point(0,-1);

        points.add(point1);
        points.add(point2);
        points.add(point3);
        points.add(point4);

        while(toVisit.size() > 0){
            if(toVisit.get(0).x == M.x && toVisit.get(0).y == M.y) {
                System.out.println(distances[toVisit.get(0).x][toVisit.get(0).y] + "km");
                break;
            }

            for (Point item : points) {
                Point tempPoint = new Point(toVisit.get(0).x + item.x, toVisit.get(0).y + item.y);
                if(tempPoint.x >= 0 && tempPoint.x <= 9 && tempPoint.y >= 0 && tempPoint.y <=9 && 
			distances[tempPoint.x][tempPoint.y] == 9999999){

                    if(arr[tempPoint.x][tempPoint.y].equals("#")){
                        continue;
                    }
                    distances[tempPoint.x][tempPoint.y] = distances[toVisit.get(0).x][toVisit.get(0).y] + 10;
                    toVisit.add(tempPoint);
                } 
            }
            toVisit.remove(toVisit.get(0));;
        }
    } 
}

class Point{
    public int x;
    public int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
