package pl.sda.programming.introduction.shop.model;

import java.io.Serializable;

//@FunctionalInterface
public interface DiscountPolicy extends Serializable {

    // public static final is redundant, you don't need to use them in interface
    public static final float DEFAULT_VALUE = 0;

    //abstract void m1();

    //abstract void m2();

    /**
     * this method should result in numbers from
     * 0.0 to 1.0
     *
     * @param code
     * @return discount percent
     */
    default float getDiscount(String code) {
        return DEFAULT_VALUE;
    }
}