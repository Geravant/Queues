import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Consumer;

public class Deque<Item> implements Iterable<Item>{
    private Node<Item> firstNode;
    private Node<Item> lastNode;
    private int size;

    @Override
    // return an iterator over items in order from front to end
    public Iterator<Item> iterator() {
        return new DequeIterator<>(firstNode);
    }

    public Deque() {
        size = 0;
    }                           // construct an empty deque
    public boolean isEmpty() {
        return size == 0;
    }                 // is the deque empty?
    public int size() {
        return size;
    }                       // return the number of items on the deque
    public void addFirst(Item item) {
        if (item == null) throw new IllegalArgumentException();
        if (firstNode == null) {
            firstNode = new Node(item);
            lastNode = firstNode;
        }
        else {
            Node newNode = new Node(item);
            firstNode.previousNode = newNode;
            newNode.nextNode = firstNode;
            firstNode = newNode;
        }
        size++;
    }          // add the item to the front
    public void addLast(Item item) {
        if (item == null) throw new IllegalArgumentException();
        if (lastNode == null) {
            lastNode = new Node(item);
            firstNode = lastNode;
        }
        else {
            Node newNode = new Node(item);
            lastNode.nextNode = newNode;
            newNode.previousNode = lastNode;
            lastNode = newNode;
        }
        size++;
    }          // add the item to the end
    public Item removeFirst() {
        if (size == 0) throw new NoSuchElementException();
        Item result = firstNode.item;
        firstNode = firstNode.nextNode;
        size--;
        return  result;
    }               // remove and return the item from the front
    public Item removeLast() {
        if (size == 0) throw new NoSuchElementException();
        Item result = lastNode.item;
        lastNode = lastNode.previousNode;
        size--;
        return  result;
    }                // remove and return the item from the end
    public static void main(String[] args) {}  // unit testing (optional)

    private class Node<Item> {
        public Node(Item item) {
            this.item = item;
        }

        public Item item;
        public Node<Item> nextNode;
        public Node<Item> previousNode;
    }

    private class DequeIterator<Item> implements Iterator<Item> {
        private Node<Item> nextNodeInIteration;

        public DequeIterator(Node node) {
            nextNodeInIteration = node;
        }

        @Override
        public boolean hasNext() {
            return nextNodeInIteration != null;
        }

        @Override
        public Item next() {
            if (hasNext()) {
                Node<Item> currentNode = nextNodeInIteration;
                nextNodeInIteration = nextNodeInIteration.nextNode;
                return currentNode.item;
            }
            else throw new NoSuchElementException();
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}
