package baseball.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ComputerTest {

    @Test
    @DisplayName("컴퓨터는 사이즈 3의 숫자 리스트를 생성한다.")
    void generateNumbers() {
        List<Integer> computerNumbers = Computer.generateNumbers();
        assertThat(computerNumbers.size()).isEqualTo(3);
    }
}