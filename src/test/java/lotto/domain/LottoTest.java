package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoTest {
    Lotto lotto = new Lotto(Arrays.asList(1,2,3,4,5,6));

    @Test
    void testUnableToAdd(){
        lotto.getLotto().clear();
        assertThat(lotto.getLotto().size()).isNotEqualTo(0);
    }
}
