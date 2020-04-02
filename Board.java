package lab7;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class Board {
    private LinkedList<Token> tokens = new LinkedList<Token>();
    private int n;
    private volatile boolean available = true;
    private volatile boolean empty = false;

    public Board(int n) {
        for (int i = 1; i <= n; i++) {
            Token t;
            if (blankTokenProbability(15))
                t = new Token(i, true);
            else
                t = new Token(i ,false);
            this.tokens.add(t);
        }
        this.n = n;
    }

    public boolean blankTokenProbability(int probability)
    {
        Random rand = new Random();

        int random_number = rand.nextInt(100);
        return random_number < probability;
    }

    public synchronized Token extractToken(int playerTurn) {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (!tokens.isEmpty()) {
            Token t;

            Random rand = new Random();
            int idx = rand.nextInt(tokens.size());

            t = tokens.get(idx);
            tokens.remove(idx);

            notifyAll();
            System.out.println("Player " + (playerTurn + 1) + " picked " + t);
            return t;
        }
        available = false;
        empty=true;
        notifyAll();
        return null;
    }

    public synchronized void win(List<Token> tokens,int playerTurn){
        available = false;
        notifyAll();
        System.out.println("Player " + (playerTurn+1) + " with tokens " + tokens + " won the game!");
    }

    public synchronized boolean isEmpty() {
        return tokens.isEmpty();
    }

    public synchronized boolean isAvailable() {
        return available;
    }

    public synchronized void setAvailable(boolean available) {
        this.available = available;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    @Override
    public String toString() {
        return "Board{" +
                "tokens=" + tokens +
                '}';
    }
}
