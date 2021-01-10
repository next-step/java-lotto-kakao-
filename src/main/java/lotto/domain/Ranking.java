package lotto.domain;

import java.util.Arrays;
import java.util.Map;

public enum Ranking {
    FIFTH(3, false, 5000),
    FOURTH(4, false, 50000),
    THIRD(5, false, 1500000),
    SECOND(5, true, 30000000),
    FIRST(6, false, 2000000000);

    private final int matchCount;
    private final boolean matchBonus;
    private final int prize;

    Ranking(int matchCount, boolean matchBonus, int prize){
        this.matchCount = matchCount;
        this.matchBonus = matchBonus;
        this.prize = prize;
    }

    public static Ranking getRank(int matchCountount, boolean matchBonus){
        return Arrays.stream(values())
                .filter(ranking -> (ranking.matchCount == matchCountount) && ranking.matchBonus == matchBonus)
                .findFirst()
                .orElse(null);
    }
    
    public static long getReward(Map<Ranking, Integer> statistics){
        long reward = 0;
        for (Ranking ranking : statistics.keySet()) {
            reward += ranking.prize * statistics.get(ranking);
        }
        return reward;
    }

}
