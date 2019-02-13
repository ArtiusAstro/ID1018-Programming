class Point{
    private String name;
    private int x;
    private int y;
    public void Point(String a, int x, int y){
        this.name=a;
        this.x=x;
        this.y=y;
    }
    public void Point(Point p){
        this.name=p.getName();
        this.x=p.getX();
        this.y=p.getY();
    }
    public String toString(){
        return this.name+"("+this.getX()+" "+this.getY()+")";
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setX(int x) {
        this.x = x;
    }
    public void setY(int y) {
        this.y = y;
    }
    public String getName() {
        return name;
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public double distance(Point p){
        return Math.sqrt((this.x-p.getX())*(this.x-p.getX())+(this.y-p.getY())*(this.y-p.getY()));
    }
    public Boolean equals(Point p){
        if(this.x==p.getX() && this.y==p.getY()){
            return true;
        }
        else{
            return false;
        }
    }
}//end Point class
