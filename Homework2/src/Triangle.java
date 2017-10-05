public class Triangle {
    private int x1;
    private int y1;
    private int x2;
    private int y2;
    private int x3;
    private int y3;

    Triangle(int _x1, int _y1, int _x2, int _y2, int _x3, int _y3) throws InvalidShapeParametresException{
        if ((_x1 == _x2 && _y1 == _y2) || (_x1 == _x3 && _y1 == _y3) || (_x3 == _x2 && _y3 == _y2)){
            throw new InvalidShapeParametresException("Vertices of triangle cannot coincide!");
        }else if(_x3 * (_y2 - _y1) - _y3 * (_x2 - _x1) == _x1 * _y2 - _x2 * _y1){
            throw new InvalidShapeParametresException("Vertices of triangle cannot lie on a line!");
        }
        x1 = _x1;
        y1 = _y1;
        x2 = _x2;
        y2 = _y2;
        x3 = _x3;
        y3 = _y3;
    }

    double getPerimeter(){
        double d1 = Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
        double d2 = Math.sqrt(Math.pow(x2 - x3, 2) + Math.pow(y2 - y3, 2));
        double d3 = Math.sqrt(Math.pow(x1 - x3, 2) + Math.pow(y1 - y3, 2));
        return d1 + d2 + d3;
    }

    double getSquare(){
        double d1 = Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
        double d2 = Math.sqrt(Math.pow(x2 - x3, 2) + Math.pow(y2 - y3, 2));
        double d3 = Math.sqrt(Math.pow(x1 - x3, 2) + Math.pow(y1 - y3, 2));
        double p = (d1+d2+d3)/2;
        return Math.sqrt(p*(p-d1)*(p-d2)*(p-d3));
    }

    TriangleType getType(){
        double d1 = Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
        double d2 = Math.sqrt(Math.pow(x2 - x3, 2) + Math.pow(y2 - y3, 2));
        double d3 = Math.sqrt(Math.pow(x1 - x3, 2) + Math.pow(y1 - y3, 2));
        if (d1*d1 + d2*d2 - d3*d3 < 0 || d1*d1 + d3*d3 - d2*d2 < 0 || d3*d3 + d2*d2 - d1*d1 < 0){
            return TriangleType.OBTUSE;
        }else if (d1*d1 + d2*d2 - d3*d3 == 0 || d1*d1 + d3*d3 - d2*d2 == 0 || d3*d3 + d2*d2 - d1*d1 == 0){
            return TriangleType.RIGHT;
        }else{
            return TriangleType.ACUTE;
        }
    }
}
