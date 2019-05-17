import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class RandomizedQueue<Item> implements Iterable<Item> {
    private Node<Item> firstNode;
    private int size;

    public RandomizedQueue() {
        size = 0;
    }           // construct an empty randomized queue
    public boolean isEmpty() {
        return size == 0;
    }                // is the randomized queue empty?
    public int size() {
        return size;
    } // return the number of items on the randomized queue
    public void enqueue(Item item) {
        if (item == null) throw new IllegalArgumentException();
        if (firstNode == null) {
            firstNode = new Node(item);
        }
        else {
            Node newNode = new Node(item);
            firstNode.previousNode = newNode;
            newNode.nextNode = firstNode;
            firstNode = newNode;
        }
        size++;
    }           // add the item
    public Item dequeue() {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        Node<Item> randomNode = randomNode();
        size--;
        return dequeNode(randomNode);
    }                     // remove and return a random item
    public Item sample() {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        return randomNode().item;
    }                     // return a random item (but do not remove it)
    public Iterator<Item> iterator() {
        return new RandomizedQueueIterator<Item>();
    }         // return an independent iterator over items in random order
    public static void main(String[] args) {

    }   // unit testing (optional)

    private Item dequeNode(Node resultNode) {
        Item result = (Item) resultNode.item;
        if (resultNode.nextNode != null) {
            if (resultNode.previousNode != null) {
                resultNode.nextNode.previousNode = resultNode.previousNode;
                resultNode.previousNode.nextNode = resultNode.nextNode;
            }
            else {
                firstNode = resultNode.nextNode;
                resultNode.nextNode.previousNode = null;
            }
        }
        else if (resultNode.previousNode != null) {
            resultNode.previousNode.nextNode = null;
        }
        else firstNode = null;
        return result;
    }

    private Node<Item> randomNode() {
        int[] frequencies = new int[size];
        for (int i = 0; i< size; i++) {
            frequencies[i] = 1;
        }
        int randomIndex = StdRandom.discrete(frequencies);
        Node resultNode = firstNode;
        for (int i = 1; i < randomIndex ; i++) {
            resultNode = resultNode.nextNode;
        }
        return  resultNode;
    }

    private class Node<Item> {
        public Node(Item item) {
            this.item = item;
        }

        public Item item;
        public Node<Item> nextNode;
        public Node<Item> previousNode;
    }

    private class RandomizedQueueIterator<Item> implements Iterator<Item> {
        private RandomizedQueue<Item> iteratedQueue;

        public RandomizedQueueIterator() {
            iteratedQueue = new RandomizedQueue<Item>();
            if (!isEmpty()) {
                Node<Item> currentNode = (Node<Item>)firstNode;
                while (currentNode.nextNode != null) {
                    iteratedQueue.enqueue(currentNode.item);
                    currentNode = currentNode.nextNode;
                }
                iteratedQueue.enqueue(currentNode.item);
            }
        }

        @Override
        public boolean hasNext() {
            return iteratedQueue.size() != 0;
        }

        @Override
        public Item next() {
            if (hasNext()) {
                return iteratedQueue.dequeue();
            }
            else throw new NoSuchElementException();
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}