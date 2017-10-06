public class Main {
    public static void main(String args[]){
//        Creature c = new Creature("Alex");
//        System.out.println(c.getName());
        Cat cat = new Cat("Vasya");
//        c.sound();
//        cat.sound();
//        cat.eat();

//        Car car = new Car("Impala");
//        car.sound();
        Soundable car2 = new Car("Indian");
        car2.sound();

        Soundable myCat = new Cat("Pushok");
        myCat.sound();

//        System.out.println(Cat.created);
        Cat.printCreated();
    }
}
