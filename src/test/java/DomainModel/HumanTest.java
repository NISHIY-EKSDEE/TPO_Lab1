package DomainModel;

import org.junit.Test;

import static org.junit.Assert.*;

public class HumanTest {

    @Test
    public void apply() {
        int diff = 100;

        String description = "desc";
        int energyCost = 15;
        int str = 11;
        int agl = 12;
        int intl = 13;

        Action action = Action.builder()
                .withDescription(description)
                .withEnergyCost(energyCost)
                .withStrengthChange(-str)
                .withAgilityChange(-agl)
                .withIntelligenceChange(-intl)
                .build();
        Human human = new Human("", str + diff, agl + diff, intl + diff, energyCost + diff);
        int initEnergy = human.getEnergy();
        int initStr = human.getStrength();
        int initAgl = human.getAgility();
        int initIntl = human.getIntelligence();

        human.apply(action);

        assertEquals(initEnergy - human.getEnergy(), energyCost);
        assertEquals(initStr - human.getStrength(), str);
        assertEquals(initAgl - human.getAgility(), agl);
        assertEquals(initIntl - human.getIntelligence(), intl);
    }
}