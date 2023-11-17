package baseball.domain;

public class Referee {
    public static final int NUMBERS_SIZE = 3;

    public static GameResult judgeGameResultBy(Numbers computerNumbers, Numbers playerNumbers) {
        int ball = judgeBallBy(computerNumbers, playerNumbers);
        int strike = judgeStrikeBy(computerNumbers, playerNumbers);
        return new GameResult(ball, strike);
    }

    private static int judgeBallBy(Numbers computerNumbers, Numbers playerNumbers) {
        int ball = 0;
        for (int i = 0; i < NUMBERS_SIZE; i++) {
            if (isBall(computerNumbers, playerNumbers, i)) {
                ball++;
            }
        }
        return ball;
    }

    private static boolean isBall(Numbers computerNumbers, Numbers playerNumbers, int i) {
        return !computerNumbers.match(playerNumbers.getNumbers(), i)
                && computerNumbers.getNumbers().contains(playerNumbers.getNumbers().get(i));
    }

    private static int judgeStrikeBy(Numbers computerNumbers, Numbers playerNumbers) {
        int strike = 0;
        for (int i = 0; i < NUMBERS_SIZE; i++) {
            if (computerNumbers.match(playerNumbers.getNumbers(), i)) {
                strike++;
            }
        }
        return strike;
    }
}
