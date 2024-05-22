import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class EchoServerUDP {
    public static void main(String[] args) {
        final int PORT = 7777;
        byte[] buffer = new byte[1024];

        try {
            // Create a DatagramSocket to listen for incoming datagrams
            DatagramSocket serverSocket = new DatagramSocket(PORT);
            System.out.println("Server started. Waiting for client...");

            // Create a DatagramPacket to receive data
            DatagramPacket receivePacket = new DatagramPacket(buffer, buffer.length);

            while (true) {
                // Receive packet from client
                serverSocket.receive(receivePacket);

                // Extract message from packet
                String message = new String(receivePacket.getData(), 0, receivePacket.getLength());
                System.out.println("Client says: " + message);

                // Prepare packet to send response
                DatagramPacket sendPacket = new DatagramPacket(receivePacket.getData(), receivePacket.getLength(),
                        receivePacket.getAddress(), receivePacket.getPort());

                // Send response back to client
                serverSocket.send(sendPacket);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

