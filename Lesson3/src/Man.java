public class Man implements Comparable<Man> {
    private String name;
    private int age;
    private double salary;

    Man(String name, int age, double salary){
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public String getName(){
        return this.name;
    }

    public int getAge(){
        return this.age;
    }

    public double getSalary(){
        return this.salary;
    }

    @Override
    public String toString(){
        return this.name + " " + this.age + " " + this.salary;
    }

    @Override
    public int compareTo(Man m){
        return this.age - m.age;
    }
}
