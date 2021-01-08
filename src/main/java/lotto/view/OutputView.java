package lotto.view;

import lotto.domain.*;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class OutputView {
    public void printNumberOfLottoTickets(int ticketCount) {
        System.out.printf("%d개를 구매했습니다.\n", ticketCount);
    }

    public void printLottoTickets(LottoTickets lottoTickets) {
        StringBuilder message = new StringBuilder();

        lottoTickets.getTickets()
                .forEach(lottoTicket -> {
                    String numbers = lottoTicket.toStream()
                            .map(LottoNumber::getNumber)
                            .map(num -> Integer.toString(num))
                            .collect(Collectors.joining(", "));

                    message.append(String.format("[%s]\n", numbers));
                });

        System.out.println(message);
    }

    public void printStatistics(LottoStatistics statistics) {
        StringBuilder message = new StringBuilder();
        StatisticsResult statisticsResult = statistics.getStatisticsResult();

        message.append("당첨 통계\n")
                .append("---------\n");

        Stream.of(MatchResult.values())
                .filter(result -> result != MatchResult.NULL)
                .map(result -> {
                    int count = statisticsResult.getResultCountOfSomeMatch(result);
                    return String.format("%s (%d원) - %d개%n", result.getInfo(), result.getReward(), count);
                })
                .forEach(message::append);

        message.append(String.format("총 수익률은 %d%%입니다.", statisticsResult.getEarningRate()));

        System.out.println(message);
    }
}
