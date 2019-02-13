import java.util.Random;

public interface Polyline extends java.lang.Iterable<Point> {
    Random rand = new Random ();
    Point[] getVertices();
    String getColour();
    int getWidth();
    double length();
    void setColour(String colour);
    void setWidth(int width);
    void add(Point vertex);
    void insertBefore(Point vertex, String vertexName);
    void remove(String vertexName);
    java.util.Iterator<Point> iterator();

    static Point[] randomPoints() {
        Polyline polyline = new VPolyline();
        int nofVertices = 2+rand.nextInt(7);
        char [] selectedNames = new char[26];
        int nofSelectedVertices = 0;
        char chosenChar;
        // Two vertices can not have the same name
        Point chosenPoint = Point.randomPoint();
        polyline.add(chosenPoint);
        while (polyline.getVertices().length < nofVertices){
            nofSelectedVertices=polyline.getVertices().length;
            chosenPoint=Point.randomPoint();
            chosenChar=chosenPoint.getName().charAt(1);
            for (int i=0;i<nofSelectedVertices;i++){
                if(polyline.getVertices()[i].getName().charAt(0)==chosenChar){
                    break;
                }
                if(i==nofSelectedVertices-1){
                    polyline.add(chosenPoint);
                }
            }
        }
        return polyline.getVertices();
    }
}
