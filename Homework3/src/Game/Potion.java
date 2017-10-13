package Game;

public class Potion extends PickableItem implements Interactable{
    private int effect;

    Potion(String title, int price, int effect){
        super(title, price);
        this.effect = effect;
    }

    public void interact(Human c){
        int resHealth = c.getHealth() + this.effect;
        int actualRes = resHealth > c.getMaxHealth() ? c.getMaxHealth() : resHealth;
        c.setHealth(actualRes);
        System.out.println(c.getName() + " gained " + this.effect + " hp");
    }
}
