package pl.sda.programming.introduction.shop.app;


import pl.sda.programming.introduction.shop.model.Account;
import pl.sda.programming.introduction.shop.utils.ListUtils;

final class ListOrdersMenuCommand implements MenuCommand<Account> {
    @Override
    public String getText() {
        return "List orders";
    }

    @Override
    public void execute(Account account) {
        if (account.getOrders().isEmpty()) {
            System.out.println("Orders list is empty");
            return;
        }

        String list = ListUtils.toNumeratedList(account.getOrders());
        System.out.println(list);
    }
}
