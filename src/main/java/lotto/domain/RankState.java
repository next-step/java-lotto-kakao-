package lotto.domain;

import lotto.exception.IllegalRankStateException;

import java.util.Arrays;

public enum RankState {

    FIRST(2000000000, 5,6),
    SECOND(30000000, 4,5),
    THIRD(1500000, 3,5),
    FOURTH(50000, 2,4),
    FIFTH(5000, 1,3),
    FAIL(0, 0,2);

    private final int winMoney;
    private final int rankIndex;
    private final int matchCount;

    RankState(int winMoney, int rankIndex, int matchCount) {
        this.winMoney = winMoney;
        this.rankIndex = rankIndex;
        this.matchCount = matchCount;
    }

    public static RankState rank(int matchCount, boolean bonusMatched) {
        if (matchCount < FIFTH.matchCount) {
            return FAIL;
        }

        if (SECOND.isMatchCount(matchCount)) {
            return chooseSecondOrThird(bonusMatched);
        }

        return Arrays.stream(values())
                .filter(rank -> rank.isMatchCount(matchCount))
                .findFirst()
                .orElseThrow(IllegalRankStateException::new);
    }

    private boolean isMatchCount(int matchCount) {
        return this.matchCount == matchCount;
    }

    private static RankState chooseSecondOrThird(boolean bonusMatched) {
        if (bonusMatched) {
            return SECOND;
        }
        return THIRD;
    }

    public int getWinMoney() {
        return winMoney;
    }

    public int getRankIndex() {
        return rankIndex;
    }
}