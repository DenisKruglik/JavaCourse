public abstract class Creature {
    protected String name;
    public Creature(String name){
        this.name = name;
    }
    public String getName(){
        return this.name;
    }
    public abstract void sound();
}
