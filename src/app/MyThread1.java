 package app;

public class MyThread1 extends Thread {

    @Override
    public void run() {

        for (int i = 1; i <= 100; i++) {
            System.out.println("MyThread1 iteration: " + i);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("MyThread1 was interrupted.");
            }
        }
    }
}
