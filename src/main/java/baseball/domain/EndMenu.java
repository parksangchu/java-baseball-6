package baseball.domain;

public class EndMenu {
    private static final String RETRY = "1";
    private static final String COMPLETE_END = "2";
    private static final String INVALID_RANGE = "[ERROR] 1 혹은 2를 입력하셔야 합니다.";

    public static boolean isRetry(String input) {
        validateRange(input);
        return input.equals(RETRY);
    }

    private static void validateRange(String input) {
        if (!isValidRange(input)) {
            throw new IllegalArgumentException(INVALID_RANGE);
        }
    }

    private static boolean isValidRange(String input) {
        return input.equals(RETRY) || input.equals(COMPLETE_END);
    }
}
