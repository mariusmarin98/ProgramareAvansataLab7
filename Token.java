package lab7;

import java.util.Comparator;

public class Token{
    private int value;
    private boolean blank;

    public Token() {
    }

    public Token(int value, boolean isBlank) {
        this.value = value;
        this.blank = isBlank;
    }

    public boolean isBlank() {
        return blank;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int token) {
        this.value = token;
    }

    @Override
    public String toString() {
        if (isBlank())
            return "Token=blank";
        else
            return "Token=" + value;
    }

    static class SortByValue implements Comparator<Token>
    {
        public int compare(Token a, Token b)
        {
            return a.value - b.value;
        }
    }
}
