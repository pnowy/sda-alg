package pl.sda.programming.introduction.shop.model;

public final class FixedDiscountPolicy implements DiscountPolicy {

    private final float discount;

    public FixedDiscountPolicy(float discount) {
        this.discount = discount;
    }

    @Override
    public float getDiscount(String code) {
        return discount;
    }
}
