package baseball.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class EndMenuTest {
    @ParameterizedTest
    @DisplayName("1,2 이외의 값 입력시 예외 발생")
    @ValueSource(strings = {"3", "4", "5", "%", "", " ", "LG우승",})
    void createEndMenu(String input) {
        assertThatThrownBy(() -> new EndMenu(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("입력값이 1이면 재시작 메뉴 선택")
    void isRetry() {
        EndMenu endMenu = new EndMenu("1");
        assertThat(endMenu.isRetry()).isEqualTo(true);
    }
}