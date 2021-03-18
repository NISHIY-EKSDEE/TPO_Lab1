import org.junit.Assert;
import org.junit.Test;

public class TestHashMapCH {

    @Test
    public void testBasicFuntions() {
        HashMapCH h = new HashMapCH(5);

        int initializedSize = h.sizeofMap();
        boolean isEmptyAfterInit = h.isEmpty();
        int hashcode = h.hashCode(2);
        boolean isInserted = h.insertNode(2, 3);
        int gotValue = h.get(2);
        Integer gotFromEmptyNode = h.get(4);
        boolean isEmptyAfterInsert = h.isEmpty();
        int sizeAfterInsert = h.sizeofMap();
        Integer deletedEmptyNode = h.deleteNode(4);
        int deletedValue = h.deleteNode(2);
        int sizeAfterDelete = h.sizeofMap();
        boolean isEmptyAfterDelete = h.isEmpty();

        Assert.assertEquals(initializedSize, 0);
        Assert.assertTrue(isEmptyAfterInit);
        Assert.assertEquals(hashcode, 2);
        Assert.assertTrue(isInserted);
        Assert.assertEquals(gotValue, 3);
        Assert.assertNull(gotFromEmptyNode);
        Assert.assertFalse(isEmptyAfterInsert);
        Assert.assertEquals(sizeAfterInsert, 1);
        Assert.assertNull(deletedEmptyNode);
        Assert.assertEquals(deletedValue, 3);
        Assert.assertEquals(sizeAfterDelete, 0);
        Assert.assertTrue(isEmptyAfterDelete);
    }

    @Test
    public void testMultipleSameKeyInsertAndDelete() {
        HashMapCH h = new HashMapCH(5);

        boolean firstInsert = h.insertNode(2, 0);
        boolean secondInsert = h.insertNode(2, 1);
        boolean thirdInsert = h.insertNode(2, 2);
        boolean fourthInsert = h.insertNode(2, 3);
        boolean fifthInsert = h.insertNode(2, 4);
        boolean sixthInsert = h.insertNode(2, 5);
        boolean seventhInsert = h.insertNode(3, 6);
        Integer secondElem = h.get(1);
        int firstDelete = h.deleteNode(2);
        int secondDelete = h.deleteNode(2);
        int thirdDelete = h.deleteNode(2);
        int fourthDelete = h.deleteNode(2);
        int fifthDelete = h.deleteNode(2);
        Integer sixthDelete = h.deleteNode(2);
        Integer seventhDelete = h.deleteNode(3);

        Assert.assertTrue(firstInsert);
        Assert.assertTrue(secondInsert);
        Assert.assertTrue(thirdInsert);
        Assert.assertTrue(fourthInsert);
        Assert.assertTrue(fifthInsert);
        Assert.assertFalse(sixthInsert);
        Assert.assertFalse(seventhInsert);
        Assert.assertNull(secondElem);
        Assert.assertEquals(firstDelete, 0);
        Assert.assertEquals(secondDelete, 1);
        Assert.assertEquals(thirdDelete, 2);
        Assert.assertEquals(fourthDelete, 3);
        Assert.assertEquals(fifthDelete, 4);
        Assert.assertNull(sixthDelete);
        Assert.assertNull(seventhDelete);
    }

    @Test
    public void testOffset() {
        HashMapCH h = new HashMapCH(5);

        h.insertNode(0, 0);
        h.insertNode(0, 1);
        h.insertNode(1, 2);
        h.insertNode(0, 3);

        int firstNode = h.get(1);

        h.deleteNode(0);
        int secondNode = h.get(0);

        h.deleteNode(0);
        int thirdNode = h.get(0);

        Assert.assertEquals(firstNode, 2);
        Assert.assertEquals(secondNode, 1);
        Assert.assertEquals(thirdNode, 3);
    }
}
