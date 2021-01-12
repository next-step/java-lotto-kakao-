package lotto.view;

import java.util.Scanner;

public class LottoInputView {
    private static Scanner scanner = new Scanner(System.in);

    public static int getLottoBuyAmount(){
        LottoOutputView.printInputMoneyPhrase();
        int amount = Integer.parseInt(scanner.nextLine());
        return amount;
    }

    public static String getWonLotto(){
        LottoOutputView.printInputWonlottoPhrase();
        String wonLotto = scanner.nextLine();
        return wonLotto;
    }

    public static int getBonusBall(){
        LottoOutputView.printInputBonusBallPhrase();
        int bonusBall = Integer.parseInt(scanner.nextLine());
        return bonusBall;
    }

    public static int getNonAutoLottoBuyAmount(){
        LottoOutputView.printInputNonAutoLottoQuantityPhrase();
        int amount = Integer.parseInt(scanner.nextLine());
        return amount;
    }

    public static String getNonAutoLotto(){
        LottoOutputView.printInputNonAutoLottoPhrase();
        String lotto = scanner.nextLine();
        return lotto;
    }
}
