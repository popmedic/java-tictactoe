package TicTacToe;

import org.junit.Test;
import static org.junit.Assert.*;

public class EngineTest {
    @Test public void testTwoTokens() {
        assertTrue("should have 2 tokens", Engine.Token.values().length == 2);
    }

    @Test public void test3x3board() {
        Engine engine = Engine();
        assertTrue("should have a 3x3 board", Engine.board().length == 3*3);
    }
}