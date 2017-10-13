package Game;

import java.util.ArrayList;

public class Chest extends Item {
    private ArrayList<PickableItem> items;

    Chest(String title){
        super(title);
        items = new ArrayList<>();
    }

    public ArrayList<PickableItem> getItems() {
        return items;
    }

    public void pushItem(PickableItem i){
        this.items.add(i);
    }

    public String toString(){
        String s = "";
        for(PickableItem i: items){
            s += i.getTitle() + "\\n";
        }
        return s;
    }
}
