package lab7;

import java.util.LinkedList;
import java.util.Random;

public class Game {
    private int m;
    private int n;
    private int k;
    private LinkedList<Player> players = new LinkedList<Player>();
    private Board board;

    public Game(int m, int n, int k, LinkedList<Player> players, Board board) {
        this.m = m;
        this.n = n;
        this.k = k;
        this.players = players;
        this.board = board;
    }

    public void startGame() {
        Random rand = new Random();
        LinkedList<Player> copyPlayers = players;
        while ( copyPlayers.size() != 0 ){
            int randPoz = rand.nextInt(copyPlayers.size());
            players.get(randPoz).setTurn(randPoz);
            players.get(randPoz).setK(k);
            new Thread(players.get(randPoz)).start();
            copyPlayers.remove(randPoz);
        }
    }

    public int getM() {
        return m;
    }

    public int getN() {
        return n;
    }

    public int getK() {
        return k;
    }

    public LinkedList<Player> getPlayers() {
        return players;
    }

    public Board getBoard() {
        return board;
    }

    @Override
    public String toString() {
        return "Game{" +
                "\nm=" + m +
                ", n=" + n +
                ", k=" + k +
                ", \nplayers=" + players +
                ", \nboards=" + board +
                '}';
    }
}
