package Test;

import Core.BowlingGame3;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BowlingGame3Test {

    BowlingGame3 game = new BowlingGame3();

    @Test
    public void testNewGame() {
        assertEquals(0, game.score());
    }

    @Test
    public void testGutterGame() {
        rollMany(20, 0);
        assertEquals(0, game.score());
    }

    @Test
    public void testOnePin() {
        game.roll(1);
        assertEquals(1, game.score());
    }

    @Test
    public void testTwoPins() {
        game.roll(2);
        assertEquals(2, game.score());
    }

    @Test
    public void testOneFrame() {
        game.roll(5);
        game.roll(4);
        assertEquals(9, game.score());
    }

    @Test
    public void testSpare() {
        game.roll(5);
        game.roll(5);
        game.roll(4);
        assertEquals(18, game.score());
    }

    @Test
    public void testStrike() {
        game.roll(10);
        game.roll(5);
        game.roll(4);
        assertEquals(28, game.score());
    }

    @Test
    public void testPerfectGame() {
        rollMany(12, 10);
        assertEquals(300, game.score());
    }

    @Test
    public void testAlmostPerfectGame() {
        rollMany(9, 10);
        assertEquals(240, game.score());
    }

    private void rollMany(int rolls, int pins) {
        for (int i = 0; i < rolls; i++)
            game.roll(pins);
    }
}