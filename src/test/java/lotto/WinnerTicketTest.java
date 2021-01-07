package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class WinnerTicketTest {
    @DisplayName("당첨 로또 번호와 보너스 넘버가 주어지면 당첨 티켓 생성한다.")
    @Test
    void create() {
        //given
        LottoNumbers lottoNumbers = LottoNumbers.from(new OneToSixGenerator());
        LottoNumber bonusNumber = new LottoNumber(7);

        //when
        WinnerTicket winnerTicket = new WinnerTicket(lottoNumbers, bonusNumber);

        //then
        List<LottoNumber> expected = Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3),
                new LottoNumber(4), new LottoNumber(5), new LottoNumber(6));
        assertThat(winnerTicket.getWinnerNumbers().getLottoNumbers()).isEqualTo(expected);
        assertThat(winnerTicket.getBonusNumber()).isEqualTo(new LottoNumber(7));
    }

    private static Stream<Arguments> generateLottoNumberStrategy() {
        return Stream.of(
                Arguments.of((NumberGenerateStrategy) () -> Arrays.asList(1, 2, 3, 4, 5, 6), 6),
                Arguments.of((NumberGenerateStrategy) () -> Arrays.asList(1, 2, 7, 4, 5, 6), 5),
                Arguments.of((NumberGenerateStrategy) () -> Arrays.asList(1, 2, 7, 8, 5, 6), 4),
                Arguments.of((NumberGenerateStrategy) () -> Arrays.asList(1, 4, 3, 8, 9, 10), 3),
                Arguments.of((NumberGenerateStrategy) () -> Arrays.asList(10, 45, 44, 43, 2, 3), 2),
                Arguments.of((NumberGenerateStrategy) () -> Arrays.asList(31, 42, 13, 24, 15, 5), 1),
                Arguments.of((NumberGenerateStrategy) () -> Arrays.asList(11, 22, 33, 44, 35, 36), 0)
        );
    }

    @DisplayName("당첨 티켓과 로또 티켓이 주어지면, 보너스 여부를 확인한.")
    @ParameterizedTest
    @MethodSource("generateLottoNumberStrategy2")
    void hasBonus(NumberGenerateStrategy strategy, int bonusNumber, boolean expected) {
        //given
        WinnerTicket winnerTicket = new WinnerTicket(LottoNumbers.from(new OneToSixGenerator()),
                new LottoNumber(bonusNumber));
        LottoNumbers lottoNumbers = LottoNumbers.from(strategy);

        //when
        boolean hasBonusNumber = winnerTicket.hasBonus(lottoNumbers);

        //then
        assertThat(hasBonusNumber).isEqualTo(expected);
    }

    private static Stream<Arguments> generateLottoNumberStrategy2() {
        return Stream.of(
                Arguments.of((NumberGenerateStrategy) () -> Arrays.asList(1, 2, 3, 4, 5, 6), 4, true),
                Arguments.of((NumberGenerateStrategy) () -> Arrays.asList(1, 2, 7, 4, 5, 6), 10, false)
        );
    }

}
