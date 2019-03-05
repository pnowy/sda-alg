package pl.sda.programming.introduction.shop.app;


import pl.sda.programming.introduction.shop.model.Account;
import pl.sda.programming.introduction.shop.model.Order;
import pl.sda.programming.introduction.shop.utils.ScannerUtils;

final class SelectOrderMenuCommand implements MenuCommand<Account> {
    @Override
    public String getText() {
        return "Select order";
    }

    @Override
    public void execute(Account account) {
        if (account.getOrders().isEmpty()) {
            System.out.println("Order list is empty!");
            return;
        }

        System.out.println("Provide order id:");
        int id = ScannerUtils.nextInt(1, account.getOrders().size());
        Order order = account.getOrders().get(id - 1);
        System.out.println("Selected order: " + order);

        MenuSelector<Order> menuSelector = new MenuSelector<>(order,
                new ListOrderItemsMenuCommand(),
                new ApplyDiscountMenuCommand(),
                new SendOrderMenuCommand(),
                new ExitMenuCommand<>("go back"));
        menuSelector.select();
    }
}
