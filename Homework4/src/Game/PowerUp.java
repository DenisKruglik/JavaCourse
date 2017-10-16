package Game;

public class PowerUp extends Skill{
    PowerUp(String title, SkillType skillType, int effect){
        super(title, skillType, effect);
    }

    PowerUp(){
        this.setTitle("Power Up");
        this.setSkillType(SkillType.SELF);
        this.setEffect(5);
    }

    public boolean cast(Creature target, Creature subject){
        int startDamage = target.getDamage();
        target.setDamage(startDamage + this.getEffect());
        System.out.println(subject.getName() + " casted Power Up on himself increasing his damage by " + this.getEffect() + " to " + subject.getDamage());
        return false;
    }
}
