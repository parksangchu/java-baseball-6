package baseball.domain;

public class GameResult {
    private static final int GAME_END_COUNT = 3;
    private final int ball;
    private final int strike;

    public GameResult(int ball, int strike) {
        this.ball = ball;
        this.strike = strike;
    }

    public boolean isEnd() {
        return strike == GAME_END_COUNT;
    }

    public int getBall() {
        return ball;
    }

    public int getStrike() {
        return strike;
    }
}
