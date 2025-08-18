package Core;

import java.util.ArrayList;

public class BowlingGame5 {

//    private ArrayList<Integer> rolls = new ArrayList<>();
//
//    public void roll(int pins) {
//        rolls.add(pins);
//    }

    private ArrayList<Integer> rolls = new ArrayList<>();


    public void roll(int pins) {
        rolls.add(pins);
    }

    public int score() {
        int score = 0;
        int i = 0;
        int frame = 0;

        for (; i < rolls.size() - 2 && frame < 9; i += 2) {
            score += scoreFrame(i);

            if (isStrikeOrSpare(i))
                score += rolls.get(i + 2);

            i += strikeFrameAdjustment(i);
            frame++;
        }

        score += scoreLastFrames(i, frame);
        return score;
    }

    private int strikeFrameAdjustment(int i) {
        if (isStrike(i))
            return -1;
        return 0;
    }

    private boolean isStrike(int i) {
        return rolls.get(i) == 10;
    }

    private int scoreLastFrames(int i, int frame) {
        int score = 0;
        for (; i < rolls.size(); i++) {
            if (isStrike(i) && frame < 9 && i < rolls.size() - 1)
                score += rolls.get(i + 1);
            score += rolls.get(i);
        }
        return score;
    }

    private boolean isStrikeOrSpare(int i) {
        return scoreFrame(i) >= 10;
    }

    private int scoreFrame(int i) {
        return rolls.get(i) + rolls.get(i + 1);
    }


//
//    public int score() {
//        int score = 0;
//        int i = 0;
//        int frame = 0;
//
//        for (; i < rolls.size() - 2 && frame < 9; i += 2) {
//            score += scoreFrame(i);
//
//            if (isStrikeOrSpare(i))
//                score += rolls.get(i + 2);
//
//            i += strikeFrameAdjustment(i);
//            frame++;
//        }
//
//        score += scoreRemainingRolls(i, frame);
//        return score;
//    }
//
//    private int strikeFrameAdjustment(int i) {
//        if (isStrike(i))
//            return -1;
//        return 0;
//    }
//
//    private boolean isStrike(int i) {
//        return rolls.get(i) == 10;
//    }
//
//    private int scoreRemainingRolls(int i, int frame) {
//        int score = 0;
//        for (; i < rolls.size(); i++) {
//            if (isStrike(i) && frame < 9 && i < rolls.size() - 1)
//                score += rolls.get(i + 1);
//            score += rolls.get(i);
//        }
//        return score;
//    }
//
//    private boolean isStrikeOrSpare(int i) {
//        return scoreFrame(i) >= 10;
//    }
//
//    private int scoreFrame(int i) {
//        return rolls.get(i) + rolls.get(i + 1);
//    }
}
