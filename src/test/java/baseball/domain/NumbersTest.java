package baseball.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NumbersTest {
    @Test
    @DisplayName("중복된 숫자 입력시 예외 발생")
    void createDuplicatedNumbers() {
        assertThatThrownBy(() -> new Numbers(List.of(1, 1, 2)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("사이즈가 3이 아닐 시 예외 발생")
    void createInvalidSize() {
        assertThatThrownBy(() -> new Numbers(List.of(1, 2, 3, 4)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("1-9 이외의 숫자 입력시 예외 발생")
    void createInvalidRange() {
        assertThatThrownBy(() -> new Numbers(List.of(0, 1, 3)))
                .isInstanceOf(IllegalArgumentException.class);
    }
}