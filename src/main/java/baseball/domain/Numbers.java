package baseball.domain;

import java.util.List;

public class Numbers {
    private static final String ERROR = "[ERROR] ";
    private static final String INVALID_SIZE = ERROR + "입력하신 숫자는 3자리가 아닙니다.";
    private static final String DUPLICATED = ERROR + "중복된 숫자를 입력할 수 없습니다.";
    private final List<Integer> numbers;

    public Numbers(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplicated(numbers);
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

    public boolean match(List<Integer> numbers, int index) {
        return this.numbers.get(index) == numbers.get(index);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
