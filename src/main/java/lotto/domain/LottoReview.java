package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoReview {

    private Lottos lottos;
    private WonLotto wonLotto;
    private List<LottoRank> rankResult = new ArrayList<>();

    public LottoReview(Lottos lottos, WonLotto wonLotto){
        this.lottos = lottos;
        this.wonLotto = wonLotto;

        for (Lotto lotto : lottos.getLottos()) {
            rankResult.add(wonLotto.checkRanking(lotto));
        }
    }

    public long getProfit(){

        long totalPrize=0;
        for (LottoRank rank : rankResult) {
            totalPrize+=rank.getMoney();
        }
        return totalPrize;
    }

    public int getProfitRatio() {

        return calculateRatio(getProfit(),rankResult.size()*1000);
    }

    private int calculateRatio(long totalPrize, long totalCost){
        return (int)Math.round((double)(totalPrize)/(double)(totalCost)*100);
    }

    public List<Integer> getSameCountList() {
        List<LottoRank> results=new ArrayList<>();
        int[] rankingResult = new int[6];
        Arrays.fill(rankingResult, 0);

        for (LottoRank rank : rankResult) {
            rankingResult[rank.getIndex()]++;
        }

        return Arrays.stream(rankingResult).boxed().collect(Collectors.toList());
    }
}