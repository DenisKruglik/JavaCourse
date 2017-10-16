package Game;

public class Sword extends Weapon {
    Sword(String title, int hits, int damage, double criticalChance){
        super(title, hits, damage, criticalChance);
    }

    Sword(){
        this.setTitle("Steel Sword");
        this.setHits(1);
        this.setDamage(10);
        this.setCriticalChance(5.0);
    }
}
