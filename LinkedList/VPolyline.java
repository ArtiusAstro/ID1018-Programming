import java.util.Iterator;
import java.util.Random;

public class VPolyline implements Polyline {

    public static final Random rand = new Random ();
    private Point[] vertices;
    private String color;
    private int width;
    private double length;

    public VPolyline () {
        this.vertices = new Point [0];
    }
    public VPolyline ( Point[] vertices ){
        this.vertices = new Point [vertices.length];
        for ( int i = 0; i < vertices.length; i++) {
            this.vertices[i] = new Point(vertices[i]);
        }
        double colorPicker=rand.nextInt(100);
        if (colorPicker>66)
            this.setColour("blue");
        else if(colorPicker>33)
            this.setColour("red");
        else
            this.setColour("yellow");
    }

    public Point[] getVertices() {
        return this.vertices;
    }

    
    public String getColour() {
        return this.color;
    }

    public int getWidth() {
        return this.width;
    }

    
    public double length() {
        return this.length;
    }

    
    public void setColour(String colour) {
        this.color = colour;
    }

    
    public void setWidth(int width) {
        this.width = width;
    }

    
    public void add(Point vertex) {
        Point[] h = new Point [this.vertices.length + 1];
        int i;
        for (i = 0; i < this.vertices.length; i++)
            h[i] = this.vertices[i];
        h[this.vertices.length] = new Point(vertex);
        this.vertices = h;
    }

    
    public void insertBefore(Point vertex, String vertexName) {
        Boolean ok=false;
        int i;
        Point[] h = new Point [this.vertices.length+1];
        for (i=0; i < this.vertices.length ; i++){
            if (this.vertices[i].getName().equals(vertexName) && !ok) {
                h[i] = vertex;
                ok = true;
            }
            if(ok)
                h[i+1]=this.vertices[i];
            else
                h[i]=this.vertices[i];
        }
        this.vertices = h;
    }

    
    public void remove(String vertexName) {
        Boolean ok=false;
        Point [] h = new Point [this.vertices.length-1];
        for (int i = 0; i < this.vertices.length-1; i++) {
            if (this.vertices[i].getName() == vertexName) {
                ok=true;
            }
            if(!ok){
                h[i] = this.vertices[i];
            }
            else {
                h[i] = this.vertices[i+1];
            }
        }
    }

    
    public Iterator<Point> iterator() {
        return null;
    }

    public class PolylineIterator {
        private int current = -1;
        public PolylineIterator (){
            if (VPolyline.this.vertices.length>0)
                current = 0;
        }
        public boolean hasVertex (){
            return current != -1;
        }
        public Point vertex()
                throws java.util.NoSuchElementException {
            if (!this.hasVertex())
                throw new java.util.NoSuchElementException (
                        "end of iteration");
            Point vertex = VPolyline.this.vertices[current];
            return vertex ;
        }
        public void advance(){
            if (current >= 0 && current < VPolyline.this.vertices.length-1)
                current ++;
            else
                current = -1;
        }
    }

    public String toString() {
        StringBuilder str = new StringBuilder();
        int i=0;
        for(Point point:getVertices())
            str.append(getVertices()[i].getName() + "(" + getVertices()[i].getX() + " " + getVertices()[i++].getY() + ") ");
        str.append(", "+getColour()+" , "+getWidth());
        if(getVertices().length>0)
            return "["+str+"]";
        else
            return "empty";
    }
}
