package lotto.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber> {
    private static final int LOTTO_MIN_INT = 1;
    private static final int LOTTO_MAX_INT = 45;
    private final int number;
    private static final Map<Integer, LottoNumber> lottoNumbers = new HashMap<>();

    static {
        for (int i = LOTTO_MIN_INT; i <= LOTTO_MAX_INT; i++) {
            lottoNumbers.put(i, new LottoNumber(i));
        }
    }

    public static LottoNumber of(int number) {
        if (number > LOTTO_MAX_INT || number < LOTTO_MIN_INT) {
            throw new IllegalArgumentException("1~45범위를 벗어난 숫자입니다.");
        }
        return lottoNumbers.get(number);
    }

    public LottoNumber(int number) {
        this.number = number;
    }

    @Override
    public int compareTo(LottoNumber o) {
        return number - o.number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber that = (LottoNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }

}
