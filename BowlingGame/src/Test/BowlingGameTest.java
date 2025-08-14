package Test;

import Core.BowlingGame;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class BowlingGameTest {
    BowlingGame game = new BowlingGame();

    @Test
    public void testEmptyGame() {
        game.rolls = new ArrayList<Integer>();
        assertEquals(0, game.score());
    }

    @Test
    public void testOnePin() {
        game.rolls = new ArrayList<Integer>();
        game.rolls.add(1);
        assertEquals(1, game.score());
    }

    @Test
    public void testTwoPins() {
        game.rolls = new ArrayList<Integer>();
        game.rolls.add(2);
        assertEquals(2, game.score());
    }

    @Test
    public void testOneFrame() {
        game.rolls = new ArrayList<Integer>();
        game.rolls.add(2);
        game.rolls.add(2);
        assertEquals(4, game.score());
    }
}
