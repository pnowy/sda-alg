package pl.sda.programming.introduction;

import pl.sda.programming.introduction.shop.model.DiscountPolicy;
import pl.sda.programming.introduction.shop.model.NoDiscountPolicy;

import java.io.Serializable;

final class _27_InterfacesSummary {
    /*
        Interfaces:
        - only method declaration
        - default methods
        - static fields
        - concrete class can implement many interfaces
        - no instance fields
     */

    // default method implementation usage
    DiscountPolicy policy = new NoDiscountPolicy();
}

class ExampleInterface implements DiscountPolicy, Runnable, Serializable {
    @Override
    public void run() {
        System.out.println("example for implementing many interfaces");
    }
}