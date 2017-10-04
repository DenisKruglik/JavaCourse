public class House {
    final int floors;
    double square;
    int dwellers;

    House(int f, double s, int d){
        floors = f;
        square = s;
        dwellers = d;
    }

    House(double s, int d){
        floors = 1;
        square = s;
        dwellers = d;
    }
}
