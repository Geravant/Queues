import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

import javax.print.attribute.IntegerSyntax;
import java.util.Iterator;

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

    @Test
    public void testIfAddFirstWorksAfterRemoveLast() {
        //Arrange
        deque = new Deque<Integer>();
        int expected = 6;
        //Act
        deque.addFirst(1);
        deque.removeLast();
        deque.addFirst(6);
        int actual = deque.removeLast();
        //Assert
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testIteratorAfterIntermixedCalls() {
        //Arrange
        deque = new Deque<Integer>();
        deque.addLast(1);
        deque.removeFirst();
        deque.addLast(3);
        deque.addFirst(4);

        deque.removeLast();
        int expected = 1;
        //Act
        int actual = 0;
        Iterator iterator = deque.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
            actual++;
        }
        Assert.assertEquals(expected, actual);
    }
    @After
    public void tearDown() {
        deque = null;
    }
}
