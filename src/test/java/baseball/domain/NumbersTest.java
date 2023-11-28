package baseball.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

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

    @ParameterizedTest
    @DisplayName("같은 숫자가 같은 인덱스에 있으면 true")
    @CsvSource(value = {"0,true", "1,false", "2,true"})
    void match(int input, boolean expect) {
        Numbers numbers1 = new Numbers(List.of(1, 2, 3));
        Numbers numbers2 = new Numbers(List.of(1, 4, 3));
        assertThat(numbers1.isSameIndex(numbers2, input))
                .isEqualTo(expect);
    }
}