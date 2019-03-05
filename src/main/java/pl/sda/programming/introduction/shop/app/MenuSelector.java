package pl.sda.programming.introduction.shop.app;


import pl.sda.programming.introduction.shop.utils.OptionSelector;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

final class MenuSelector<T> {

    private final T context;
    private final List<MenuCommand<T>> commands;
    private final OptionSelector<String> selector;

    MenuSelector(T context, List<MenuCommand<T>> commands) {
        this.context = context;
        this.commands = commands;

        List<String> options = new ArrayList<>();
        for (MenuCommand<T> command : commands) {
            options.add(command.getText());
        }
        this.selector = new OptionSelector<>(options);
    }

    @SafeVarargs
    MenuSelector(T context, MenuCommand<T> ...commands) {
        this(context, Arrays.asList(commands));
    }

    void select() {
        while (true) {
            int menu = selector.select();
            MenuCommand<T> command = commands.get(menu - 1);
            command.execute(context);
            if (command.isExit()) {
                return;
            }
        }
    }
}
