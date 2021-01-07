package lotto;

import org.assertj.core.util.Sets;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

public class WinnerNumberTest {

    @Test
    void createWinnerNumberTest() {
        WinnerNumber winnerNumber = new WinnerNumber(Sets.newHashSet(Arrays.asList(
                new Number(1),
                new Number(2),
                new Number(3),
                new Number(4),
                new Number(5),
                new Number(6)))
        , new Number(7));
        assertThat(winnerNumber.toString()).isEqualTo("[1, 2, 3, 4, 5, 6] bonusNumber : 7");
    }

    @ParameterizedTest
    @CsvSource({"1,6,3,5,4,2,FIRST", "3,2,1,7,5,4,SECOND", "3,40,30,2,7,5,FIFTH"})
    void matchWinnerNumberTest(int i1,
                               int i2,
                               int i3,
                               int i4,
                               int i5,
                               int i6,
                               LottoRank rank) {
        WinnerNumber winnerNumber = new WinnerNumber(Sets.newHashSet(Arrays.asList(
                new Number(1),
                new Number(2),
                new Number(3),
                new Number(4),
                new Number(5),
                new Number(6)))
                , new Number(7));
        LottoTicket lottoTicket = new LottoTicket(
                Sets.newHashSet(Arrays.asList(
                        new Number(i1),
                        new Number(i2),
                        new Number(i3),
                        new Number(i4),
                        new Number(i5),
                        new Number(i6)))
        );
        assertThat(winnerNumber.getRank(lottoTicket)).isEqualTo(rank);
    }
}
