package jav.threadsplane;

import java.util.concurrent.BlockingQueue;

public class Strip implements Runnable {

    private final BlockingQueue<Integer> queue;

    public void run() {

        try {
            while (true) {
                Integer take = queue.take();
                process(take);
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

    }

    private void process(Integer take) throws InterruptedException {
        System.out.println("The plane took off : " + take);
        Thread.sleep(1000);
        System.out.println("The strip is open " );
    }

    public Strip(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }
}