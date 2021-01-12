package lotto.domain;

import java.util.Objects;

public class LottoMoney {
    public static final int LOTTO_PRICE = 1000;
    private int money = 0;

    private LottoMoney() {
    }

    public LottoMoney(int money) {
        if (money < LOTTO_PRICE)
            throw new IllegalArgumentException("최소 금액은 " + LOTTO_PRICE + "원 입니다.");
        this.money = money;
    }

    public int getLottoTicketCount(){
        return money / LOTTO_PRICE;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoMoney that = (LottoMoney) o;
        return money == that.money;
    }

    @Override
    public int hashCode() {
        return Objects.hash(money);
    }
}