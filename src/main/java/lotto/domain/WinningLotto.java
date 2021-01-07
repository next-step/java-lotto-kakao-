package lotto.domain;

import lotto.utils.Result;

import java.util.Objects;

public class WinningLotto {
    private final Digit bonusBall;
    private final Lotto winningLotto;

    public WinningLotto(Lotto winningLotto) {
        this(winningLotto, new Digit(37));
    }

    public WinningLotto(Lotto winningLotto, Digit bonusBall) {
        this.bonusBall = bonusBall;
        this.winningLotto = winningLotto;
    }

    public Result compare(Lotto lotto) {
        return LottoResults.mapResult(winningLotto.matchCount(lotto), lotto.contains(bonusBall));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WinningLotto that = (WinningLotto) o;
        return Objects.equals(winningLotto, that.winningLotto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(winningLotto);
    }
}