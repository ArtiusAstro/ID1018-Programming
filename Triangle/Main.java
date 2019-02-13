import java.util.Arrays;
import java.util.Scanner;

public class Main {

    private static int menu(Scanner sc){
        System.out.println("1.perimeter");
        System.out.println("2.area");
        System.out.println("3.median of a side");
        System.out.println("4.bisector of an angle");
        System.out.println("5.radius of incircle");
        System.out.println("6.circumference of incircle");
        System.out.println("Input a number corresponding to what you would like to compute, or 7 to quit: ");
        int temp=sc.nextInt();
        sc.nextLine();
        return temp;
    }

    public static void main(String[] args){
        boolean quit = false;
        double[] temp;
        try(Scanner sc = new Scanner(System.in)){
            System.out.println("Input 1 if you want to declare a triangle or 2 to go static");
            int choice=sc.nextInt();
            sc.nextLine();
            if(choice==1){
                System.out.println("Input the sides a,b,c and angles A,B,C in the format \"a,b,c,A,B,C\", or 0 if unspecified: ");
                double[] vars = Arrays.stream(sc.nextLine().split(","))
                        .mapToDouble(Double::parseDouble).toArray();
                Triangle tri = new Triangle(vars[0],vars[1],vars[2],vars[3],vars[4],vars[5]);
                do {
                    switch (menu(sc)){
                        case 1: System.out.println(tri.perimeter());
                            break;
                        case 2: System.out.println(tri.area());
                            break;
                        case 3:  System.out.print("Input which side a/b/c you'd like the median of: ");
                            System.out.println(tri.median(sc.nextLine().charAt(0)));
                            break;
                        case 4:  System.out.print("Input the angle A/B/C you'd like the bisector of: ");
                            System.out.println(tri.bisector(sc.nextLine().charAt(0)));
                            break;
                        case 5: System.out.println(tri.radius());
                            break;
                        case 6: System.out.println(tri.circumference());
                            break;
                        case 7:   quit=true;
                    }
                } while (!quit);
            }
            else{
                do {
                    switch (menu(sc)){
                        case 1:  System.out.println("Input the sides a,b,c: ");
                            temp = Arrays.stream(sc.nextLine().split(","))
                                    .mapToDouble(Double::parseDouble).toArray();
                            System.out.println(TriangleStatic.perimeter(temp[0],temp[1],temp[2]));
                            break;
                        case 2:  System.out.println("Input the sides a,b,c: ");
                            temp = Arrays.stream(sc.nextLine().split(","))
                                    .mapToDouble(Double::parseDouble).toArray();
                            System.out.println(TriangleStatic.area(temp[0],temp[1],temp[2]));
                            break;
                        case 3:  System.out.print("Input which side a you'd like the median of, as well as the other sides of the triangle(a,b,c): ");
                            temp = Arrays.stream(sc.nextLine().split(","))
                                    .mapToDouble(Double::parseDouble).toArray();
                            System.out.println(TriangleStatic.median(temp[0],temp[1],temp[2]));
                            break;
                        case 4:  System.out.print("Input the angle A and its two sides(A,b,c): ");
                            temp = Arrays.stream(sc.nextLine().split(","))
                                    .mapToDouble(Double::parseDouble).toArray();
                            System.out.println(TriangleStatic.bisector(temp[0],temp[1],temp[2]));
                            break;
                        case 5:  System.out.println("Input the sides a,b,c: ");
                            temp = Arrays.stream(sc.nextLine().split(","))
                                    .mapToDouble(Double::parseDouble).toArray();
                            System.out.println(TriangleStatic.radius(temp[0],temp[1],temp[2]));
                            break;
                        case 6:  System.out.println("Input the sides a,b,c: ");
                            temp = Arrays.stream(sc.nextLine().split(","))
                                    .mapToDouble(Double::parseDouble).toArray();
                            System.out.println(TriangleStatic.circumference(temp[0],temp[1],temp[2]));
                            break;
                        case 7:   quit=true;
                    }
                } while (!quit);
            }
        }
    }
}
