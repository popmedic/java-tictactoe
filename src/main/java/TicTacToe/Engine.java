package TicTacToe;

public class Engine {
    public enum Token {
        X, O
    }

    public Token[] board() { return _board.clone(); }
    public Token turn() { return _turn; }

    public Engine() {
        _board = new Token[9];
        _turn = Token.X;
    }
    
    private Token[] _board;
    private Token _turn;
}