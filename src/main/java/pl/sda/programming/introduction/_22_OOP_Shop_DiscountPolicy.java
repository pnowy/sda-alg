package pl.sda.programming.introduction;


import pl.sda.programming.introduction.shop.model.CouponDiscountPolicy;
import pl.sda.programming.introduction.shop.model.DiscountPolicy;
import pl.sda.programming.introduction.shop.model.FixedDiscountPolicy;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

final class _22_OOP_Shop_DiscountPolicy {

    public static void main(String[] args) {

        List<DiscountPolicy> policies = new ArrayList<>();

        // fixed discount policy
        DiscountPolicy fixedDiscountPolicy = new FixedDiscountPolicy(0.2f);
        policies.add(fixedDiscountPolicy);

        // coupon discount policy
        List<String> codes = new ArrayList<>();
        codes.add("ABC123");
        codes.add("ABC122");
        codes.add("ABC121");
        DiscountPolicy couponDiscountPolicy = new CouponDiscountPolicy(0.5f, codes);
        policies.add(couponDiscountPolicy);

        // apply discount
        float amount = 1000;

        Random random = new Random();
        DiscountPolicy policy;
        if (random.nextInt() % 2 == 0) {
            policy = policies.get(0);
        } else {
            policy = policies.get(1);
        }
        float discount = policy.getDiscount("ABC123");
        System.out.println("Amount with discount is " + (amount - (amount * discount)));
    }

}
