package Game;

public class Fireball extends Skill {
    Fireball(String title, SkillType skillType, int effect){
        super(title, skillType, effect);
    }

    Fireball(){
        this.setTitle("Fireball");
        this.setSkillType(SkillType.ENEMY);
        this.setEffect(10);
    }

    public boolean cast(Creature target, Creature subject){
        int startHealth = target.getHealth();
        int totalDamage = (int)(this.getEffect() * (1 - (double)target.getArmor() / 100.0));
        target.setHealth(startHealth - totalDamage);
        System.out.println(subject.getName() + " casted Fireball on " + target.getName() + " making damage " + totalDamage + ", " + target.getName() + " has " + target.getHealth() + " hp");
        if (target.getHealth() <= 0){
            System.out.println(target.getName() + " died");
            return true;
        }
        return false;
    }
}
