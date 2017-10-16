package Game;

public class Berserk extends Creature {
    Berserk(String name, int health, int damage, int armor, Weapon weapon, Skill skill){
        super(name, health, damage, armor, weapon, skill);
    }

    Berserk(){
        this.setName("Berserk");
        this.setHealth(60);
        this.setDamage(40);
        this.setArmor(40);
        this.setWeapon(new Hummer());
        this.setSkill(new PowerUp());
    }
}
