public class Polyline{
    public class PolylineIterator {
        private int current = -1;
        public PolylineIterator (){
            if (Polyline.this.vertices.length>0)
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
            Point vertex = Polyline.this.vertices[current];
            return vertex ;
        }
        public void advance(){
            if (current >= 0 && current < Polyline.this.vertices.length-1)
                current ++;
            else
                current = -1;
        }
    }

    private Point [] vertices ;
    private String colour = "black" ;
    private int width = 1;

    public Polyline () {
        this.vertices = new Point [0];
    }
    public Polyline ( Point[] vertices ){
        this.vertices = new Point [vertices.length];
        for ( int i = 0; i < vertices.length; i++) {
            this.vertices[i] = new Point(vertices[i]);
        }
    }

    public String toString () {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < vertices.length; i++)
                str.append(vertices[i].getName() + "(" + vertices[i].getX() + " " + vertices[i].getY() + ") ");
                str.append(", "+this.colour+", "+this.width);
        return "["+str.toString()+"]";
    }
    public Point [] getVertices () {
        return new Polyline(this.vertices).vertices;
    }
    public Point getVertex(int i){
        return new Polyline(this.vertices).vertices[i];
    }
    public double distance(){
        double sum=0;
        for(int i=0;i<this.vertices.length-2;i++)
            sum+=this.vertices[i].distance(this.vertices[i+1]);
        return sum;
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