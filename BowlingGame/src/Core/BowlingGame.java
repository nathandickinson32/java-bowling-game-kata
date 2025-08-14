package Core;

import java.util.ArrayList;

public class BowlingGame {

    public ArrayList<Integer> rolls;

    public int score() {
        int score = 0;
        for (Integer roll : rolls) {
            score += roll;
        }
        return score;
    }
}