import java.util.ArrayList;

public abstract class Human extends Character{
    private ArrayList<Item> inventory;
    private Weapon weapon;
    private int gold;

    Human(String name, int health, int strength, int agility){
        super(name, health, strength, agility);
        weapon = null;
        gold = 0;
    }

    void attack(Character target){
        int weaponDmg = weapon == null ? 0 : weapon.getDamage();
        int totalDmg = this.getStrength() + weaponDmg;
        double missChance = (double)(target.getAgility() - this.getAgility()) / (double)target.getAgility();
        int startHealth = target.getHealth();
        double luckyNuber = Math.random();
        if (0 < luckyNuber && luckyNuber <= missChance){
            System.out.println(this.getName() + " missed!");
        }else{
            target.setHealth(startHealth - totalDmg);
            if (target.getHealth() <= 0){
                System.out.println(target.getName() + " died");
                target = null;
            }
        }
    }

    public ArrayList<Item> getInventory() {
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
}
