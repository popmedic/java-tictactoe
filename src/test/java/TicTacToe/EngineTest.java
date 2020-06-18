package TicTacToe;

import org.junit.Test;
import static org.junit.Assert.*;

public class EngineTest {
    @Test public void testTwoTokens() {
        assertTrue("should have 2 tokens", Engine.Token.values().length == 2);
    }
}