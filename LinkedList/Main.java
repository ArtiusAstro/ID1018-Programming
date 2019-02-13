

public class Main {
    public static void main(String[] ajfd){
        Polyline polyline;
        VPolyline[] vPolylines = Polylines.Vpolylines(5);
        NPolyline[] nPolylines = Polylines.nPolylines(5);
        int x=Integer.min(vPolylines.length,nPolylines.length);
        Polyline[] polylines = new Polyline[x];
        int i=0;
        while(i<x){
            if(i%2==0) polylines[i]=vPolylines[i];
            else polylines[i]=nPolylines[i];
            i++;
        }
        for(Polyline line:polylines)
            System.out.println(line);
        System.out.println(Polylines.getYellow(polylines));
    }
}
