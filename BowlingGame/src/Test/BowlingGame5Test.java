package Test;

import Core.BowlingGame5;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BowlingGame5Test {

//    private BowlingGame5 game = new BowlingGame5();
//
//    private void rollMany(int rolls, int pins) {
//        for (int i = 0; i < rolls; i++) {
//            game.roll(pins);
//        }
//    }


//
//    @Test
//    public void testGutterGame() {
//        rollMany(20, 0);
//        assertEquals(0, game.score());
//    }
//

    private void rollMany(int rolls, int pins) {
        for (int i = 0; i < rolls; i++) {
            game.roll(pins);
        }
    }

    private BowlingGame5 game = new BowlingGame5();

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
    public void testAllOnes() {
        rollMany(20, 1);
        assertEquals(20, game.score());
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

//    @Test
//    public void testOnePin() {
//        game.roll(1);
//        assertEquals(1, game.score());
//    }
//
//    @Test
//    public void testAllOnes() {
//        rollMany(20, 1);
//        assertEquals(20, game.score());
//    }
//
//    @Test
//    public void testSpare() {
//        game.roll(5);
//        game.roll(5);
//        game.roll(4);
//        assertEquals(18, game.score());
//    }
//
//    @Test
//    public void testStrike() {
//        game.roll(10);
//        game.roll(5);
//        game.roll(4);
//        assertEquals(28, game.score());
//    }
//
//    @Test
//    public void testPerfectGame() {
//        rollMany(12, 10);
//        assertEquals(300, game.score());
//    }
//
//    @Test
//    public void testAlmostPerfectGame() {
//        rollMany(10, 10);
//        assertEquals(270, game.score());
//    }
}
