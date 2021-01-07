package lotto;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

class LotteryNumberTest {
    @Test
    void LotteryNumber_유효하지않은수() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new LotteryNumber(LotteryNumber.MIN_LOTTERYNUMBER - 1));
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new LotteryNumber(LotteryNumber.MAX_LOTTERYNUMBER + 1));
    }

    @Test
    void LotteryNumber_유효한수() {
        assertThat(new LotteryNumber(LotteryNumber.MIN_LOTTERYNUMBER))
                .isEqualTo(new LotteryNumber(LotteryNumber.MIN_LOTTERYNUMBER));
        assertThat(new LotteryNumber(LotteryNumber.MAX_LOTTERYNUMBER))
                .isEqualTo(new LotteryNumber(LotteryNumber.MAX_LOTTERYNUMBER));
    }
}