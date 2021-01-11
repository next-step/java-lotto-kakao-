package lotto.domain;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class MatchResults {
    private Map<MatchResult, Integer> resultCounter;

    public MatchResults(List<MatchResult> results) {
        resultCounter = new EnumMap<>(MatchResult.class);
        for (MatchResult result : results) {
            insertResult(result);
        }
    }

    public Map<MatchResult, Integer> getResult() {
        return resultCounter;
    }

    public long getTotalEarnings() {
        long total = 0;

        for (Map.Entry<MatchResult, Integer> entry : resultCounter.entrySet()) {
            total += (long) entry.getKey().getReward() * entry.getValue();
        }

        return total;
    }

    private void insertResult(MatchResult result) {
        int count = resultCounter.getOrDefault(result, 0);
        resultCounter.put(result, count + 1);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MatchResults that = (MatchResults) o;
        return Objects.equals(resultCounter, that.resultCounter);
    }

    @Override
    public int hashCode() {
        return Objects.hash(resultCounter);
    }
}