
import java.util.Iterator;
import java.util.Random;

public class NPolyline implements Polyline{

    public static final Random rand = new Random ();

    private static class Node {
        public Point vertex;
        public Node nextNode;
        public Node (Point vertex) {
            this.vertex = vertex;
            nextNode = null;
        }
    }
    private Node vertices;
    private String colour = "black";
    private int width = 1; // pixels
    public NPolyline () {
        this.vertices = null;
    }
    public NPolyline ( Point[] vertices ) {
        if ( vertices.length > 0) {
            Node node = new Node ( new Point ( vertices [0]));
            this.vertices = node ;
            int pos = 1;
            while ( pos < vertices.length ) {
                node.nextNode = new Node ( new Point (vertices[pos++]));
                node = node.nextNode ;
            }
        }
        double colorPicker=rand.nextInt(100);
        if (colorPicker>66)
            this.setColour("blue");
        else if(colorPicker>33)
            this.setColour("red");
        else
            this.setColour("yellow");
    }

    @Override
    public Point[] getVertices(){
        int length=0;
        Node node = this.vertices;
        while(node!=null){
            length++;
            node = node.nextNode;
        }
        node = this.vertices;
        Point[] points = new Point[length];
        int i = 0;
        while(i<length){
            points[i++] = node.vertex;
            node = node.nextNode;
        }
        return points;
    }

    @Override
    public String getColour() {
        return this.colour;
    }

    @Override
    public int getWidth() {
        NPolyline clone = new NPolyline();
        clone.setWidth(width);
        return clone.width;
    }

    @Override
    public double length() {
        double sum=0;
        for(int i=0;i<this.getVertices().length-2;i++)
            sum+=this.getVertices()[i].distance(this.getVertices()[i+1]);
        return sum;
    }

    @Override
    public void setColour(String colour) {
        this.colour = colour;
    }

    @Override
    public void setWidth(int width) {
        this.width = width;
    }

    @Override
    public void add(Point vertex) {
        Node node = this.vertices;
        while (node != null)
            node = node.nextNode;
        node.nextNode=new Node(vertex);
    }

    @Override
    public void insertBefore(Point vertex, String vertexName) {
        Node node = this.vertices;
        Node temp;
        Boolean ok=false;
        while(node!=null) {
            if (node.nextNode.vertex.getName()==vertexName && !ok) {
                temp=node.nextNode;
                node.nextNode=new Node(vertex);
                node.nextNode.nextNode=temp;
                ok=true;
            }
            else
                node=node.nextNode;
        }
    }

    @Override
    public void remove(String vertexName) {
        Node node = this.vertices;
        Node temp;
        Boolean ok=false;
        while(node!=null) {
            if (node.nextNode.vertex.getName()==vertexName && !ok) {
                node.nextNode=node.nextNode.nextNode;
                ok=true;
            }
            else
                node=node.nextNode;
        }
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        Node node =this.vertices;
        while (node!=null) {
            str.append(node.vertex.getName() + "(" + node.vertex.getX()+ " " + node.vertex.getY() + ") ");
            node=node.nextNode;
        }
        if(this.vertices!=null)
            return "["+str+", "+getColour()+" , "+getWidth()+"]";
        else
            return "empty";
    }

    @Override   
    public Iterator<Point> iterator() {
        return null;
    }

    // *** MORE CODE HERE ***
    public class PolylineIterator {
        private Node node;
        public PolylineIterator(NPolyline polyline) {
            node = polyline.vertices;
        }
        public boolean hasNext() {
            if(node.nextNode!=null)
                return false;
            else
                return true;
        }
        public Point vertex() {
            return node.vertex;
        }
        public void advance() throws java.util.NoSuchElementException {
            if (!this.hasNext())
                throw new java.util.NoSuchElementException("end of iteration");
            node = node.nextNode;
        }
    }
}
