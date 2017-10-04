public class Car {
    int year;
    String model;
    double mass;
    CarType type;
    String producer;

    Car(int _year, String _model, double _mass, CarType _type, String _producer){
        year = _year;
        model = _model;
        mass = _mass;
        type = _type;
        producer = _producer;
    }

    void beep(){
        System.out.println("Beep!");
    }

    void beep(int n) throws NegativeNumberException{
        if (n < 0){
            throw new NegativeNumberException("Parameter cannot be negative!");
        }
        for (int i = 0; i < n; i++){
            System.out.println("Beep!");
        }
    }

    public int getMileage(){
        return (2017 - year) * 15000;
    }

    public String getType(){
        switch (type){
            case LIGHT:
                return "Light";
            case HEAVY:
                return "Heavy";
            case MINIVAN:
                return "Minivan";
            case TANK:
                return "Tank";
            default:
                return "Undefined";
        }
    }
}
