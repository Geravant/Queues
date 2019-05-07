import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

public class TestDeque {
    private Deque<Integer> deque;

    @Test
    public void testInitialIsEmpty() {
        //Arrange
        deque = new Deque();
        //Assert
        Assert.assertTrue(deque.isEmpty());
    }

    @Test
    public void testHasFirstElement1AfterAddFirst1 () {
        //Arrange
        deque = new Deque();
        int expected = 1;
        //Act
        deque.addFirst(1);
        int actual = deque.removeFirst();
        //Assert
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testHasLastElement1AfterAddLast1 () {
        //Arrange
        deque = new Deque();
        int expected = 1;
        //Act
        deque.addLast(1);
        int actual = deque.removeLast();
        //Assert
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testHasLastElement1AfterAddFirst1 () {
        //Arrange
        deque = new Deque();
        int expected = 1;
        //Act
        deque.addFirst(1);
        int actual = deque.removeLast();
        //Assert
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testHasFirstElement1AfterAddLast1 () {
        //Arrange
        deque = new Deque();
        int expected = 1;
        //Act
        deque.addLast(1);
        int actual = deque.removeFirst();
        //Assert
        Assert.assertEquals(expected, actual);
    }
    @After
    public void tearDown() {
        deque = null;
    }
}
