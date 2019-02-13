import java.util.Arrays;
import java.util.Scanner;

public class SortAlgo {
    public static int[] sort(int[] x){
        // takes an int array and sorts it using exchange sort
        int temp;
        for(int i=0;i<x.length-1;i++){
            for(int j=i+1;j<=x.length-1;j++){
                if(x[j]<x[i]){
                    temp=x[i];
                    x[i]=x[j];
                    x[j]=temp;
                }
            }
        } return x;
    }
    public static void main(String[] args){
        try(Scanner sc = new Scanner(System.in)){ // try with resource block ensures catches exceptions and ensures scanner closes
            System.out.println("Enter the elements of the set separated by a comma");
            int[]x=Arrays.stream(sc.nextLine().split(","))
                    .mapToInt(Integer::parseInt).toArray();
            System.out.println(Arrays.toString(sort(x)));
        }
        catch (Exception e){
            System.out.println("ERROR: " + e);
        }
    }
}
