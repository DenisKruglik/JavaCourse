package Game;

public abstract class Character {
    private String name;
    private int health;
    private int strength;
    private int agility;
    private int maxHealth;

    Character(String name, int health, int strength, int agility, int maxHealth){
        this.name = name;
        this.health = health;
        this.strength = strength;
        this.agility = agility;
        this.maxHealth = maxHealth;
    }

    public String getName(){
        return this.name;
    }

    public int getHealth(){
        return this.health;
    }

    public int getStrength(){
        return this.strength;
    }

    public int getAgility(){
        return this.agility;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setHealth(int health){
        this.health = health;
    }

    public void setStrength(int strength){
        this.strength = strength;
    }

    public void setAgility(int agility){
        this.agility = agility;
    }

    public int getMaxHealth(){
        return this.maxHealth;
    }

    public void setMaxHealth(int maxHealth){
        this.maxHealth = maxHealth;
    }
}
