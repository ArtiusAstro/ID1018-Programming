import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        System.out.println("Input integers \"m,n,d\" where m is the numOfStations in Zone2, n in Zone3, and d is the max length of a path");
        Scanner sc=new Scanner(System.in);
        Random rnd=new Random();
        String temp=sc.nextLine();
        int[] vars = Arrays.stream(temp.split(","))
                .mapToInt(Integer::parseInt).toArray();
        Map map = new Map(vars[0],vars[1],vars[2]);
        System.out.println("Shortest path is X-"+map.findShortestPath()+"-Y");
        System.out.println("Distance of the shortest path is "+map.findShortestDistance());
    }
}
