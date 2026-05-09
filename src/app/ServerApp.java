package app;

/**
 * ServerApp starts the ServerThread and keeps running
 * while the server thread is active.
 */
public class ServerApp {

    /**
     * Main method for starting the threaded server application.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {

        ServerThread serverThread = new ServerThread();
        serverThread.start();

        while (serverThread.isAlive()) {
            System.out.println(".");

            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                System.out.println("ServerApp was interrupted: " + e.getMessage());
            }
        }

        System.out.println("ServerApp finished.");
    }
}