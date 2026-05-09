package app;

import java.util.Random;

public class CounterThread extends Thread {

    @Override
    public void run() {

        Random random = new Random();
        int sleepTime = random.nextInt(1000) + 1;

        try {
            Thread.sleep(sleepTime);
        } catch (InterruptedException e) {
            System.out.println("CounterThread was interrupted.");
        }

        Counter.increment();
    }
}