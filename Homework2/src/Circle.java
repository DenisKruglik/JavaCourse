public class Circle {
    private double radius;
    private int coordinates[];

//    Circle(){
//        radius = 1;
//        coordinates[0] = 0;
//        coordinates[1] = 0;
//    }

    Circle(double r, int x, int y) throws InvalidShapeParametresException{
        if (r <= 0){
            throw new InvalidShapeParametresException("Radius must be positive!");
        }
        radius = r;
        coordinates = new int[2];
        coordinates[0] = x;
        coordinates[1] = y;
    }

    Circle(int x, int y){
        radius = 1.0;
        coordinates = new int[2];
        coordinates[0] = x;
        coordinates[1] = y;
    }

    Circle(double r) throws InvalidShapeParametresException{
        if (r <= 0){
            throw new InvalidShapeParametresException("Radius must be positive!");
        }
        radius = r;
        coordinates = new int[2];
        coordinates[0] = 0;
        coordinates[1] = 0;
    }

    double getRadius(){
        return radius;
    }

    int[] getCoordinates(){
        return coordinates;
    }

    void setRadius(double r) throws InvalidShapeParametresException{
        if (r <= 0){
            throw new InvalidShapeParametresException("Radius must be positive!");
        }
        radius = r;
    }

    void setCoordinates(int x, int y){
        coordinates[0] = x;
        coordinates[1] = y;
    }

    double square(){
        return Math.PI * radius * radius;
    }

    double circumference(){
        return 2 * Math.PI * radius;
    }

    boolean isIntersected(Circle c){
        double d = Math.sqrt(Math.pow(coordinates[0] - c.coordinates[0], 2) + Math.pow(coordinates[1] - c.coordinates[1], 2));
        if (radius + c.radius >= d){
            return true;
        }else{
            return false;
        }
    }
}
