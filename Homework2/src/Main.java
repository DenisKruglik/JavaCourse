public class Main {
    public static void main(String args[]){
        Circle c, c1, c2;
        try{
            c = new Circle(3.0);
            c1 = new Circle(2, 4, 0);
            c2 = new Circle(8, 0);
            System.out.println(c.isIntersected(c1));
            System.out.println(c.isIntersected(c2));
        }catch (InvalidShapeParametresException e){
            System.out.println(e.getMessage());
        }

        Triangle t, t1, t2;
        try{
            t = new Triangle(0,0,3,0,0,4);
            t1 = new Triangle(1,1,3,3,7,1);
            t2 = new Triangle(0,0,1,1,2,0);
            System.out.println(t.getPerimeter());
            System.out.println(t.getSquare());
            System.out.println(t.getType());
            System.out.println(t1.getPerimeter());
            System.out.println(t1.getSquare());
            System.out.println(t1.getType());
            System.out.println(t2.getPerimeter());
            System.out.println(t2.getSquare());
            System.out.println(t2.getType());
        }catch (InvalidShapeParametresException e){
            System.out.println(e.getMessage());
        }
    }
}
