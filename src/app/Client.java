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

    public void start(String ip, int port) throws IOException {

        clientSocket = new Socket(ip, port);

        out = new PrintWriter(clientSocket.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

        System.out.println("Client connected to server.");
    }

    public String sendMessage(String message) throws IOException {

        out.println(message);
        return in.readLine();
    }

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

    public static void main(String[] args) {

        Client client = new Client();

        try {
            client.start("127.0.0.1", 9999);

            System.out.println("Server Response: " + client.sendMessage("Message 1"));
            System.out.println("Server Response: " + client.sendMessage("Message 2"));
            System.out.println("Server Response: " + client.sendMessage("Message 3"));
            System.out.println("Server Response: " + client.sendMessage("Message 4"));
            System.out.println("Server Response: " + client.sendMessage("Message 5"));
            System.out.println("Server Response: " + client.sendMessage("Message 6"));
            System.out.println("Server Response: " + client.sendMessage("Message 7"));
            System.out.println("Server Response: " + client.sendMessage("Message 8"));
            System.out.println("Server Response: " + client.sendMessage("."));

            client.cleanup();

        } catch (IOException e) {
            System.out.println("Client error: " + e.getMessage());
        }
    }
}