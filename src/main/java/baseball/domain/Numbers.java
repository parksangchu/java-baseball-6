package baseball.domain;

import java.util.List;

public class Numbers {
    private static final String ERROR = "[ERROR] ";
    private static final String INVALID_SIZE = ERROR + "입력하신 숫자는 3자리가 아닙니다.";
    private static final String DUPLICATED = ERROR + "중복된 숫자를 입력할 수 없습니다.";
    private static final String INVALID_RANGE = ERROR + "1~9 이외의 숫자는 입력할 수 없습니다.";
    private static final int MAX_NUMBER = 9;
    private static final int MIN_NUMBER = 1;
    private final List<Integer> numbers;

    public Numbers(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplicated(numbers);
        validateRange(numbers);
        this.numbers = numbers;
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != 3) {
            throw new IllegalArgumentException(INVALID_SIZE);
        }
    }

    private void validateDuplicated(List<Integer> numbers) {
        if (isDuplicated(numbers)) {
            throw new IllegalArgumentException(DUPLICATED);
        }
    }

    private boolean isDuplicated(List<Integer> numbers) {
        int sizeAfterCut = (int) numbers.stream()
                .distinct()
                .count();
        return sizeAfterCut != numbers.size();
    }

    private void validateRange(List<Integer> numbers) {
        if (isInvalidRange(numbers)) {
            throw new IllegalArgumentException(INVALID_RANGE);
        }
    }

    private boolean isInvalidRange(List<Integer> numbers) {
        return numbers.stream()
                .anyMatch(number -> number > MAX_NUMBER || number < MIN_NUMBER);
    }

    public boolean isSameIndex(Numbers numbers, int index) {
        return this.numbers.get(index)
                .equals(numbers.getNumbers().get(index));
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
