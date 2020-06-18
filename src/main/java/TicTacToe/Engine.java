package TicTacToe;

public class Engine {
    public enum Token {
        X, O
    }

    public Token[] board() { return _board.clone(); }

    public Engine() {
        _board = new Token[9];
    }
    
    private Token[] _board;
}