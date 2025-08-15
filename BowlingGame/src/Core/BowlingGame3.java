package Core;

import java.util.ArrayList;

public class BowlingGame3 {

    private final ArrayList<Integer> ROLLS = new ArrayList<>();

    public void roll(int pins) {
        ROLLS.add(pins);
    }

    public int score() {
        int score = 0;
        int i = 0;
        int frame = 0;
        for (; i < ROLLS.size() - 2 && frame < 9; i += 2) {
            score += getFrameScore(i);
            if (isStrikeOrSpare(i))
                score += ROLLS.get(i + 2);

            i += (strikeFrameAdjustment(i));
            frame++;
        }

        score += addLastFrame(i, frame);
        return score;
    }

    private int strikeFrameAdjustment(int i) {
        if (isStrike(i))
            return -1;
        return 0;
    }

    private boolean isStrike(int i) {
        return ROLLS.get(i) == 10;
    }

    private int addLastFrame(int i, int frame) {
        int score = 0;
        for (; i < ROLLS.size(); i++) {
            if (isStrike(i) && frame < 9 && i < ROLLS.size() - 1)
                score += ROLLS.get(i + 1);
            score += ROLLS.get(i);
        }
        return score;
    }

    private boolean isStrikeOrSpare(int i) {
        return getFrameScore(i) >= 10;
    }

    private int getFrameScore(int i) {
        return ROLLS.get(i) + ROLLS.get(i + 1);
    }
}