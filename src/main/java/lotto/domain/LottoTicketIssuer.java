package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public final class LottoTicketIssuer {
    private LottoTicketIssuer() {
        throw new IllegalStateException("Issuer cannot be instantiated");
    }

    public static LottoTickets issue(NumberPickStrategy strategy, int count) {
        List<LottoNumbers> numbers = new ArrayList<>();

        for (int ignored = 0; ignored < count; ignored++) {
            numbers.add(new LottoNumbers(strategy.generateLottoNumbers()));
        }

        return new LottoTickets(numbers);
    }
}
