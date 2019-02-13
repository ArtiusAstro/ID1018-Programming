public abstract class Polylines {
    public static Polyline getYellow(Polyline[] polylines) {
        int min=0;
        for(int i=0;i<polylines.length;i++){
            if(polylines[i].getColour()=="yellow")
                if(min==0)
                    min=i;
                else if(polylines[i].length()<polylines[min].length())
                    min=i;
        }
        System.out.print("shortest yellow line is: ");
        if(polylines[min].getColour()=="yellow")
            return polylines[min];
        else
            return null;
    }
    public static NPolyline[] nPolylines(int x){
        NPolyline[] nPolylines = new NPolyline[x];
        for (int i=0;i<x;i++)
            nPolylines[i]=new NPolyline(Polyline.randomPoints());
        return nPolylines;
    }
    public static VPolyline[] Vpolylines(int x){
        VPolyline[] vPolylines = new VPolyline[x];
        for (int i=0;i<x;i++)
            vPolylines[i]=new VPolyline(Polyline.randomPoints());
        return vPolylines;
    }
}
