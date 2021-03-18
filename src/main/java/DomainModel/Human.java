package DomainModel;

import com.sun.glass.ui.Size;

public class Human implements Sizeble {

    private final static int HUMAN_SIZE = 10;
    private String name;
    private int energy;
    private int strength;
    private int agility;
    private int intelligence;

    public Human(String name) {
        this(name, 0, 0, 0, 0);
    }

    public Human(String name, int strength, int agility, int intelligence) {
        this(name, strength, agility, intelligence, 0);
    }

    public Human(String name, int strength, int agility, int intelligence, int energy) {
        this.name = name;
        this.energy = energy;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
    }

    public Human(String name, int strength, int agility, int intelligence, int energy, int size) {
        this.name = name;
        this.energy = energy;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
    }

    public void apply(Action action) {
        energy -= action.getEnergyCost();
        strength += action.getStrengthChange();
        agility += action.getAgilityChange();
        intelligence += action.getIntelligenceChange();
        System.out.println(this.name + " выполнил действие: " + action.getDescription());
    }

    public String getName() {
        return name;
    }

    public int getEnergy() {
        return energy;
    }

    public int getStrength() {
        return strength;
    }

    public int getAgility() {
        return agility;
    }

    public int getIntelligence() {
        return intelligence;
    }

    @Override
    public int getSize() {
        return HUMAN_SIZE;
    }
}
