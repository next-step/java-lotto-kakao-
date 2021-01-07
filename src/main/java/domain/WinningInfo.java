package domain;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class WinningInfo {

    private final List<Long> PRIZE = Arrays.asList(5000l, 50000l, 1500000l, 30000000l, 2000000000l);

    private final List<Integer> info;

    public WinningInfo(List<Integer> winningInfo) {
        this.info = winningInfo;
    }

    public List<Integer> getInfo() {
        return info;
    }

    public long getSumPrize() {
        long sum = 0;
        for (int i = 0; i < info.size(); i++) {
            sum += info.get(i) * PRIZE.get(i);
        }

        return sum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WinningInfo that = (WinningInfo) o;
        return Objects.equals(info, that.info);
    }

    @Override
    public int hashCode() {
        return Objects.hash(info);
    }
}