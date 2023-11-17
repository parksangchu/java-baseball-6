package baseball.domain;

import java.util.stream.IntStream;

public class Referee {
    public static GameResult judgeGameResultBy(Numbers computerNumbers, Numbers playerNumbers) {
        int ball = judgeBallBy(computerNumbers, playerNumbers);
        int strike = judgeStrikeBy(computerNumbers, playerNumbers);
        return new GameResult(ball, strike);
    }

    private static int judgeBallBy(Numbers computerNumbers, Numbers playerNumbers) {
        int ball = (int) IntStream.rangeClosed(0, 2)
                .filter(index -> playerNumbers.getNumbers()
                        .contains(computerNumbers.getNumbers()
                                .get(index)))
                .filter(index -> playerNumbers.getNumbers()
                        .get(index)
                        != computerNumbers.getNumbers()
                        .get(index))
                .count();
        return ball;
    }

    private static int judgeStrikeBy(Numbers computerNumbers, Numbers playerNumbers) {
        int strike = (int) IntStream.rangeClosed(0, 2)
                .filter(index -> playerNumbers.getNumbers()
                        .get(index)
                        != computerNumbers.getNumbers()
                        .get(index))
                .count();
        return strike;
    }
}
