package Game;

import java.util.ArrayList;

public class Paladin extends Human implements Trading{
    Paladin(String name, int health, int strength, int agility, int maxHealth){
        super(name, health, strength, agility, maxHealth);
    }

    public void buy(Merchant m, int i){
        ArrayList<PickableItem> inv = m.getInventory();
        if (i < 0 || i >= inv.size()){
            System.out.println(m.getName() + " doesn't have this item!");
        }else{
            PickableItem item = inv.get(i);
            this.setGold(this.getGold() - item.getPrice());
            this.getInventory().add(item);
            System.out.println(this.getName() + " bought " + item.getTitle() + " from " + m.getName());
        }
    }
}
