package pl.sda.programming.introduction.shop.app;


import pl.sda.programming.introduction.shop.model.Order;

import java.util.Scanner;

final class ApplyDiscountMenuCommand implements MenuCommand<Order> {
    @Override
    public String getText() {
        return "Apply discount";
    }

    @Override
    public void execute(Order order) {
        System.out.println("Please provide coupon code: ");
        Scanner scanner = new Scanner(System.in);
        String code = scanner.next();
        order.applyDiscount(code);
        System.out.println("After applying discount code total value is: " + order.getTotal());
    }
}
