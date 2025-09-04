package Core;

import java.util.ArrayList;

public class BowlingGame {

    private ArrayList<Integer> rolls = new ArrayList<>();

    public void roll(int pins) {
        rolls.add(pins);
    }

    public int score() {
        int score = 0;
        int index = 0;
        int frame = 0;

        for (; index < rolls.size() - 2 && frame < 9; index += 2) {
            score += getFrameScore(index);

            if (isSpareOrStrike(index))
                score += rolls.get(index + 2);


            index += strikeFrameAdjustment(index);
            frame++;
        }

        score += scoreLastFrame(index, frame);
        return score;
    }

    private int strikeFrameAdjustment(int index) {
        if (isStrike(index))
            return -1;
        return 0;
    }

    private boolean isStrike(int index) {
        return rolls.get(index) == 10;
    }

    private int scoreLastFrame(int index, int frame) {
        int score = 0;
        for (; index < rolls.size(); index++) {
            if (isStrike(index) && frame < 9 && index < rolls.size() - 1)
                score += rolls.get(index + 1);
            score += rolls.get(index);
        }
        return score;
    }

    private boolean isSpareOrStrike(int index) {
        return getFrameScore(index) >= 10;
    }

    private int getFrameScore(int index) {
        return rolls.get(index) + rolls.get(index + 1);
    }
}