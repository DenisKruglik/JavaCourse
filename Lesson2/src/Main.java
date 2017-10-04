public class Main {
    public static void main(String args[]){
        Car myCar = new Car(2010, "Passat", 1780.0, CarType.LIGHT, "Volkswagen");
//        myCar.year = 2010;
//        myCar.model = "Passat";
//        myCar.mass = 1780.0;
//        myCar.type = "L";
//        myCar.producer = "Volkswagen";
//        System.out.println(myCar.mass);
//        System.out.println(myCar.producer);

//        House myHouse = new House(5, 30, 50);
//        System.out.println(myHouse.floors);
//        System.out.println(myHouse.square);
//        System.out.println(myHouse.dwellers);

        Human guy = new Human("Adolf", 160, 78, 18, "Male", myCar);
//        System.out.println(guy.height);
//        System.out.println(guy.weight);
//        System.out.println(guy.age);
//        System.out.println(guy.sex);
//        System.out.println(guy.car.year);
//        System.out.println(guy.car.model);
//        System.out.println(guy.car.mass);
//        System.out.println(guy.car.type);
//        System.out.println(guy.car.producer);

//        myCar.beep();
//        myCar.beep();

//        guy.salute();

//        System.out.println(guy.getAge());

//        System.out.println(myCar.getMileage());

//        for (int i = 0; i < 5; i++){
//            guy.getAge();
//        }
//        System.out.println(guy.getCount());

//        myCar.beep(5);

//        House myHouse = new House(30, 50);
//        System.out.println(myHouse.floors);

//        System.out.println(myCar.getType());

        try{
            myCar.beep(-1);
        }catch(NegativeNumberException e){
            System.out.println(e.getMessage());
        }

    }
}
