import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class EchoClientUDP {
    public static void main(String[] args) {
        final int PORT = 7777;
        byte[] buffer;
        String message = "Hello, Server!";
        InetAddress serverAddress;

        try {
            // Get server address
            serverAddress = InetAddress.getLocalHost();

            // Create DatagramSocket
            DatagramSocket clientSocket = new DatagramSocket();

            // Convert message to bytes
            buffer = message.getBytes();

            // Create DatagramPacket to send data
            DatagramPacket sendPacket = new DatagramPacket(buffer, buffer.length, serverAddress, PORT);

            // Send packet to server
            clientSocket.send(sendPacket);

            // Create DatagramPacket to receive response
            DatagramPacket receivePacket = new DatagramPacket(buffer, buffer.length);

            // Receive response from server
            clientSocket.receive(receivePacket);

            // Convert response to string
            String response = new String(receivePacket.getData(), 0, receivePacket.getLength());
            System.out.println("Server response: " + response);

            // Close socket
            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

