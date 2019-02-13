class PolylineTest {
    public static void main(String[] args) {
        Point[] anf = new Point[6];
        int i = 0;
        while (i++ < anf.length)
            anf[i-1] = SelectPolyline.randomPoint();
        Polyline pop = new Polyline(anf);
        System.out.println(pop.toString());
        pop.setColour("yellow");
        System.out.println(pop.toString());
        pop.addLast(new Point("bob", 33, 100));
        System.out.println(pop.toString());
        pop.addBefore(new Point("jane", 13, 44), "bob");
        System.out.println(pop.toString());
        pop.remove("jane");
        System.out.println(pop.toString());
        Polyline.PolylineIterator kop = pop.new PolylineIterator();
        System.out.println(kop.hasVertex());
        while(i++ < 10) {
            System.out.println(kop.vertex());
            kop.advance();
        }
    }
}
