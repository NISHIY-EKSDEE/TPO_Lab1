package DomainModel;

import java.util.ArrayList;
import java.util.List;

public class Room implements Sizeble {

    private String description;
    private List<Human> humansInside;

    public Room(String description) {
        this.description = description;
        this.humansInside = new ArrayList<>();
    }

    public Room(String description, List<Human> humansInside) {
        this.description = description;
        this.humansInside = humansInside;
    }

    public boolean enter(Human human) {
        if(!humansInside.contains(human))
            return humansInside.add(human);
        return false;
    }

    public boolean leave(Human human) {
        return humansInside.remove(human);
    }

    public int numberOfHumans() {
        return humansInside.size();
    }

    public List<String> getHumansNames() {
        List<String> list = new ArrayList<>();
        for(Human human : humansInside) {
            list.add(human.getName());
        }
        return list;
    }

    public String getDescription() {
        return description;
    }
}
