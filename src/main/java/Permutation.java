import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.NoSuchElementException;

public class Permutation {
    public static void main(String[] args) {
        int k = Integer.parseInt(args[0]);
        RandomizedQueue<String> randomizedQueue = new RandomizedQueue<String>();
        while (true) {
            try {
                randomizedQueue.enqueue(StdIn.readString());
            }
            catch (NoSuchElementException e) {
                break;
            }
        }
        for (int i = 0; i< k; i++) {
            StdOut.println(randomizedQueue.dequeue());
        }
    }
}
