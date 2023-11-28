package baseball.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GameResultTest {

    @Test
    @DisplayName("스트라이크가 3개이면 게임이 종료된다")
    void isGameEnd() {
        GameResult gameResult = new GameResult(0, 3);
        assertThat(gameResult.isGameEnd()).isTrue();
    }
}