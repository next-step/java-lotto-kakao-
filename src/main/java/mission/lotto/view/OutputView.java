package mission.lotto.view;

import mission.lotto.domain.Lotto;
import mission.lotto.domain.Lottos;
import mission.lotto.domain.Rank;
import mission.lotto.util.Statistics;

import java.util.List;
import java.util.Map;

public class OutputView {

    public static void autoBoughtView(Lottos lottos) {
        List<Lotto> unPacked = lottos.getLottos();
        System.out.println(unPacked.size() + "개를 구매했습니다.");
        for (Lotto lotto : unPacked) {
            System.out.println(lotto);
        }
    }

    public static void resultView(Map<Rank, Integer> allLottoRank) {
        System.out.println("당첨 통계");
        System.out.println(Statistics.getPreDefinedLottoReport(allLottoRank));
    }

    public static void totalEarningsView(float ratio) {
        String result = "총 수익률은 ";
        result += Math.floor(ratio * 100);
        System.out.println(result + "%입니다.");
    }

}
