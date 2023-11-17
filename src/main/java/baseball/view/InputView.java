package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String ASK_PLAYER_NUMBERS = "숫자를 입력해주세요 : ";
    private static final String ERROR = "[ERROR] ";
    private static final String INVALID_TYPE = ERROR + "숫자 이외의 값은 입력할 수 없습니다.";
    private static final String ASK_RETRY = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";


    public static String ASK_PLAYER_NUMBERS() {
        System.out.print(ASK_PLAYER_NUMBERS);
        String input = Console.readLine();
        validateType(input);
        return input;
    }

    private static void validateType(String input) {
        if (!isValidType(input)) {
            throw new IllegalArgumentException(INVALID_TYPE);
        }
    }

    private static boolean isValidType(String input) {
        return input.trim()
                .chars()
                .allMatch(Character::isDigit);
    }
}
