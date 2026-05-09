package app;

import java.io.IOException;

/**
 * ServerThread class runs the Server inside its own thread.
 */
public class ServerThread extends Thread {

    /**
     * Runs the server on a separate thread.
     */
    @Override
    public void run() {

        Server server = new Server();

        try {
            server.start(6666);
            server.cleanup();
        } catch (IOException e) {
            System.out.println("ServerThread error: " + e.getMessage());
        }
    }
}