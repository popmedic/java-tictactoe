package TicTacToe;

import org.junit.Test;

import TicTacToe.Engine.Token;

import static org.junit.Assert.*;

public class EngineTest {
    @Test public void testTwoTokens() {
        assertTrue("should have 2 tokens", Engine.Token.values().length == 2);
    }

    @Test public void test3x3board() {
        Engine engine = new Engine();
        assertTrue("should have a 3x3 board", engine.board().length == 3*3);
    }

    @Test public void testBoardEmptyOnStart() {
        Engine engine = new Engine();
        for (Token spot : engine.board()) {
            assertTrue("board should be empty on start", spot == null);
        }
    }
}