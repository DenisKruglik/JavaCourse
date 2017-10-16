package Game;

public class Scenario {
    public static void main(String args[]){
        Merchant Dave = new Merchant("Dave", 20, 1,1,20);
        Potion p = new Potion("Health Potion", 10, 10);
        Dave.pick(p);
        p = null;
        Chest chest = new Chest("Old chest");
        Weapon w = new Weapon("Steel Sword", 10, 10);
        chest.pushItem(w);
        w = null;
        Paladin Jeff = new Paladin("Jeff", 50, 5, 10, 50);
        Jeff.setGold(10);
        Jeff.takeItem(chest, 0);
        Jeff.equipWeapon(Jeff.getInventory().get(0));
        Bandit bad = new Bandit("Some bandit", 20, 5, 15, 20);
        w = new Weapon("Steel Sword", 10, 10);
        bad.setWeapon(w);
        w = null;
        Animal chicken = new Animal("Chicken", 1, 1, 1, 1);
        bad.attack(chicken);
        Jeff.attack(bad);
        bad.attack(Jeff);
        Jeff.attack(bad);
        Jeff.buy(Dave, 0);
        PickableItem potion = Jeff.getInventory().get(1);
        if (potion instanceof Potion){
            ((Interactable)potion).interact(Jeff);
        }
    }
}
