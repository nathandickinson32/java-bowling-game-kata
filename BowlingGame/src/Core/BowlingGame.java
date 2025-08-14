package Core;

import java.util.ArrayList;

public class BowlingGame {

    public ArrayList<Integer> rolls;

    public int score() {
        int score = 0;
        int i = 0;
        int frame = 0;
        for (; i < rolls.size() - 2 && frame < 9; i += 2) {
            score += getFrameScore(rolls, i);

            if (isStrikeOrSpare(rolls, i))
                score += rolls.get(i + 2);

            i += strikeFrameAdjustment(rolls, i);
            frame++;
        }

        score += finalFrameScore(rolls, i, frame);
        return score;
    }

    private int strikeFrameAdjustment(ArrayList<Integer> rolls, int i) {
        if (isStrike(rolls, i))
            return -1;
        return 0;
    }

    private boolean isStrike(ArrayList<Integer> rolls, int i) {
        return rolls.get(i) == 10;
    }

    private int finalFrameScore(ArrayList<Integer> rolls, int i, int frame) {
        int score = 0;
        for (; i < rolls.size(); i++) {
            if (isStrike(rolls, i) && frame < 9 && i < rolls.size() - 1)
                score += rolls.get(i + 1);
            score += rolls.get(i);
        }
        return score;
    }

    private boolean isStrikeOrSpare(ArrayList<Integer> rolls, int i) {
        return getFrameScore(rolls, i) >= 10;
    }

    private int getFrameScore(ArrayList<Integer> rolls, int i) {
        return rolls.get(i) + rolls.get(i + 1);
    }
}