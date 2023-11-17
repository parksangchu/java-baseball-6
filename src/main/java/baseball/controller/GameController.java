package baseball.controller;

import baseball.domain.Computer;
import baseball.domain.Convertor;
import baseball.domain.EndMenu;
import baseball.domain.GameResult;
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
            if (gameResult.isEnd()) {
                OutputView.printGameEnd();
                break;
            }
        }
    }

    private Numbers createPlayerNumbers() {
        while (true) {
            try {
                String numbersInput = InputView.ASK_PLAYER_NUMBERS();
                List<Integer> playerNumbers = Convertor.numbersOf(numbersInput);
                return new Numbers(playerNumbers);
            } catch (IllegalArgumentException e) {
                OutputView.printError(e);
            }
        }
    }

    private GameResult createGameResult(Numbers computerNumbers, Numbers playerNumbers) {
        return Referee.judgeGameResultBy(computerNumbers, playerNumbers);
    }

    private EndMenu createEndMenu() {
        while (true) {
            try {
                String input = InputView.ASK_RETRY();
                return new EndMenu(input);
            } catch (IllegalArgumentException e) {
                OutputView.printError(e);
            }
        }
    }
}
