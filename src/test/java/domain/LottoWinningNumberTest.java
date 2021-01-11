package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import domain.exceptions.InvalidLottoNumberException;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

public class LottoWinningNumberTest {

  @Test
  void create() {
    LottoTicket lottoWinningTicket = new LottoTicket(Arrays.asList(1, 2, 3, 4, 5, 6));
    LottoNumber bonusNumber = new LottoNumber(7);
    LottoWinningNumber lottoWinningNumber = new LottoWinningNumber(lottoWinningTicket, bonusNumber);
    assertThat(lottoWinningNumber)
        .isEqualTo(new LottoWinningNumber(lottoWinningTicket, bonusNumber));
  }

  @Test
  void isDuplicate() {
    LottoTicket lottoWinningTicket = new LottoTicket(Arrays.asList(1, 2, 3, 4, 5, 6));
    LottoNumber bonusNumber = new LottoNumber(6);
    assertThatExceptionOfType(InvalidLottoNumberException.class)
        .isThrownBy(() -> new LottoWinningNumber(lottoWinningTicket, bonusNumber));
  }

}