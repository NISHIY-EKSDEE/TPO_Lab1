package DomainModel;

import org.junit.Test;

import static org.junit.Assert.*;

public class ActionTest {

    @Test
    public void builder() {
        String description = "desc";
        int energyCost = 15;
        int str = 11;
        int agl = 12;
        int intl = 13;

        Action action = Action.builder()
                .withDescription(description)
                .withEnergyCost(energyCost)
                .withStrengthChange(str)
                .withAgilityChange(agl)
                .withIntelligenceChange(intl)
                .build();

        assertEquals(description, action.getDescription());
        assertEquals(energyCost, action.getEnergyCost());
        assertEquals(str, action.getStrengthChange());
        assertEquals(agl, action.getAgilityChange());
        assertEquals(intl, action.getIntelligenceChange());
    }
}