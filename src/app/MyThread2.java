package app;

public class MyThread2 implements Runnable {

    @Override
    public void run() {

        for (int i = 1; i <= 100; i++) {
            System.out.println("MyThread2 iteration: " + i);

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println("MyThread2 was interrupted.");
            }
        }
    }
}