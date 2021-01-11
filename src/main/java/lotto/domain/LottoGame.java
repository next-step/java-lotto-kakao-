package lotto.domain;

import lotto.dto.LottoStatisticDTO;
import java.util.List;
import java.util.Objects;

public class LottoGame {

    private final Money money;
    private final UserBuyNumbers userBuyNumbers;

    public LottoGame(Money money) {
        this.money = money;
        this.userBuyNumbers = new UserBuyNumbers();
    }

    public List<List<String>> buyLotto(GenerateStrategy generateStrategy) {
        for (int i = 0; i < money.possibleNumberBuy(); i++) {
            userBuyNumbers.addBuyNumbers(NumberGenerator.generateBuyNumbers(generateStrategy));
        }
        return userBuyNumbers.convertToString();
    }

    public LottoStatisticDTO checkLotto(WinningNumbers winningNumbers) {
        LottoStatisticDTO responseLottoStatistic = new LottoStatisticDTO();

        StatisticCalculator statCalculator = new StatisticCalculator(
                userBuyNumbers.checkLottoResult(winningNumbers), money);
        responseLottoStatistic.setRankCount(statCalculator.getRankCount());
        responseLottoStatistic.setProfitRate(statCalculator.getProfitRate());

        return responseLottoStatistic;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoGame lottoGame = (LottoGame) o;
        return Objects.equals(money, lottoGame.money) && Objects.equals(userBuyNumbers, lottoGame.userBuyNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(money, userBuyNumbers);
    }
}