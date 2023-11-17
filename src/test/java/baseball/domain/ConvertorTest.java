package baseball.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ConvertorTest {

    @Test
    @DisplayName("세 자리 숫자를 크기 3의 숫자 리스트로 전환")
    void numbersOf() {
        Numbers numbers = Convertor.numbersOf("123");
        assertThat(numbers.getNumbers()).isEqualTo(List.of(1, 2, 3));
    }
}