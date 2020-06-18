package TicTacToe;

public class Engine {
    public enum Token {
        X, O
    }

    public enum Status {
        SUCCESS, SAME_SPOT, WIN
    }

    public Token[] board() { return _board.clone(); }
    public Token turn() { return _turn; }

    public Status play(int spot) {
        if (isSpotEmpty(spot)) { return Status.SAME_SPOT; }
        _board[spot] = turn();

        for (Integer[] row : WIN_TABLE) {
            if (_board[row[0]] != null && 
                _board[row[0]] == _board[row[1]] && 
                _board[row[1]] == _board[row[2]]) {
                
                return Status.WIN;
            }
        }

        _turn = toggle(_turn);

        return Status.SUCCESS;
    }

    public Engine() {
        _board = new Token[9];
        _turn = Token.X;
    }
    
    private Token[] _board;
    private Token _turn;
    private Token toggle(Token token) { return _turn == Token.X ? Token.O : Token.X; }
    private boolean isSpotEmpty(int spot) { return _board[spot] != null; }
    private final Integer[][] WIN_TABLE = {
        {0,1,2}, 
        {3,4,5}, 
        {6,7,8},
        {0,3,6},
        {1,4,7},
        {2,5,8},
        {0,4,8},
        {2,4,6}
    };
}