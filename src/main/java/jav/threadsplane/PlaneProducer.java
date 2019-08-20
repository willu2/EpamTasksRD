package jav.threadsplane;

import java.util.concurrent.BlockingQueue;

public class PlaneProducer implements Runnable {

    private final BlockingQueue<Integer> queue;

    public void run() {

        try {
            process();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

    }

    private void process() throws InterruptedException {

        //Put 10 planes into Queue
        for (int i = 0; i < 10; i++) {
            System.out.println("The plane began to enter the strip : " + i);
            queue.put(i);
            System.out.println("The plane is on the strip " + i );
            Thread.sleep(1000);
        }

    }

    public PlaneProducer(BlockingQueue<Integer> queue) {
        this.queue = queue;
    }
}