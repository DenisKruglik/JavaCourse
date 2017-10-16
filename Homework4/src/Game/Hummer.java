package Game;

public class Hummer extends Weapon {
    Hummer(String title, int hits, int damage, double criticalChance){
        super(title, hits, damage, criticalChance);
    }

    Hummer(){
        this.setTitle("Steel Hummer");
        this.setHits(1);
        this.setDamage(15);
        this.setCriticalChance(1.0);
    }
}
