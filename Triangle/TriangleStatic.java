public class TriangleStatic {

    public static double perimeter(double a, double b, double c){
        return a+b+c;
    }
    public static double area(double a, double b, double c){
        //this shall use the Heroni formula
        double p=perimeter(a,b,c)/2;
        return Math.sqrt(p*(p-a)*(p-b)*(p-c));
    }
    public static double median(double a, double b, double c){
        return 0.5*Math.sqrt((2*b*b)+(2*c*c)-(a*a));
    }
    public static double bisector(double angle, double a, double b){
        double p=2*a*b*Math.cos(angle);
        return p/(a+b);
    }
    public static double radius(double a, double b, double c){
        double semiperimeter=0.5*perimeter(a,b,c);
        return area(a,b,c)/semiperimeter;
    }
    public static double circumference(double a, double b, double c){
        return 2*Math.PI*radius(a,b,c);
    }
}
