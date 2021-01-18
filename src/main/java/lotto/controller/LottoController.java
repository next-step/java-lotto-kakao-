package lotto.controller;

import lotto.domain.*;
import lotto.view.LottoInputView;
import lotto.view.LottoOutputView;

import java.util.List;
import java.util.stream.IntStream;

public class LottoController {
    private final LottoOutputView lottoOutputView;
    private final LottoInputView lottoInputView;

    public LottoController() {
        lottoOutputView = new LottoOutputView();
        lottoInputView = new LottoInputView();
    }

    public void startLottoGame() {
        Amount amount = new Amount(lottoInputView.getLottoBuyAmount(), lottoInputView.getManualLottoAmount());
        Lottos lottos = buyManualLotto(amount);
        lottoInputView.printInputQuantityPhrase(amount);
        Lottos autoLottos = buyAutoLotto(amount);
        lottos.appendLottos(autoLottos);
        lottoOutputView.printLottos(lottos);
        WonLotto wonLotto = createWonLotto();
        LottoResult lottoResult = new LottoResult(lottos.lottosResult(wonLotto));
        lottoOutputView.WonResultPhrase();
        lottoOutputView.printSameCountPhrase(lottoResult.toString());
        lottoOutputView.printProfitRatio(amount.profitRatio(lottoResult.totalPrize()));
    }

    public Lottos buyAutoLotto(Amount amount) {
        Lottos lottos = new Lottos();
        for (int i = 0; i < amount.autoCount(); i++) {
            lottos.add(new Lotto());
        }
        return lottos;
    }

    public Lottos buyManualLotto(Amount amount) {
        Lottos lottos = new Lottos();
        lottoInputView.printInputManualLottoNumberPhrase();
        for (int i = 0; i < amount.manualCount(); i++) {
            lottos.add(new Lotto(lottoInputView.getManualLottoNumber()));
        }
        return lottos;
    }

    public WonLotto createWonLotto() {
        Lotto lotto = new Lotto(lottoInputView.getWonLotto());
        LottoNumber bonusBall = LottoNumber.of(lottoInputView.getBonusBall());
        return new WonLotto(lotto, bonusBall);
    }

}
