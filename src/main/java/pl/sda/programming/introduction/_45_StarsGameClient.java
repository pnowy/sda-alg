package pl.sda.programming.introduction;


import pl.sda.programming.introduction.game.Client;

import java.io.IOException;
import java.net.Socket;

final class _45_StarsGameClient {

    public static void main(String[] args) {
        try (Socket socket = new Socket("127.0.0.1", 8088)) {

            new Client(socket).start();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
