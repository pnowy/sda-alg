package pl.sda.programming.introduction.game;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public final class Server {

    // game state
    private final GameState gameState;

    public Server(GameState gameState) {
        this.gameState = gameState;
    }

    public void start() {
        try (ServerSocket serverSocket = new ServerSocket(8088)) {

            System.out.println("Server started. Waiting for clients...");
            while (true) {
                Socket socket = serverSocket.accept();
                new Thread(new ClientHandler(socket, gameState)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
