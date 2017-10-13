package Game;

public class Weapon extends PickableItem {
    private int damage;

    Weapon(String title, int price, int damage){
        super(title, price);
        this.damage = damage;
    }

    public int getDamage(){
        return this.damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }
}
