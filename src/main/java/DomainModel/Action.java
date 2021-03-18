package DomainModel;

public class Action {

    public class Builder {

        public Builder withEnergyCost(int n) {
            Action.this.energyCost = n;
            return this;
        }

        public Builder withStrengthChange(int n) {
            Action.this.strengthChange = n;
            return this;
        }

        public Builder withAgilityChange(int n) {
            Action.this.agilityChange = n;
            return this;
        }

        public Builder withIntelligenceChange(int n) {
            Action.this.intelligenceChange = n;
            return this;
        }

        public Builder withDescription(String s) {
            Action.this.description = s;
            return this;
        }

        public Action build() {
            Action action = new Action();
            action.description = Action.this.description;
            action.energyCost = Action.this.energyCost;
            action.strengthChange = Action.this.strengthChange;
            action.agilityChange = Action.this.agilityChange;
            action.intelligenceChange = Action.this.intelligenceChange;

            return action;
        }
    }

    private String description;
    private int energyCost;
    private int strengthChange;
    private int agilityChange;
    private int intelligenceChange;

    public static Builder builder() {
        return new Action().new Builder();
    }

    public int getEnergyCost() {
        return energyCost;
    }

    public int getStrengthChange() {
        return strengthChange;
    }

    public int getAgilityChange() {
        return agilityChange;
    }

    public int getIntelligenceChange() {
        return intelligenceChange;
    }

    public String getDescription() {
        return description;
    }
}
