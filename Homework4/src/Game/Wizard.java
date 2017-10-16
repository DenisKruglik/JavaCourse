package Game;

public class Wizard extends Creature{
    Wizard(String name, int health, int damage, int armor, Weapon weapon, Skill skill){
        super(name, health, damage, armor, weapon, skill);
    }

    Wizard(){
        this.setName("Wizard");
        this.setHealth(30);
        this.setDamage(30);
        this.setArmor(30);
        this.setWeapon(new Bow());
        this.setSkill(new Fireball());
    }
}
