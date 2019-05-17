import edu.princeton.cs.algs4.StdRandom;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

public class TestRandomizedQueue {
    private RandomizedQueue randomizedQueue;

    @Test
    public void testIsEmptyTrueIf0Elements() {
        //Arrange
        randomizedQueue = new RandomizedQueue();
        //Act
        boolean expected = true;
        boolean actual = randomizedQueue.isEmpty();
        //Assert
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testIsEmptyFalseIf1Element() {
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
    public void testSizeIs0If0Elements() {
        //Arrange
        randomizedQueue = new RandomizedQueue();
        //Act
        int expected = 0;
        int actual = randomizedQueue.size();
        //Assert
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testSizeIs1If1Elements() {
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
    public void testSizeIs100If100Elements() {
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
    public void testDequeAAfterEnqueA() {
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
    public void testSampleAAfterEnqueA() {
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
    public void testThrowsIllegalArgumentExceptionIfEnqueNull() {
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
    public void testThrowsNoSuchElementExceptionIfDequeEmpty() {
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
    public void testThrowsNoSuchElementExceptionIfSampleEmpty() {
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

    @Test
    public void testIteratorHasNextFalseIf0Elements() {
        //Arrange
        randomizedQueue = new RandomizedQueue();
        //Act
        boolean expected = false;
        boolean actual = randomizedQueue.iterator().hasNext();
        //Assert
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testIteratorHasNextFalseTrueIf1Element() {
        //Arrange
        randomizedQueue = new RandomizedQueue();
        randomizedQueue.enqueue(1);
        //Act
        boolean expected = true;
        boolean actual = randomizedQueue.iterator().hasNext();
        //Assert
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testIteratorNextIsaIf1ElementIsa() {
        //Arrange
        randomizedQueue = new RandomizedQueue<Integer>();
        randomizedQueue.enqueue(1);
        //Act
        int expected = 1;
        int actual = (int)randomizedQueue.iterator().next();
        //Assert
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testIteratorThrowsNoSuchElementExceptionOnNextIfEmpty() {
        //Arrange
        randomizedQueue = new RandomizedQueue();
        Exception actual = null;
        //Act
        try {
            randomizedQueue.iterator().next();
        } catch (NoSuchElementException e) {
            actual = e;
        }
        //Assert
        Assert.assertTrue(NoSuchElementException.class.isInstance(actual));
    }

    @Test
    public void testIteratorThrowsUnsupportedOperationExceptionOnRemove() {
        //Arrange
        randomizedQueue = new RandomizedQueue();
        Exception actual = null;
        //Act
        try {
            randomizedQueue.iterator().remove();
        } catch (UnsupportedOperationException e) {
            actual = e;
        }
        //Assert
        Assert.assertTrue(UnsupportedOperationException.class.isInstance(actual));
    }

    @Test
    public void testIfDequesSame10ValuesThatEnques() {
        //Arrange
        RandomizedQueue<Integer> randomizedQueue = new RandomizedQueue<Integer>();
        Set<Integer> expectedDeques = new HashSet<Integer>();
        int numberOfEntries = 100;
        for (int i = 0; i< numberOfEntries; i++) {
            randomizedQueue.enqueue(i);
            expectedDeques.add(i);
        }
        boolean expected = true;
        boolean actual = true;
        int counter = 0;
        //Act
        while (actual && counter < numberOfEntries) {
            int dequeResult = randomizedQueue.dequeue();
            actual = expectedDeques.contains(dequeResult);
            expectedDeques.remove(dequeResult);
            counter++;
        }
        System.out.println(counter);
        //Assert
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testIfTwoIteratorsWorkCorrecly() {
      //Arrange
      RandomizedQueue<Integer> randomizedQueue = new RandomizedQueue<Integer>();
      int numberOfEntries = 100;
      for (int i = 0; i< numberOfEntries; i++) {
        randomizedQueue.enqueue(i);
      }
      int expected = numberOfEntries;
      Iterator<Integer> firstIterator = randomizedQueue.iterator();
      Iterator<Integer> secondIterator = randomizedQueue.iterator();
      int counter = 0;
      //Act
      while (firstIterator.hasNext() && secondIterator.hasNext()) {
        firstIterator.next();
        secondIterator.next();
        counter++;
      }
      int actual = counter;
      //Assert
      Assert.assertEquals(expected, actual);
    }

    @After
    public void tearDown() {
        randomizedQueue = null;
    }
}
