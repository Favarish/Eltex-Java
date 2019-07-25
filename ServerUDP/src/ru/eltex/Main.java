package ru.eltex;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Main {

    public static void main(String[] args) {
        try {
            DatagramSocket ds = new DatagramSocket(5003);
            while (true){
                DatagramPacket pack = new DatagramPacket(new byte[1024], 1024);
                ds.receive(pack);
                System.out.println(new String(pack.getData()));
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
