public class Human {
    int height;
    double weight;
    private int age;
    String sex;
    Car car;
    String name;

    private int count = 0;

    Human(String n, int h, double w, int a, String s, Car c){
        height = h;
        weight = w;
        age = a;
        sex = s;
        car = c;
        name = n;
    }

    void salute(){
        System.out.println("Hi, my name is " + name + "!");
    }

    public int getAge(){
        count++;
        return age;
    }

    public int getCount(){
        return count;
    }
}
