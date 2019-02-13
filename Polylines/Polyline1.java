public class Polyline1{
    private Point [] vertices ;
    private String colour = "black" ;
    private int width = 1;

    public Polyline1 () {
        this.vertices = new Point [0];
    }
    public Polyline1 ( Point[] vertices ){
        this.vertices = new Point [vertices.length];
        for ( int i = 0; i < vertices.length; i++) {
            this.vertices[i] = new Point(vertices[i]);
        }
    }

    public String toString () {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < vertices.length; i++) {
            try {
                str.append(vertices[i].getName() + "(" + vertices[i].getX() + " " + vertices[i].getY() + ") ");
            }
            catch (NullPointerException n){
                System.out.println("TTG "+i+" "+vertices.length);
            }
        }

        str.append(", "+this.colour+", "+this.width);
        return "["+str.toString()+"]";
    }
    public Point [] getVertices () {
        return new Polyline(this.vertices).getVertices();
    }
    public String getColour () {
        return this.colour;
    }
    public int getWidth () {
        return this.width;
    }
    public void setColour ( String colour ) {
        this.colour=colour;
    }
    public void setWidth ( int width ) {
        this.width=width;
    }
    public double length () {
        int length=0;
        for (int i = 0; i < vertices.length-2;i++)
            length += vertices[i].distance(vertices[i+1]);
        return length;
    }
    public void addLast ( Point vertex ){
        Point[] h = new Point [this.vertices.length + 1];
        int i;
        for (i = 0; i < this.vertices.length; i++)
            h[i] = this.vertices[i];
        h[this.vertices.length] = new Point(vertex);
        this.vertices = h;
    }
    //continue from here
    public void addBefore (Point vertex , String vertexName){
        Boolean ok=false;
        int i;
        Point[] h = new Point [this.vertices.length+1];
        for (i=0; i < this.vertices.length ; i++){
            if (this.vertices[i].getName() == vertexName && !ok) {
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
    public void remove ( String vertexName ) {
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
        this.vertices = h;
    }
}