package pl.sda.programming.introduction.game;

import java.io.*;
import java.net.Socket;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class ClientHandler implements Runnable {

    private static final Pattern MSG_PATTERN = Pattern.compile("@\\{(\\d+),(\\d+)\\}");

    private final Socket socket;
    private final GameState gameState;

    ClientHandler(Socket socket, GameState gameState) {
        this.socket = socket;
        this.gameState = gameState;
    }

    @Override
    public void run() {
        try (BufferedReader reader = getReader();
             PrintWriter writer = getWriter()) {

            String name = reader.readLine();
            System.out.println("Client connected: " + name);

            writer.println("Hello " + name);

            String line;
            while ((line = reader.readLine()) != null) {
                // parse message
                // @{2,7}
                Matcher matcher = MSG_PATTERN.matcher(line);
                if (matcher.matches()) {
                    handleUserInput(writer, name, matcher);
                } else {
                    writer.println("you sent invalid message");
                }
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void handleUserInput(PrintWriter writer, String name, Matcher matcher) {
        int x = Integer.valueOf(matcher.group(1));
        int y = Integer.valueOf(matcher.group(2));

        if (gameState.tryShot(name, x, y)) {
            System.out.println("GOOOD SHOOT!!! " + name + " congratulations!!");
            if (gameState.isOver()) {
                System.out.println("Game is over. See results:");
                gameState.printLeaders();
                gameState.generateNewGame();
                System.out.println("Server generated new game!");
            } else {
                gameState.printShots();
                gameState.printLeaders();
            }

            writer.println("Well done. You hit the star!!");
        } else {
            writer.println("Ughhhh... try again! Good luck!");
        }
    }

    private PrintWriter getWriter() throws IOException {
        return new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
    }

    private BufferedReader getReader() throws IOException {
        return new BufferedReader(new InputStreamReader(socket.getInputStream()));
    }
}
