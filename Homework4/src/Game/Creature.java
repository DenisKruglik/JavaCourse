package Game;

public abstract class Creature {
    private String name;
    private int health;
    private int damage;
    private int armor;
    private Weapon weapon;
    private Skill skill;

    Creature(){}

    Creature(String name, int health, int damage, int armor, Weapon weapon, Skill skill){
        this.name = name;
        this.health = health;
        this.damage = damage;
        this.armor = armor;
        this.weapon = weapon;
        this.skill = skill;
    }

    public String getName(){
        return this.name;
    }

    public int getHealth() {
        return this.health;
    }

    public int getDamage() {
        return this.damage;
    }

    public int getArmor() {
        return armor;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public Skill getSkill() {
        return skill;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public void setSkill(Skill skill) {
        this.skill = skill;
    }

    public void print(){
        System.out.println(this.name + " " + this.health + " " + this.damage + " " + this.armor + " " + (weapon == null ? "No weapon" : weapon.getTitle()) + " " + (skill == null ? "No skill" : skill.getTitle()));
    }

    public boolean attack(Creature c){
        int startHealth = c.getHealth();
        double crit = Math.random();
        int critMultiplier = 1;
        if (crit <= this.weapon.getCriticalChance()/100.0 && crit > 0){
            critMultiplier = 3;
            System.out.println("Critical damage!");
        }
        int totalDamage = (int)(this.getWeapon().getDamage() * (((double)this.damage / 100.0) + 1) * (1 - (double)c.getArmor() / 100.0) * this.weapon.getHits() * critMultiplier);
        c.setHealth(startHealth - totalDamage);
        System.out.println(c.getName() + " took " + totalDamage + " damage from " + this.name + " and has " + c.getHealth() + " hp left");
        if (c.getHealth() <= 0){
            System.out.println(c.getName() + " died");
            return true;
        }
        return false;
    }
}
