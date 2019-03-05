package pl.sda.programming.introduction.game;

import java.io.*;
import java.net.Socket;

public final class Client {

    private final Socket socket;

    public Client(Socket socket) {
        this.socket = socket;
    }

    public void start() {
        try (BufferedReader reader = getReader();
             PrintWriter writer = getWriter();
             BufferedReader consoleReader = getConsoleReader()) {

            System.out.println("What's your name?");
            String name = consoleReader.readLine();

            writer.println(name);

            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println("From Server: " + line);
                System.out.println("Your shot:");
                String message = consoleReader.readLine();
                writer.println(message);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private BufferedReader getConsoleReader() {
        return new BufferedReader(new InputStreamReader(System.in));
    }

    private PrintWriter getWriter() throws IOException {
        return new PrintWriter(new OutputStreamWriter(socket.getOutputStream()), true);
    }

    private BufferedReader getReader() throws IOException {
        return new BufferedReader(new InputStreamReader(socket.getInputStream()));
    }
}
