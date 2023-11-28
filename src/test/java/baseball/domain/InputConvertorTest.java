package baseball.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputConvertorTest {

    @Test
    @DisplayName("세 자리 숫자를 크기 3의 숫자 리스트로 전환")
    void numbersOf() {
        List<Integer> numbers = InputConvertor.numbersOf("123");
        assertThat(numbers).isEqualTo(List.of(1, 2, 3));
    }
}