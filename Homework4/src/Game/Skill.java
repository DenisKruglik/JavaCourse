package Game;

public abstract class Skill {
    private SkillType skillType;
    private int effect;
    private String title;

    Skill(){}
    Skill(String title, SkillType skillType, int effect){
        this.effect = effect;
        this.title = title;
        this.skillType = skillType;
    }

    public int getEffect() {
        return effect;
    }

    public String getTitle() {
        return title;
    }

    public SkillType getSkillType() {
        return skillType;
    }

    public void setEffect(int effect) {
        this.effect = effect;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setSkillType(SkillType skillType) {
        this.skillType = skillType;
    }

    public abstract boolean cast(Creature target, Creature subject);
}
