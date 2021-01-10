package lotto.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class LotteryUtilTest {
    @ParameterizedTest
    @CsvSource({"0, 0", "999, 0", "1000, 1", "1001,1", "1999, 1", "2000 , 2"})
    void LotteryUtil_구입가능_로또개수계산(int money, int count) {
        int LotteryCount = LotteryUtil.calculateLotteryCount(money);
        assertThat(LotteryCount).isEqualTo(count);
    }

    @Test
    void calculateProfitRate() {
        assertThat(LotteryUtil.calculateProfitRate(1, 1000)).isEqualTo(0);
        assertThat(LotteryUtil.calculateProfitRate(1, 0)).isEqualTo(-100);
        assertThat(LotteryUtil.calculateProfitRate(1, 2000)).isEqualTo(100);
        assertThat(LotteryUtil.calculateProfitRate(1, 55000)).isEqualTo(5400);
    }

    @Test
    void LotteryUtil_구입불가능_로또개수계산() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> LotteryUtil.calculateLotteryCount(-1));
    }
}