package baseball.controller;

import baseball.domain.Computer;
import baseball.domain.EndMenu;
import baseball.domain.GameResult;
import baseball.domain.InputConvertor;
import baseball.domain.Numbers;
import baseball.domain.Referee;
import baseball.view.InputView;
import baseball.view.OutputView;
import java.util.List;

public class GameController implements Runnable {
    @Override
    public void run() {
        EndMenu endMenu;
        do {
            Numbers computerNumbers = createComputerNumbers();
            repeatComparison(computerNumbers);
            endMenu = createEndMenu();
        } while (endMenu.isRetry());
    }

    private Numbers createComputerNumbers() {
        List<Integer> computerNumbers = Computer.generateNumbers();
        return new Numbers(computerNumbers);
    }

    private void repeatComparison(Numbers computerNumbers) {
        while (true) {
            Numbers playerNumbers = createPlayerNumbers();
            GameResult gameResult = createGameResult(computerNumbers, playerNumbers);
            OutputView.printGameResult(gameResult);
            if (gameResult.isThreeStrike()) {
                OutputView.printGameEnd();
                break;
            }
        }
    }

    private Numbers createPlayerNumbers() {
        String numbersInput = InputView.ASK_PLAYER_NUMBERS();
        List<Integer> playerNumbers = InputConvertor.numbersOf(numbersInput);
        return new Numbers(playerNumbers);
    }

    private GameResult createGameResult(Numbers computerNumbers, Numbers playerNumbers) {
        return Referee.judgeGameResultBy(computerNumbers, playerNumbers);
    }

    private EndMenu createEndMenu() {
        String input = InputView.ASK_RETRY();
        return new EndMenu(input);
    }
}
