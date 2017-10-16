package Game;

public class Paladin extends Creature{
    Paladin(String name, int health, int damage, int armor, Weapon weapon, Skill skill){
        super(name, health, damage, armor, weapon, skill);
    }

    Paladin(){
        this.setName("Paladin");
        this.setHealth(50);
        this.setDamage(40);
        this.setArmor(40);
        this.setWeapon(new Sword());
        this.setSkill(new Heal());
    }
}
