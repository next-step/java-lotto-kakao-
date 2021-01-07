package domain;

import java.util.Map;

public class LottoSimulator {

    private static final long PERCENTAGE = 100;

    private PurchaseInfo purchaseInfo;
    private Lottos lottos;
    private Answer answer;

    public LottoSimulator(PurchaseInfo purchaseInfo, Lottos lottos, Answer answer) {
        this.purchaseInfo = purchaseInfo;
        this.lottos = lottos;
        this.answer = answer;
    }

    public int getWinningMoney() {
        Map<LottoStatus, Integer> lottoResult = lottos.checkResult(answer);
        return lottoResult.entrySet().stream().map(e -> e.getValue() * e.getKey().getWinnings()).reduce(Integer::sum).get();
    }

    public Map<LottoStatus, Integer> getLottoResults() {
        return lottos.checkResult(answer);
    }

    public long profitPercentage() {
        return (getWinningMoney() - purchaseInfo.getInitialPrice()) * PERCENTAGE / purchaseInfo.getInitialPrice();
    }

}
