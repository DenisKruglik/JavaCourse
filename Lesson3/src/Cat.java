public class Cat extends Creature implements Soundable {
    private static int created = 0;

    public Cat(String name){
        super(name);
        created++;
    }

    @Override
    public void sound(){
        System.out.println("Meow!");
    }

    public void eat(){
        System.out.println("Om-nom-nom!");
    }

    public static void printCreated(){
        System.out.println(created);
    }
}
