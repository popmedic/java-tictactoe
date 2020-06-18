package TicTacToe;

import org.junit.Test;

import TicTacToe.Engine.Token;

import static org.junit.Assert.*;

import org.junit.Before;

public class EngineTest {
    private Engine engine;

    @Before public void setupEngine() {
        engine = new Engine();
    }

    @Test public void testTwoTokens() {
        assertTrue("should have 2 tokens", Engine.Token.values().length == 2);
    }

    @Test public void test3x3board() {
        assertTrue("should have a 3x3 board", engine.board().length == 3*3);
    }

    @Test public void testBoardEmptyOnStart() {
        for (Token spot : engine.board()) {
            assertTrue("board should be empty on start", spot == null);
        }
    }
}