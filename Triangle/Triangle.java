public class Triangle {
    private double a;
    private double b;
    private double c;
    private double A;
    private double B;
    private double C;

    public Triangle(double a,double b,double c, double A, double B, double C){
        this.a=a;
        this.b=b;
        this.c=c;
        this.A=A;
        this.B=B;
        this.C=C;
    }

    public double perimeter(){
        return this.a+this.b+this.c;
    }
    public double area(){
        //this shall use the Heroni formula
        double p=perimeter()/2;
        return Math.sqrt(p*(p-this.a)*(p-this.b)*(p-this.c));
    }
    public double median(char side){
        if(side=='a') return 0.5*Math.sqrt((2*this.b*this.b)+(2*this.c*this.c)-(this.a*this.a));
        if(side=='b') return 0.5*Math.sqrt((2*this.a*this.a)+(2*this.c*this.c)-(this.b*this.b));
        if(side=='c') return 0.5*Math.sqrt((2*this.a*this.a)+(2*this.b*this.b)-(this.c*this.c));
        else return 0;
    }
    public double bisector(char angle){
        if(angle=='A'){
            double p=2*this.b*this.c*Math.cos(this.A);
            return p/(this.b+this.c);
        }
        if(angle=='B'){
            double p=2*this.b*this.c*Math.cos(this.A);
            return p/(this.b+this.c);
        }
        if(angle=='C'){
            double p=2*this.b*this.c*Math.cos(this.A);
            return p/(this.b+this.c);
        }
        else return 0;
    }
    public double radius(){
        double semiperimeter=0.5*perimeter();
        return area()/semiperimeter;
    }
    public double circumference(){
        return 2*Math.PI*radius();
    }
}
