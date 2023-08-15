package design;

import java.util.Queue;

public class BlockingQueueWithSync {
    private int[] array;
    private int head;
    private int tail;
    private int size;

    BlockingQueueWithSync (int capacity) {
        array = new int[capacity];
    }

    public synchronized void put(int element) throws InterruptedException {
        while (size == array.length) {
            wait();
        }
        array[tail] = element;
        tail++;
        if (tail == array.length) {
            tail = 0;
        }
        size++;
        notify();
    }

    public synchronized int take() throws InterruptedException {
        while (size == 0) {
            wait();
        }
        int element = array[head];
        if (++head == array.length) {
            head = 0;
        }
        size--;
        notify();
        return element;
    }
}
