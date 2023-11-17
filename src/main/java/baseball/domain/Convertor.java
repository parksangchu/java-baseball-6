package baseball.domain;

import java.util.ArrayList;
import java.util.List;

public class Convertor {
    public static Numbers numbersOf(String input) {
        List<Integer> numbers = new ArrayList<>();
        input.chars()
                .map(Character::getNumericValue)
                .forEach(numbers::add);
        return new Numbers(numbers);
    }
}
