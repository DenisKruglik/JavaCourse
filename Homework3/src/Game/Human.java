package Game;

import java.util.ArrayList;

public abstract class Human extends Character implements Attacking{
    private ArrayList<PickableItem> inventory;
    private Weapon weapon;
    private int gold;

    Human(String name, int health, int strength, int agility, int maxHealth){
        super(name, health, strength, agility, maxHealth);
        weapon = null;
        gold = 0;
        inventory = new ArrayList<>();
    }

    public void attack(Character target){
        int weaponDmg = weapon == null ? 0 : weapon.getDamage();
        int totalDmg = this.getStrength() + weaponDmg;
        double missChance = (double)(target.getAgility() - this.getAgility()) / (double)target.getAgility();
        int startHealth = target.getHealth();
        double luckyNuber = Math.random();
        if (0 < luckyNuber && luckyNuber <= missChance){
            System.out.println(this.getName() + " missed!");
        }else{
            target.setHealth(startHealth - totalDmg);
            System.out.println(target.getName() + " took " + totalDmg + " damage");
            if (target.getHealth() <= 0){
                System.out.println(target.getName() + " died");
                target = null;
            }
        }
    }

    public ArrayList<PickableItem> getInventory() {
        return inventory;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public int getGold() {
        return gold;
    }

    public void setWeapon(Weapon weapon){
        this.weapon = weapon;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public void pick(PickableItem i){
        this.inventory.add(i);
        System.out.println(this.getName() + " picked a " + i.getTitle());
    }

    public void equipWeapon(Item w){
        if (w instanceof Weapon){
            this.setWeapon((Weapon)w);
            System.out.println(this.getName() + " equipped a " + w.getTitle());
        }else{
            System.out.println("You can't equip this!");
        }
    }

    public void takeItem(Chest chest, int n){
        ArrayList<PickableItem> items = chest.getItems();
        if (n < 0 || n >= items.size()){
            System.out.println("There's no this item in " + chest.getTitle() + "!");
        }else{
            this.pick(items.get(n));
            items.remove(n);
        }
    }
}
