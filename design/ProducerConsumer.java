package design;

public class ProducerConsumer {
    private static int count = 0;
    private static final Integer FULL = 10;
    private static final String LOCK = "lock";

    public static void main(String[] args) {
//        ProducerConsumer testMain = new ProducerConsumer();
        new Thread(new Producer()).start();
        new Thread(new Consumer()).start();
        new Thread(new Producer()).start();
        new Thread(new Consumer()).start();
        new Thread(new Producer()).start();
        new Thread(new Consumer()).start();
        new Thread(new Producer()).start();
        new Thread(new Consumer()).start();
    }

    static class Producer implements Runnable {
        @Override
        public void run() {
            synchronized (LOCK) {
                while (count == FULL) { // 缓存空间满了
                    try {
                        LOCK.wait(); // 线程阻塞
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                count++; // 生产者
                System.out.println(Thread.currentThread().getName() + "生产者生产，目前总共有" + count);
                LOCK.notifyAll(); // 唤醒所有线程
            }
        }
    }

    static class Consumer implements Runnable {
        @Override
        public void run() {
            synchronized (LOCK) {
                while (count == 0) {
                    try {
                        LOCK.wait();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                count--;
                System.out.println(Thread.currentThread().getName() + "消费者消费，目前总共有 " + count);
                LOCK.notifyAll(); // 唤醒所有线程
            }
        }
    }
}
