import java.io.IOException;
import java.net.*;

public class UDPBroadcastSender {
    public static void main(String[] args) {
        final int PORT = 8888;
        DatagramSocket socket = null;

        try {
            // Create DatagramSocket
            socket = new DatagramSocket();

            // Set broadcast address
            InetAddress broadcastAddress = InetAddress.getByName("255.255.255.255");

            // Message to send
            String message = "This is a UDP broadcast message.";

            // Convert message to bytes
            byte[] buffer = message.getBytes();

            // Create DatagramPacket
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length, broadcastAddress, PORT);

            // Send packet
            socket.send(packet);

            System.out.println("Broadcast message sent.");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (socket != null) {
                socket.close();
            }
        }
    }
}

