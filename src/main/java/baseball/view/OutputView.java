package baseball.view;

import baseball.domain.GameResult;

public class OutputView {
    private static final String BALL = "볼";
    private static final String STRIKE = "스트라이크";
    private static final String NOTHING = "낫싱";
    private static final String ONLY_BALL_OR_ONLY_STRIKE_FORMAT = "%d%s%n";
    private static final String BALL_AND_STRIKE_FORMAT = "%d%s %d%s%n";
    private static final String GAME_END = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";

    public static void printError(Exception e) {
        System.out.println(e.getMessage());
    }

    public static void printGameResult(GameResult gameResult) {
        if (isOnlyBallBy(gameResult)) {
            System.out.printf(ONLY_BALL_OR_ONLY_STRIKE_FORMAT
                    , gameResult.getBall(), BALL);
            return;
        }
        if (isOnlyStrikeBy(gameResult)) {
            System.out.printf(ONLY_BALL_OR_ONLY_STRIKE_FORMAT
                    , gameResult.getStrike(), STRIKE);
            return;
        }
        if (isNothingBy(gameResult)) {
            System.out.println(NOTHING);
            return;
        }
        System.out.printf(BALL_AND_STRIKE_FORMAT
                , gameResult.getBall(), BALL, gameResult.getStrike(), STRIKE);
    }

    private static boolean isOnlyBallBy(GameResult gameResult) {
        return gameResult.getBall() == 0 && gameResult.getStrike() != 0;
    }

    private static boolean isOnlyStrikeBy(GameResult gameResult) {
        return gameResult.getBall() != 0 && gameResult.getStrike() == 0;
    }

    private static boolean isNothingBy(GameResult gameResult) {
        return gameResult.getBall() == 0 && gameResult.getStrike() == 0;
    }

    public static void printGameEnd() {
        System.out.println(GAME_END);
    }
}
