package view;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoProgramViewTest {

    private LottoProgramView lottoProgramView;

    @BeforeEach
    void setUp() {
        lottoProgramView = new LottoProgramView();
    }

    @Test
    void checkValidBuyAmount() {
        assertThat(lottoProgramView.checkNumberFormat("10000")).isTrue();
        assertThat(lottoProgramView.checkNumberFormat("123asd")).isFalse();
    }

}