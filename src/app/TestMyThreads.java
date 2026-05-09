package app;

public class TestMyThreads {

    public static void main(String[] args) {

        MyThread1 thread1 = new MyThread1();
        thread1.start();

        Runnable thread2Runnable = new MyThread2();
        Thread thread2 = new Thread(thread2Runnable);
        thread2.start();
    }
}