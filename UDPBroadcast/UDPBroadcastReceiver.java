import java.io.IOException;
import java.net.*;

public class UDPBroadcastReceiver {
    public static void main(String[] args) {
        final int PORT = 8888;
        DatagramSocket socket = null;

        try {
            // Create DatagramSocket
            socket = new DatagramSocket(PORT);

            // Set timeout for receiving packets
            socket.setSoTimeout(10000); // 10 seconds

            // Buffer to receive incoming data
            byte[] buffer = new byte[1024];

            // Create DatagramPacket to receive data
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);

            System.out.println("Waiting for broadcast message...");

            // Receive packet
            socket.receive(packet);

            // Extract message from packet
            String message = new String(packet.getData(), 0, packet.getLength());

            // Print received message
            System.out.println("Received broadcast message: " + message);
        } catch (SocketTimeoutException e) {
            System.out.println("Timeout reached. No broadcast message received.");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (socket != null) {
                socket.close();
            }
        }
    }
}

