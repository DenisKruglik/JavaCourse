package Game;

public abstract class Weapon {
    private String title;
    private int hits;
    private int damage;
    private double criticalChance;

    Weapon(){}

    Weapon(String title, int hits, int damage, double criticalChance){
        this.title = title;
        this.hits = hits;
        this.criticalChance = criticalChance;
        this.damage = damage;
    }

    public String getTitle() {
        return title;
    }

    public int getHits() {
        return hits;
    }

    public double getCriticalChance() {
        return criticalChance;
    }

    public int getDamage() {
        return damage;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setHits(int hits) {
        this.hits = hits;
    }

    public void setCriticalChance(double criticalChance) {
        this.criticalChance = criticalChance;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }
}
