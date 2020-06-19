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
        assertTrue("should have 2 tokens", 
                   Engine.Token.values().length == 2);
    }

    @Test public void test3x3board() {
        assertTrue("should have a 3x3 board", 
                   engine.board().length == 3*3);
    }

    @Test public void testBoardEmptyOnStart() {
        for (Token spot : engine.board()) {
            assertTrue("board should be empty on start", 
                       spot == null);
        }
    }

    @Test public void testFirstTokenX() {
        assertTrue("first turn is X", 
                   engine.turn() == Token.X);
    }

    @Test public void testPlayXThenY() {
        assertTrue("Validate play 1 is success", 
                   engine.play(1) == Engine.Status.SUCCESS);
        assertTrue("next turn is O", 
                   engine.turn() == Token.O);
        assertTrue("Validate play 2 is success", 
                   engine.play(2) == Engine.Status.SUCCESS);
        assertTrue("next turn is X", 
                   engine.turn() == Token.X);
    }

    @Test public void testPlayNotEmptySpot() {
        assertTrue("Validate play 1 is success", 
                   engine.play(1) == Engine.Status.SUCCESS);
        assertTrue("Validate that when play on same spot get result SAME_SPOT", 
                   engine.play(1) == Engine.Status.SAME_SPOT);
        assertTrue("turn should still be 0", 
                   engine.turn() == Token.O);
    }

    @Test public void testWinRow1() {
        int[] x = {0,1,2}, o = {3,4};
        validateWin(x, o);
    }

    @Test public void testWinRow2() {
        int[] x = {3,4,5}, o = {1,2};
        validateWin(x, o);
    }

    @Test public void testWinRow3() {
        int[] x = {6,7,8}, o = {1,2};
        validateWin(x, o);
    }

    @Test public void testWinCol1() {
        int[] x = {0,3,6}, o = {1,4};
        validateWin(x, o);
    }

    @Test public void testWinCol2() {
        int[] x = {1,4,7}, o = {0,3};
        validateWin(x, o);
    }

    @Test public void testWinCol3() {
        int[] x = {2,5,8}, o = {1,4};
        validateWin(x, o);
    }

    @Test public void testWinDia1() {
        int[] x = {0,4,8}, o = {1,3};
        validateWin(x, o);
    }

    @Test public void testWinDia2() {
        int[] x = {2,4,6}, o = {1,3};
        validateWin(x, o);
    }

    @Test public void testCatGame() {
        assertTrue(engine.play(8) == Engine.Status.SUCCESS);
        assertTrue(engine.play(0) == Engine.Status.SUCCESS);
        assertTrue(engine.play(1) == Engine.Status.SUCCESS);
        assertTrue(engine.play(2) == Engine.Status.SUCCESS);
        assertTrue(engine.play(3) == Engine.Status.SUCCESS);
        assertTrue(engine.play(5) == Engine.Status.SUCCESS);
        assertTrue(engine.play(4) == Engine.Status.SUCCESS);
        assertTrue(engine.play(7) == Engine.Status.SUCCESS);
        assertTrue(engine.play(6) == Engine.Status.CAT_GAME);
    }

    @Test public void testOutOfBounds() {
        assert(engine.play(-1) == Engine.Status.OOB);
        assert(engine.play(9) == Engine.Status.OOB);
    }

    private void validateWin(int[] xPlays, int[] oPlays) {
        for (int i = 0; i < oPlays.length; i++) {
            assertTrue(engine.play(xPlays[i]) == Engine.Status.SUCCESS);
            assertTrue(engine.play(oPlays[i]) == Engine.Status.SUCCESS);
        }
        assertTrue(engine.play(xPlays[xPlays.length - 1]) == Engine.Status.WIN);
        assertTrue(engine.turn() == Engine.Token.X);
    }
}