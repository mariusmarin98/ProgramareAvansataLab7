package lab7;

import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
        LinkedList<Player> players = new LinkedList<Player>();

        Board board = new Board(20);
        Player p1 = new Player("Player 1", board);
        Player p2 = new Player("Player 2", board);
        Player p3 = new Player("Player 3", board);
        Player p4 = new Player("Player 4", board);

        players.add(p1);
        players.add(p2);
        players.add(p3);
        players.add(p4);
        Game game = new Game(20, board.getN(), 3, players, board);
        System.out.println(game);
        game.startGame();
    }
}
