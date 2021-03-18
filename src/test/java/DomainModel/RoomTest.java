package DomainModel;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class RoomTest {

    @Test
    public void enter() {
        Room room = new Room("");
        Human human1 = new Human("1");
        assertTrue(room.enter(human1));
        assertFalse(room.enter(human1));
    }

    @Test
    public void leave() {
        Room room = new Room("");
        Human human1 = new Human("1");
        room.enter(human1);
        assertTrue(room.leave(human1));
        assertFalse(room.leave(human1));
    }

    @Test
    public void numberOfHumans() {
        Room room = new Room("");
        int initSize = room.numberOfHumans();
        Human human = new Human("");
        room.enter(human);
        int afterEnterSize = room.numberOfHumans();

        assertEquals(afterEnterSize - initSize, 1);
    }

    @Test
    public void getHumansNames() {
        Room room = new Room("");
        Human human1 = new Human("1");
        Human human2 = new Human("2");
        Human human3 = new Human("3");
        room.enter(human1);
        room.enter(human2);
        room.enter(human3);
        List<String> names = room.getHumansNames();
        assertEquals(names.get(0), human1.getName());
        assertEquals(names.get(1), human2.getName());
        assertEquals(names.get(2), human3.getName());
    }

    @Test
    public void overfill(){
        Room room = new Room("", 20);
        Human human1 = new Human("1");
        Human human2 = new Human("2");
        Human human3 = new Human("3");

        room.enter(human1);
        room.enter(human2);
        boolean res = room.enter(human3);

        assertFalse(res);

    }
}