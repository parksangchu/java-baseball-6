package baseball.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class RefereeTest {

    @ParameterizedTest
    @DisplayName("숫자를 포함하고 있지만 자리가 맞지 않으면 볼이다.")
    @CsvSource(value = {"345,1", "341,2", "312,3"})
    void countBallBy(String input, int expect) {
        Numbers computerNumbers = new Numbers(List.of(1, 2, 3));
        Numbers playerNumbers = new Numbers(InputConvertor.numbersOf(input));
        GameResult gameResult = Referee.judgeGameResultBy(computerNumbers, playerNumbers);
        assertThat(gameResult.getBall()).isEqualTo(expect);
    }

    @ParameterizedTest
    @DisplayName("숫자와 자리가 일치하면 스트라이크다.")
    @CsvSource(value = {"145,1", "125,2", "123,3"})
    void countStrikeBy(String input, int expect) {
        Numbers computerNumbers = new Numbers(List.of(1, 2, 3));
        Numbers playerNumbers = new Numbers(InputConvertor.numbersOf(input));
        GameResult gameResult = Referee.judgeGameResultBy(computerNumbers, playerNumbers);
        assertThat(gameResult.getStrike()).isEqualTo(expect);
    }
}