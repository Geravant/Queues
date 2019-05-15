import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.NoSuchElementException;

public class TestRandomizedQueue {
    private RandomizedQueue randomizedQueue;

    @Test
    public void TestIsEmptyTrueIf0Elements() {
        //Arrange
        randomizedQueue = new RandomizedQueue();
        //Act
        boolean expected = true;
        boolean actual = randomizedQueue.isEmpty();
        //Assert
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void TestIsEmptyTrueIf1Element() {
        //Arrange
        randomizedQueue = new RandomizedQueue();
        randomizedQueue.enqueue(1);
        //Act
        boolean expected = false;
        boolean actual = randomizedQueue.isEmpty();
        //Assert
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void TestSizeIs0If0Elements() {
        //Arrange
        randomizedQueue = new RandomizedQueue();
        //Act
        int expected = 0;
        int actual = randomizedQueue.size();
        //Assert
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void TestSizeIs1If1Elements() {
        //Arrange
        randomizedQueue = new RandomizedQueue();
        randomizedQueue.enqueue("a");
        //Act
        int expected = 1;
        int actual = randomizedQueue.size();
        //Assert
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void TestSizeIs100If100Elements() {
        //Arrange
        randomizedQueue = new RandomizedQueue();
        for (int i =0; i< 100; i++) {
            randomizedQueue.enqueue("a");
        }
        //Act
        int expected = 100;
        int actual = randomizedQueue.size();
        //Assert
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void TestDequeAAfterEnqueA() {
        //Arrange
        RandomizedQueue<String> randomizedQueue = new RandomizedQueue();
        randomizedQueue.enqueue("A");
        //Act
        String expected = "A";
        String actual = randomizedQueue.dequeue();
        int expectedSize = 0;
        int actualSize = randomizedQueue.size();
        //Assert
        Assert.assertEquals(expected, actual);
        Assert.assertEquals(expectedSize, actualSize);
    }

    @Test
    public void TestSampleAAfterEnqueA() {
        //Arrange
        RandomizedQueue<String> randomizedQueue = new RandomizedQueue();
        randomizedQueue.enqueue("A");
        //Act
        String expected = "A";
        String actual = randomizedQueue.sample();
        int expectedSize = 1;
        int actualSize = randomizedQueue.size();
        //Assert
        Assert.assertEquals(expected, actual);
        Assert.assertEquals(expectedSize, actualSize);
    }

    @Test
    public void TestThrowsIllegalArgumentExceptionIfEnqueNull() {
        //Arrange
        randomizedQueue = new RandomizedQueue();
        Exception actual = null;
        //Act
        try {
            randomizedQueue.enqueue(null);
        } catch (IllegalArgumentException e) {
            actual = e;
        }
        //Assert
        Assert.assertTrue(IllegalArgumentException.class.isInstance(actual));
    }

    @Test
    public void TestThrowsNoSuchElementExceptionIfDequeEmpty() {
        //Arrange
        randomizedQueue = new RandomizedQueue();
        Exception actual = null;
        //Act
        try {
            randomizedQueue.dequeue();
        } catch (NoSuchElementException e) {
            actual = e;
        }
        //Assert
        Assert.assertTrue(NoSuchElementException.class.isInstance(actual));
    }

    @Test
    public void TestThrowsNoSuchElementExceptionIfSampleEmpty() {
        //Arrange
        randomizedQueue = new RandomizedQueue();
        Exception actual = null;
        //Act
        try {
            randomizedQueue.sample();
        } catch (NoSuchElementException e) {
            actual = e;
        }
        //Assert
        Assert.assertTrue(NoSuchElementException.class.isInstance(actual));
    }

    @After
    public void tearDown() {
        randomizedQueue = null;
    }
}
