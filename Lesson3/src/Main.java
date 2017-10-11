import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;

public class Main {
    public static void main(String args[]){
//        Creature c = new Creature("Alex");
//        System.out.println(c.getName());
//        Cat cat = new Cat("Vasya");
////        c.sound();
////        cat.sound();
////        cat.eat();
//
////        Car car = new Car("Impala");
////        car.sound();
//        Soundable car2 = new Car("Indian");
//        car2.sound();
//
//        Soundable myCat = new Cat("Pushok");
//        myCat.sound();
//
////        System.out.println(Cat.created);
//        Cat.printCreated();



//        Soundable something = new Soundable(){
//            @Override
//            public void sound(){
//                System.out.println("[Weird sound]");
//            }
//        };
//
//        something.sound();

//        Creature something = new Creature("Something"){
//            @Override
//            public void sound(){
//                System.out.println("[Weird sound]");
//            }
//        };
//        something.sound();

        Man guy = new Man("Stevie", 21, 5000);
////        System.out.println(guy.getName());
////        System.out.println(guy.getAge());
////        System.out.println(guy.getSalary());
//        System.out.println(guy);

        ArrayList<Man> men = new ArrayList<Man>();
        men.add(guy);
        men.add(new Man("Jeff", 23, 1000));
        men.add(new Man("Rose", 19, 500));
        men.add(new Man("Bob", 27, 2000));
        men.add(new Man("Carrie", 17, 0));
//        System.out.println(men.size());
//        System.out.println(men.get(2));
//        men.add(3, new Man("Peter", 25, 1500));
//        System.out.println(men.get(3));
//        System.out.println(men.get(4));
//        men.remove(3);
//        System.out.println(men.get(3));
//        men.remove(guy);
//        System.out.println(men.get(0));

//        HashSet<Man> men = new HashSet<Man>();
//        men.add(guy);
//        men.add(new Man("Jeff", 23, 1000));
//        men.add(new Man("Rose", 19, 500));
//        men.add(new Man("Bob", 27, 2000));
//        men.add(new Man("Carrie", 17, 0));
////        for(Man h: men){
////            System.out.println(h);
////        }
//        Iterator<Man> it = men.iterator();
//        while (it.hasNext()){
//            System.out.println(it.next());
//        }

//        ArrayList<Soundable> soundables = new ArrayList<Soundable>();
//        soundables.add(new Cat("Maria"));
//        soundables.add(new Car("Impala"));
//        soundables.add(new Soundable(){
//            public void sound(){
//                System.out.println("Weee!");
//            }
//        });
//        for (Soundable snd: soundables
//             ) {
//            snd.sound();
//        }

//        for(Man m: men){
//            System.out.println(m);
//        }
//        System.out.println("");

//        Collections.reverse(men);
//        for(Man m: men){
//            System.out.println(m);
//        }
//        System.out.println("");

//        Collections.shuffle(men);
//        for(Man m: men){
//            System.out.println(m);
//        }
//        System.out.println("");

//        Man min = Collections.min(men);
//        System.out.println(min);
//        System.out.println("");

//        Collections.sort(men);
//        for(Man m: men){
//            System.out.println(m);
//        }
//        System.out.println("");

        int i = 0;
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    for (int i = 0; i < 100; i++){
                        System.out.println(i++);
                        Thread.sleep(100);
                    }
                }catch(Exception e){}
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    for (int i = 0; i < 100; i++){
                        System.out.println(i++);
                        Thread.sleep(100);
                    }
                }catch(Exception e){}
            }
        });
//        t1.setDaemon(true);
//        t2.setDaemon(true);
        t1.start();
        t2.start();
    }
}
