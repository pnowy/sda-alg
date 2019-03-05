package pl.sda.programming.introduction.shop.app;


import pl.sda.programming.introduction.shop.model.Account;
import pl.sda.programming.introduction.shop.utils.ScannerUtils;

import java.util.List;

final class SelectAccountMenuCommand implements MenuCommand<List<Account>> {

    @Override
    public String getText() {
        return "Select account";
    }

    @Override
    public void execute(List<Account> accounts) {
        if (accounts.isEmpty()) {
            System.out.println("Accounts is empty! Please create one.");
            return;
        }

        System.out.println("Please provide account id:");
        int id = ScannerUtils.nextInt(1, accounts.size());
        Account account = accounts.get(id - 1);
        MenuSelector<Account> selector = new MenuSelector(account,
                new CreateOrderMenuCommand(),
                new ListOrdersMenuCommand(),
                new SelectOrderMenuCommand(),
                new CreateAddressMenuCommand(),
                new ListAddressesMenuCommand(),
                new ExitMenuCommand<>("Go back")
                );
        selector.select();
    }
}
