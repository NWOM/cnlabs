import java.io.*;
import java.net.*;
/* basic Java program demonstrating a simple echo client-server communication using TCP sockets. T*/
public class EchoClient {
    public static void main(String[] args) {
        try {
            // Connect to the server
            Socket socket = new Socket("localhost", 7777);
            System.out.println("Connected to server.");

            // Create input and output streams for the socket
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            // Send a message to the server
            out.println("Hello, Server!");

            // Receive and print the echoed message from the server
            String response = in.readLine();
            System.out.println("Server response: " + response);

            // Close streams and socket
            in.close();
            out.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

