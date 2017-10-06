public class Car implements Soundable {
    private String name;

    Car(String name){
        this.name = name;
    }

    public void sound(){
        System.out.println("Beep!");
    }
}
