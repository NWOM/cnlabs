package Multicast;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class MulticastSender {
    public static void main(String[] args) {
        final int PORT = 8888;
        final String GROUP_ADDRESS = "230.0.0.1";

        try {
            // Create a multicast socket
            MulticastSocket socket = new MulticastSocket();

            // Set the time-to-live for the multicast packets
            socket.setTimeToLive(1);

            // Specify the multicast group
            InetAddress group = InetAddress.getByName(GROUP_ADDRESS);

            // Message to send
            String message = "Hello, multicast!";

            // Convert the message to bytes
            byte[] buffer = message.getBytes();

            // Create a DatagramPacket to send
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length, group, PORT);

            // Send the packet
            socket.send(packet);

            System.out.println("Multicast message sent to group: " + GROUP_ADDRESS);
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
