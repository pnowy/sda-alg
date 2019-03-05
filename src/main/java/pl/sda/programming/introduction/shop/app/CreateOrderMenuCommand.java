package pl.sda.programming.introduction.shop.app;


import pl.sda.programming.introduction.shop.model.*;
import pl.sda.programming.introduction.shop.utils.OptionSelector;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

final class CreateOrderMenuCommand implements MenuCommand<Account> {

    private static final OptionSelector<String> DISCOUNT_SELECTOR =
            new OptionSelector<>("Fixed", "Coupon");
    private static final int FIXED_POLICY = 1;
    private static final OptionSelector<String> YES_NO_SELECTOR =
            new OptionSelector<>("Yes", "No");
    private static final int NO_ANSWER = 2;

    @Override
    public String getText() {
        return "Create order";
    }

    @Override
    public void execute(Account account) {
        Scanner scanner = new Scanner(System.in);
        Order order = new Order(account, createDiscountPolicy(scanner));
        account.addOrder(order);

        System.out.println("Please add items to order:");
        boolean finish;
        do {
            scanner.nextLine();
            System.out.println("Item name:");
            String name = scanner.nextLine();
            System.out.println("Item price:");
            BigDecimal price = scanner.nextBigDecimal();
            System.out.println("Item quantity:");
            int quantity = scanner.nextInt();

            order.addItem(new Item(name, price, quantity));

            System.out.println("Add next item?");
            int addNext = YES_NO_SELECTOR.select();
            finish = (addNext == NO_ANSWER);
        } while (!finish);
    }

    private DiscountPolicy createDiscountPolicy(Scanner scanner) {
        System.out.println("Please select discount policy:");
        int option = DISCOUNT_SELECTOR.select();
        if (option == FIXED_POLICY) {
            System.out.println("Please provide fixed discount:");
            float discount = scanner.nextFloat();
            return new FixedDiscountPolicy(discount);
        } else {
            System.out.println("How many coupons generate?");
            int coupons = scanner.nextInt();
            System.out.println("Please provide discount:");
            float discount = scanner.nextFloat();
            return new CouponDiscountPolicy(discount, generateCodes(coupons));
        }
    }

    private List<String> generateCodes(int coupons) {
        List<String> codes = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < coupons; i++) {
            codes.add("ABC-" + random.nextInt(9999999));
        }
        System.out.println("Generated coupons: " + codes);
        return codes;
    }
}
