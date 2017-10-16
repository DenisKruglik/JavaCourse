package Game;

public class Bow extends Weapon{
    Bow(String title, int hits, int damage, double criticalChance){
        super(title, hits, damage, criticalChance);
    }

    Bow(){
        this.setTitle("Wooden Bow");
        this.setHits(2);
        this.setDamage(5);
        this.setCriticalChance(2.0);
    }
}
