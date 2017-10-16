package Game;

public class Heal extends Skill {
    Heal(String title, SkillType skillType, int effect){
        super(title, skillType, effect);
    }

    Heal(){
        this.setTitle("Heal");
        this.setSkillType(SkillType.FRIEND);
        this.setEffect(15);
    }

    public boolean cast(Creature target, Creature subject){
        int startHealth = target.getHealth();
        target.setHealth(startHealth + this.getEffect());
        System.out.println(subject.getName() + " casted Heal on " + target.getName() + " restoring " + this.getEffect() + " hp to " + target.getHealth());
        return false;
    }
}
