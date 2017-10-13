import java.util.ArrayList;

public class Chest extends Item {
    private ArrayList<Item> items;

    Chest(){}

    public void takeItem(Human subject, int n){
        subject.getInventory().add(this.items.get(n));
        this.items.remove(n);
    }

    public String toString(){

    }
}
