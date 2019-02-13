import java.util.Random;

class SelectPolyline
{
    public static final Random rand = new Random ();
    public static final int NOF_POLYLINES = 10;
    public static void main ( String[] args ){
        // Create a random number of polylines
        Polyline[] polylines = new Polyline[NOF_POLYLINES];
        for (int i = 0; i < NOF_POLYLINES ; i++)
            polylines [i] = randomPolyline ();
        // Show the polylines
        System.out.println("Polylines:");
        for(Polyline x : polylines)
            System.out.println(x);
        // Determine the shortest yellow polyline
        int min=0;
        for(int i=0;i<polylines.length;i++){
            if(polylines[i].getColour()=="yellow")
                if(min==0)
                    min=i;
                else if(polylines[i].distance()<polylines[min].distance())
                    min=i;
        }
        // Show the selected polyline
        System.out.println("shortest yellow line is: ");
        if(polylines[min].getColour()=="yellow")
            System.out.println(polylines[min].toString());
        else
            System.out.println("N/A");
    }
    // The randomPoint method returns a new Point with a name
    // randomly chosen from the single letters A - - Z . Coordinates
    // are random .
    public static Point randomPoint (){
        System.out.println("gggp");
        String n = " " + (char)(65 + rand.nextInt(26));
        int x = rand . nextInt (11);
        int y = rand . nextInt (11);
        return new Point(n , x , y );
    }
    // The method randomPolyline returns a random polyline ,
    // with a colour either blue , red , or yellow . The names
    // of the vertices are single letters from the set A - - Z .
    // Two vertices can not have the same name .
    public static Polyline randomPolyline () {
    // Create an empty polyline and add vertices
        System.out.println("gggb");
        Polyline polyline = new Polyline();
        System.out.println("ggga");
        int nofVertices = 2+rand.nextInt(7);
        char [] selectedNames = new char [26];
        int nofSelectedVertices = 0;
        char chosenChar;
        // Two vertices can not have the same name
        Point chosenPoint = randomPoint();
        polyline.addLast(chosenPoint);
        while (polyline.getVertices().length < nofVertices){
            System.out.println("help"+polyline.getVertices().length+" "+nofVertices);
            nofSelectedVertices=polyline.getVertices().length;
            chosenPoint=randomPoint();
            chosenChar=chosenPoint.getName().charAt(0);
            System.out.println(chosenChar);
            for (int i=0;i<nofSelectedVertices;i++){
                if(polyline.getVertex(i).getName().charAt(0)==chosenChar){
                    System.out.println("BREAK");
                    break;
                }
                if(i==nofSelectedVertices-1){
                    System.out.println("ADDED");
                    polyline.addLast(chosenPoint);
                }
            }
        }
        // Assign a colour
        String color="blue";
        double colorPicker=rand.nextInt(100);
        if (colorPicker>66)
            polyline.setColour("blue");
        else if(colorPicker>33)
            polyline.setColour("red");
        else
            polyline.setColour("yellow");
        return polyline;
    }
}
