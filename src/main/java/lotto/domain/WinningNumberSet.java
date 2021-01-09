package lotto.domain;

import java.util.List;
import java.util.Objects;

public class WinningNumberSet {
    private final Lotto winningLotto;
    private final LottoNumber bonusLottoNumber;

    public WinningNumberSet(Lotto winningLotto, LottoNumber bonusLottoNumber) {
        this.winningLotto = winningLotto;
        this.bonusLottoNumber = bonusLottoNumber;
        if (bonusLottoNumber.isDuplicated(winningLotto)) {
            throw new IllegalArgumentException("보너스볼에는 당첨 번호가 포함되어서는 안된다.");
        }
    }

    public Rank compare(List<LottoNumber> lottoNumbers) {
        int matchedCount = winningLotto.compareWithLottoNumbers(lottoNumbers);
        boolean hasBonus = lottoNumbers.contains(bonusLottoNumber);
        return Rank.createRank(matchedCount, hasBonus);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WinningNumberSet that = (WinningNumberSet) o;
        return Objects.equals(winningLotto, that.winningLotto) && Objects.equals(bonusLottoNumber, that.bonusLottoNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(winningLotto, bonusLottoNumber);
    }
}