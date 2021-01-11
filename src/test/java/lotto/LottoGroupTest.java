package lotto;

import lotto.domain.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoGroupTest {
    @Test
    @DisplayName("Lotto 생성 테스트")
    void createTest() {
        List<Lotto> lottos = Arrays.asList(
                new Lotto("1, 2, 3, 4, 5, 6"),
                new Lotto("1, 2, 3, 4, 5, 7"));

        LottoGroup lottoGroup = new LottoGroup(lottos);
        assertThat(lottoGroup).isEqualTo(new LottoGroup(lottos));
    }

    @Test
    @DisplayName("Lotto 당첨 결과 테스트")
    void groupCheckTest() {
        List<Lotto> lottos = Arrays.asList(
                new Lotto("1, 2, 3, 4, 5, 6"),
                new Lotto("1, 2, 3, 4, 5, 7"));
        LottoGroup lottoGroup = new LottoGroup(lottos);

        Lotto winningLotto = new Lotto("1, 2, 3, 4, 5, 6");
        Ball bonusBall = Ball.of("7");
        WinningNumberSet winningNumberSet = new WinningNumberSet(winningLotto, bonusBall);

        LottoResult lottoResult = lottoGroup.getLottoResult(winningNumberSet);
        assertThat(lottoResult.getRankCount(Rank.FIRST)).isEqualTo(1);
        assertThat(lottoResult.getRankCount(Rank.SECOND)).isEqualTo(1);
    }

    @Test
    @DisplayName("구입 개수만큼 Lotto를 생성하는지 테스트")
    void createRandomLottoGroupTest() {
        assertThat(LottoGroup.createRandomLottoGroup(10).getLottoCount()).isEqualTo(10);
    }
}
