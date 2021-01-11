package lotto.domain;


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.stream.IntStream;

public class Number implements Comparable<Number> {
    public static final int MIN_LOTTO_NUMBER = 1;
    public static final int MAX_LOTTO_NUMBER = 45;

    private static final List<Number> numberPool;

    private final int number;

    static {
        numberPool = new ArrayList<>();
        IntStream.rangeClosed(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER).forEach(number -> numberPool.add(new Number(number)));
    }

    private Number(int number) {
        this.number = number;
    }

    public static Number of(int number) {
        Collections.sort(numberPool);
        if(numberPool.get(number - 1) == null) {
            throw new IllegalArgumentException("숫자가 잘못되었습니다 : " + number);
        }
        return numberPool.get(number - 1);
    }

    public static List<Number> randomNumbers(int count) {
        Collections.shuffle(numberPool);
        return numberPool.subList(0, count);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Number number1 = (Number) o;
        return number == number1.number;
    }

    @Override
    public int hashCode() {
        return number;
    }

    @Override
    public String toString() {
        return "" + number;
    }

    @Override
    public int compareTo(Number o) {
        return this.number - o.number;
    }
}