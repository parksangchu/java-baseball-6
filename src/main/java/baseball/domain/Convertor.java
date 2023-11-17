package baseball.domain;

import java.util.ArrayList;
import java.util.List;

public class Convertor {
    public static List<Integer> numbersOf(String input) {
        List<Integer> numbers = new ArrayList<>();
        input.chars()
                .map(Character::getNumericValue)
                .forEach(numbers::add);
        return numbers;
    }
}
