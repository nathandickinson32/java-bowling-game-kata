package Test;

import Core.BowlingGame2;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BowlingGame2Test {

    private BowlingGame2 game;

    private void rollMany(int rolls, int pins) {
        for (int i = 0; i < rolls; i++) {
            game.roll(pins);
        }
    }

    @Before
    public void setUp() {
        game = new BowlingGame2();
    }

    @Test
    public void gutterGameTest() {
        rollMany(20, 0);
        assertEquals(0, game.score());

    }

    @Test
    public void testAllOnes() {
        rollMany(20, 1);
        assertEquals(20, game.score());
    }

    @Test
    public void testOneSpare() {
        game.roll(5);
        game.roll(5);
        game.roll(3);
        rollMany(17, 0);
        assertEquals(16, game.score());
    }

    @Test
    public void testOneStrike() {
        game.roll(10);
        game.roll(4);
        game.roll(3);
        rollMany(16, 0);
        assertEquals(24, game.score());
    }

    @Test
    public void testPerfectGame() {
        rollMany(12, 10);
        assertEquals(300, game.score());
    }
}
