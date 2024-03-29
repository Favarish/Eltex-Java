package ru.eltex;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Main {
    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket(5004);
        DatagramPacket packet = new DatagramPacket (new byte[1024], 1024);
        while (true) {
            try {
                socket.receive (packet);
                System.out.println("Received from: " + packet.getAddress() + ":" + packet.getPort() +
                        "\n Massage: " + new String(packet.getData(), "UTF-8"));
            } catch (IOException error) {
                error.getMessage();
            }
        }
    }
}