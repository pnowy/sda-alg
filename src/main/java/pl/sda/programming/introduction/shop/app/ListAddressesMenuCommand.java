package pl.sda.programming.introduction.shop.app;


import pl.sda.programming.introduction.shop.model.Account;
import pl.sda.programming.introduction.shop.utils.ListUtils;

final class ListAddressesMenuCommand implements MenuCommand<Account
        > {
    @Override
    public String getText() {
        return "List addresses";
    }

    @Override
    public void execute(Account account) {
        String list = ListUtils.toNumeratedList(account
                .getCustomer()
                .getAddresses());
        System.out.println(list);
    }
}
