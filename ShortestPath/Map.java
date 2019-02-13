
public class Map {
     int[] a;
     int[][] b;
     int[] c;

     public Map(int m, int n, double d){
        this.a=new int[m];
        this.b=new int[m][n];
        this.c=new int[n];
        for(int i=0;i<m;i++){
            this.a[i]=(int)(Math.random()*d)+1;
            for(int j=0;j<n;j++){
                this.b[i][j]=(int)(Math.random()*d)+1;
            }
        }
        for(int j=0;j<n;j++){
            this.c[j]=(int)(Math.random()*d)+1;
        }
    }
    public String findShortestPath(){
        int min=this.a[1]+this.b[1][1]+this.c[1];
        int u=0;
        int v=0;
        for(int i=0;i<a.length;i++){
            for(int j=0;j<c.length;j++){
                if(this.a[i]+this.b[i][j]+this.c[j]<min){
                    u=i+1;
                    v=j+1;
                }
            }
        }
        return "U"+Integer.toString(u)+"-V"+Integer.toString(v);
    }
    public double findShortestDistance(){
        int min=this.a[1]+this.b[1][1]+this.c[1];
        int u=0;
        int v=0;
        for(int i=0;i<a.length;i++){
            for(int j=0;j<c.length;j++){
                if(this.a[i]+this.b[i][j]+this.c[j]<min){
                    min=this.a[i]+this.b[i][j]+this.c[j];
                }
            }
        }
        return min;
    }
}
