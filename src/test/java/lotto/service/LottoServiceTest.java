package lotto.service;

import lotto.domain.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.AssertionsForClassTypes.*;

public class LottoServiceTest {

    @Test
    @DisplayName("로또 티켓 구입 테스트")
    void buyingLottoNosCountTest() {
        LottoDto lottoDto = new LottoDto();
        LottoService lottoService = new LottoService(lottoDto);

        lottoDto.setPurchaseList(new PurchaseList(1000));
        lottoService.buyLottoTickets();
        List<LottoTicket> lottoTickets1 = lottoDto.getLottoTickets();
        lottoDto.setPurchaseList(new PurchaseList(10000));
        lottoService.buyLottoTickets();
        List<LottoTicket> lottoTickets10 = lottoDto.getLottoTickets();
        lottoDto.setPurchaseList(new PurchaseList(100000));
        lottoService.buyLottoTickets();
        List<LottoTicket> lottoTickets100 = lottoDto.getLottoTickets();

        assertThat(lottoTickets1.size()).isEqualTo(1);
        assertThat(lottoTickets10.size()).isEqualTo(10);
        assertThat(lottoTickets100.size()).isEqualTo(100);
    }

    @ParameterizedTest
    @CsvSource(
            "'1,2,3,4,5,6'," + "'7'," +
            "'2,3,4,9,10,11|" + //THREE
            "1,2,3,9,10,11|" +  //THREE
            "1,2,3,4,10,11|" +  //FOUR
            "1,2,3,4,5,8|" +    //FIVE
            "1,2,3,4,5,7|" +    //FIVE_WITH_BONUS
            "1,2,3,4,5,6'"      //SIX
    )
    @DisplayName("당첨 로또 정상 생성 확인 테스트")
    void winningStatisticsTest(String winningLottoNumbers, int bonusNumber, String tickets) {
        WinningLottoNos winningLottoNos = new WinningLottoNos(CsvParsing.convertStringToIntegerSet(winningLottoNumbers), bonusNumber);
        List<LottoTicket> lottoTickets = new ArrayList<>();
        List<Set<Integer>> ticketsNumbers = CsvParsing.convertStringToTicketsNumber(tickets);
        LottoDto lottoDto = new LottoDto();
        LottoService lottoService = new LottoService(lottoDto);

        for( Set<Integer> ticket : ticketsNumbers ) {
            lottoTickets.add(new LottoTicket(ticket));
        }

        lottoDto.setLottoTickets(lottoTickets);
        lottoDto.setWinningLottoNos(winningLottoNos);
        lottoService.winningStatistics();

        StatisticsResult statisticsResult = new StatisticsResult();
        statisticsResult.increaseTypeCount(StatisticsType.THREE);
        statisticsResult.increaseTypeCount(StatisticsType.THREE);
        statisticsResult.increaseTypeCount(StatisticsType.FOUR);
        statisticsResult.increaseTypeCount(StatisticsType.FIVE);
        statisticsResult.increaseTypeCount(StatisticsType.FIVE_WITH_BONUS);
        statisticsResult.increaseTypeCount(StatisticsType.SIX);

        assertThat(lottoDto.getStatisticsResult())
                .isEqualTo(statisticsResult);
    }

}