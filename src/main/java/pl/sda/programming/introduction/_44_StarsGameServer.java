package pl.sda.programming.introduction;


import pl.sda.programming.introduction.game.GameState;
import pl.sda.programming.introduction.game.Server;

final class _44_StarsGameServer {

    public static void main(String[] args) {
        GameState state = new GameState(10, 10);
        state.generateNewGame();

        new Server(state).start();
    }
}
