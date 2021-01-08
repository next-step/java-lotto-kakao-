package lotto;

import lotto.domain.Number;
import lotto.domain.LottoNumber;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class NumberTest {
    @Test
    void createNumberTest() {
        Number number = new Number(1);
        assertThat(number).isEqualTo(new Number(1));
    }

    @Test
    void exceptionTest() {
        assertThatThrownBy(() -> new Number(0))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("숫자가 잘못되었습니다");
    }

    @Test
    void tempTest(){
        LottoNumber pool = new LottoNumber();
        for(int i=0;i<10;i++){
            List<Number> numbers = pool.getRandomNumbers();
            numbers.forEach(System.out::println);
            System.out.println();
        }
    }
}