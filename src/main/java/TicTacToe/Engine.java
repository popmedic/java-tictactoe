package TicTacToe;

public class Engine {
    public enum Token {
        X, O
    }

    public Token[] board() { return _board.clone(); }
    public Token turn() { return _turn; }

    public void play(int spot) {
        _board[spot] = turn();
        _turn = toggle(_turn);
    }

    public Engine() {
        _board = new Token[9];
        _turn = Token.X;
    }
    
    private Token[] _board;
    private Token _turn;

    private Token toggle(Token token) {
        return _turn == Token.X ? Token.O : Token.X;
    }
}