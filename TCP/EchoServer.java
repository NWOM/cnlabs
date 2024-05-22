import java.io.*;
import java.net.*;
/* basic Java program demonstrating a simple echo client-server communication using TCP sockets. T*/
public class EchoServer {
    public static void main(String[] args) {
        try {
            // Create a server socket that listens on port 7777
            ServerSocket serverSocket = new ServerSocket(7777);
            System.out.println("Server started. Waiting for client...");

            // Accept client connection
            Socket clientSocket = serverSocket.accept();
            System.out.println("Client connected: " + clientSocket);

            // Create input and output streams for the client socket
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            // Read from and write to the client
            String message;
            while ((message = in.readLine()) != null) {
                System.out.println("Client says: " + message);
                out.println("Server echoes: " + message);
            }

            // Close streams and sockets
            in.close();
            out.close();
            clientSocket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

