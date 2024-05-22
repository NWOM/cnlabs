import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class MulticastReceiver {
    public static void main(String[] args) {
        final int PORT = 8888;
        final String GROUP_ADDRESS = "230.0.0.1";

        try {
            // Create a multicast socket and join the multicast group
            MulticastSocket socket = new MulticastSocket(PORT);
            InetAddress group = InetAddress.getByName(GROUP_ADDRESS);
            socket.joinGroup(group);

            // Buffer to receive incoming data
            byte[] buffer = new byte[1024];

            // Create a DatagramPacket to receive data
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);

            System.out.println("Waiting for multicast message...");

            // Receive packet
            socket.receive(packet);

            // Extract message from packet
            String message = new String(packet.getData(), 0, packet.getLength());

            // Print received message
            System.out.println("Received multicast message: " + message);

            // Leave the multicast group
            socket.leaveGroup(group);
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

