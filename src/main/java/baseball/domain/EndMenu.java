package baseball.domain;

public class EndMenu {
    private static final int RETRY = 1;
    private static final int COMPLETE_END = 2;
    private static final String INVALID_RANGE = "[ERROR] 1 혹은 2를 입력하셔야 합니다.";
    private final int endMenu;

    public EndMenu(String endMenu) {
        validateRange(endMenu);
        this.endMenu = Integer.parseInt(endMenu);
    }

    public boolean isRetry() {
        return endMenu == RETRY;
    }

    private void validateRange(String input) {
        if (!isValidRange(input)) {
            throw new IllegalArgumentException(INVALID_RANGE);
        }
    }

    private boolean isValidRange(String input) {
        return input.equals(RETRY) || input.equals(COMPLETE_END);
    }
}
