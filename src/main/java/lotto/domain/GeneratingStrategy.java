package lotto.domain;

import java.util.Set;

public interface GeneratingStrategy {
    Set<Integer> generate();
    int getLimit();
}
