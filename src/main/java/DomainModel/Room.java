package DomainModel;

import java.util.ArrayList;
import java.util.List;

public class Room implements Sizeble {

    private String description;
    private List<Human> humansInside;
    private int size;
    private int filledNum = 0;

    public Room(String description) {
        this.description = description;
        this.humansInside = new ArrayList<>();
        this.size = 100;
    }

    public Room(String description, int size) {
        this.description = description;
        this.humansInside = new ArrayList<>();
        this.size = size;
    }

    public Room(String description, List<Human> humansInside) {
        this.description = description;
        this.humansInside = humansInside;
        this.size = 100;
    }

    public Room(String description, List<Human> humansInside, int size) {
        this.description = description;
        this.humansInside = humansInside;
        this.size = size;
    }

    public boolean enter(Human human) {
        if(!humansInside.contains(human) && filledNum + human.getSize() <= size) {
            filledNum += human.getSize();
            return humansInside.add(human);
        }
        return false;
    }

    public boolean leave(Human human) {
        boolean res = humansInside.remove(human);
        if (res) {
            filledNum -= human.getSize();
        }
        return res;
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

    @Override
    public int getSize() {
        return size;
    }

    public int getFilledNum() {
        return filledNum;
    }

    public void setFilledNum(int filledNum) {
        this.filledNum = filledNum;
    }
}
