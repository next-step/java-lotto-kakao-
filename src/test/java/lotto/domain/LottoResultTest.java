package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoResultTest {

    @Test
    void testTotalPrize() {
        List<LottoRank> lottoRanksList = Arrays.asList(LottoRank.FIRST, LottoRank.SECOND, LottoRank.THIRD, LottoRank.NONE);
        LottoResult lottoResult = new LottoResult(lottoRanksList);
        assertThat(lottoResult.totalPrize()).isEqualTo(2031500000);
    }

}
