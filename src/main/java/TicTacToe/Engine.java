package TicTacToe;

public class Engine {
    public enum Token {
        X, O
    }

    public enum Status {
        SUCCESS, SAME_SPOT
    }

    public Token[] board() { return _board.clone(); }
    public Token turn() { return _turn; }

    public Status play(int spot) {
        if (_board[spot] != null) { return Status.SAME_SPOT; }
        _board[spot] = turn();
        _turn = toggle(_turn);
        return Status.SUCCESS;
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