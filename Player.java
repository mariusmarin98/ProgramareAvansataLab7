package lab7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Player implements Runnable {
    private String name;
    private int myTurn;
    private int k;
    private final Board board;
    private List<Token> tokens = new ArrayList<>();

    public Player(String name, Board board) {
        this.name = name;
        this.board = board;
    }

    public String getName() {
        return name;
    }

    public List<Token> getTokens() {
        return tokens;
    }

    public Board getBoard() {
        return board;
    }

    public int getTurn() {
        return myTurn;
    }

    public void setTurn(int turn) {
        this.myTurn = turn;
    }

    public int getK() {
        return k;
    }

    public void setK(int k) {
        this.k = k;
    }

    @Override
    public void run() {
        while (board.isAvailable()) {

            if (!board.isEmpty()) {
                Token t = board.extractToken(myTurn);
                tokens.add(t);
                if (tokens.size() == k) {
                    tokens.sort(new Token.SortByValue());

                    boolean isProgression = true;
                    int difference = tokens.get(1).getValue() - tokens.get(0).getValue();
                    for (int i = 2; i < tokens.size(); i++)
                        if(!tokens.get(i).isBlank())
                            if ((tokens.get(i).getValue() - tokens.get(i - 1).getValue()) != difference) {
                                isProgression = false;
                                break;
                            }
                    if (isProgression)
                        board.win(tokens, myTurn);
                }

            }

        }
    }

    @Override
    public String toString() {
        return "Player='" +
                name + '\'';
    }
}
