package app;

public class CounterWorker {

    public static void main(String[] args) {

        System.out.println("Starting counter value: " + Counter.getCount());

        CounterThread[] threads = new CounterThread[1000];

        for (int i = 0; i < threads.length; i++) {
            threads[i] = new CounterThread();
            threads[i].start();
        }

        for (int i = 0; i < threads.length; i++) {
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                System.out.println("Thread was interrupted while waiting.");
            }
        }

        System.out.println("Ending counter value: " + Counter.getCount());
    }
}