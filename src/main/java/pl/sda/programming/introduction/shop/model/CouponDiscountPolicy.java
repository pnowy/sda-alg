package pl.sda.programming.introduction.shop.model;

import java.util.List;

public final class CouponDiscountPolicy implements DiscountPolicy {

    private final float discount;
    private final List<String> codes;

    public CouponDiscountPolicy(float discount, List<String> codes) {
        this.discount = discount;
        this.codes = codes;
    }

    @Override
    public float getDiscount(String code) {
        return codes.contains(code) ? discount : 0;
    }
}

