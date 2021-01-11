package lotto.view;

import lotto.domain.LottoStatistics;
import lotto.domain.LottoTickets;
import lotto.domain.MatchResult;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class OutputView {
    public void printNumberOfLottoTickets(long ticketCount, int change) {
        System.out.printf("수동으로 %d장, 자동으로 %d장을 구매했습니다.\n", ticketCount, change);
    }

    public void printChangeIfExists(int change) {
        if (hasChange(change)) {
            System.out.printf("잔돈 %d원은 반환되었습니다.\n", change);
        }
    }

    public void printLottoTickets(LottoTickets tickets) {
        StringBuilder message = new StringBuilder();

        for (List<Integer> ticket : tickets.getAllTicketNumbers()) {
            String numbersFormatted = ticket.stream()
                    .map(num -> Integer.toString(num))
                    .collect(Collectors.joining(", "));

            message.append(String.format("[%s]\n", numbersFormatted));
        }

        System.out.println(message.toString());
    }

    public void printStatistics(LottoStatistics statistics) {
        StringBuilder message = new StringBuilder();
        Map<MatchResult, Integer> matchResults = statistics.getResults();

        message.append("당첨 통계\n")
                .append("---------\n");

        Stream.of(MatchResult.values())
                .map(result -> String.format("%s (%d원) - %d개%n",
                        result.getInfo(), result.getReward(), matchResults.getOrDefault(result, 0)))
                .forEach(message::append);

        message.append(String.format("총 수익률은 %d%%입니다.", statistics.getEarningRate().getRate()));

        System.out.println(message.toString());
    }

    private boolean hasChange(long change) {
        return change > 0;
    }
}
