package pl.sda.programming.introduction.shop.app;


import pl.sda.programming.introduction.shop.model.Account;
import pl.sda.programming.introduction.shop.utils.ListUtils;

import java.util.List;

final class ListAccountsMenuCommand implements MenuCommand<List<Account>> {

    @Override
    public String getText() {
        return "List accounts";
    }

    @Override
    public void execute(List<Account> accounts) {
        if (accounts.isEmpty()) {
            System.out.println("No accounts!");
            return;
        }

        String list = ListUtils.toNumeratedList(accounts);
        System.out.println(list);
    }
}
