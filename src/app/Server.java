 package app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Server class that waits for a client connection,
 * receives messages, and sends responses back to the client.
 */
public class Server {

    private ServerSocket serverSocket;
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;

    /**
     * Starts the server on the given port.
     *
     * @param port the port number the server will listen on
     * @throws IOException if a network error occurs
     */
    public void start(int port) throws IOException {

        serverSocket = new ServerSocket(port);
        System.out.println("Server started. Waiting for client connection...");

        clientSocket = serverSocket.accept();
        System.out.println("Client connected.");

        out = new PrintWriter(clientSocket.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        String message;

        while ((message = in.readLine()) != null) {

            System.out.println("Message from Client: " + message);

            if (message.equals(".")) {
                out.println("QUIT");
                break;
            } else {
                out.println("OK");
            }
        }
    }

    /**
     * Closes all networking objects.
     *
     * @throws IOException if an error occurs while closing
     */
    public void cleanup() throws IOException {

        if (in != null) {
            in.close();
        }

        if (out != null) {
            out.close();
        }

        if (clientSocket != null) {
            clientSocket.close();
        }

        if (serverSocket != null) {
            serverSocket.close();
        }

        System.out.println("Server closed.");
    }
}