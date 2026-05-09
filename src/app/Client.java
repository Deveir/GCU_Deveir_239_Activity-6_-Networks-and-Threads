package app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Client class that connects to the server,
 * sends messages, and receives responses.
 */
public class Client {

    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;

    /**
     * Starts the client connection.
     *
     * @param ip the IP address of the server
     * @param port the port number of the server
     * @throws IOException if a network error occurs
     */
    public void start(String ip, int port) throws IOException {

        clientSocket = new Socket(ip, port);

        out = new PrintWriter(clientSocket.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        System.out.println("Client connected to server.");
    }

    /**
     * Sends a message to the server and returns the server response.
     *
     * @param message the message being sent to the server
     * @return the response from the server
     * @throws IOException if a network error occurs
     */
    public String sendMessage(String message) throws IOException {

        out.println(message);
        return in.readLine();
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

        System.out.println("Client closed.");
    }

    /**
     * Main method for running the client.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {

        Client client = new Client();

        try {
            client.start("127.0.0.1", 6666);

            System.out.println("Server Response: " + client.sendMessage("Message 1"));
            Thread.sleep(5000);

            System.out.println("Server Response: " + client.sendMessage("Message 2"));
            Thread.sleep(5000);

            System.out.println("Server Response: " + client.sendMessage("Message 3"));
            Thread.sleep(5000);

            System.out.println("Server Response: " + client.sendMessage("Message 4"));
            Thread.sleep(5000);

            System.out.println("Server Response: " + client.sendMessage("Message 5"));
            Thread.sleep(5000);

            System.out.println("Server Response: " + client.sendMessage("Message 6"));
            Thread.sleep(5000);

            System.out.println("Server Response: " + client.sendMessage("Message 7"));
            Thread.sleep(5000);

            System.out.println("Server Response: " + client.sendMessage("Message 8"));
            Thread.sleep(5000);

            System.out.println("Server Response: " + client.sendMessage("."));

            client.cleanup();

        } catch (IOException e) {
            System.out.println("Client error: " + e.getMessage());
        } catch (InterruptedException e) {
            System.out.println("Client was interrupted: " + e.getMessage());
        }
    }
}