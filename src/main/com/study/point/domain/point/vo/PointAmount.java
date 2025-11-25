package com.study.point.domain.point.vo;


import java.util.Objects;

/**
 * 

 * Value Object - 포인트의 도메인 개념을 명시적으로 표현
 * Immutability - 금융 데이터의 안정성 보장, 멀티스레드 안전성
 * Self-validation - 유효하지 않은 상태의 객체 존재 불가
 * Value Semantics - 참조가 아닌 값으로 동등성 판단
 * 비즈니스 로직 - 캡슐화규칙의 일관성 보장, 실수 방지
 */

public class PointAmount {

    public static final long MIN_AMOUNT = 1;
    public static final long MAX_AMOUNT = 100_000;

    private final long value;

    public PointAmount(long value) {
        validate(value);
        this.value = value;
    }

    private static void validate(long value) {
        if (value < MIN_AMOUNT || value > MAX_AMOUNT) {
            throw new IllegalArgumentException(
                String.format("포인트는 %d 이상 %d 이하여야 합니다", MIN_AMOUNT, MAX_AMOUNT)
            );
        }
    }

    public long getValue() {
        return value;
    }

    public PointAmount add(PointAmount other) {
        return new PointAmount(this.value + other.value);
    }

    public PointAmount subtract(PointAmount other) {
        long result = this.value - other.value;
        if (result < 0) {
            throw new IllegalArgumentException("포인트가 부족합니다");
        }
        return new PointAmount(result);
    }

    public boolean isGreaterThanOrEqual(PointAmount other) {
        return this.value >= other.value;
    }

    public boolean isGreaterThan(PointAmount other) {
        return this.value > other.value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PointAmount)) return false;
        PointAmount that = (PointAmount) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

}
