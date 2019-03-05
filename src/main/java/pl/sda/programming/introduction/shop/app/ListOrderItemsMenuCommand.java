package pl.sda.programming.introduction.shop.app;


import pl.sda.programming.introduction.shop.model.Order;
import pl.sda.programming.introduction.shop.utils.ListUtils;

final class ListOrderItemsMenuCommand implements MenuCommand<Order> {
    @Override
    public String getText() {
        return "List order items";
    }

    @Override
    public void execute(Order order) {
        String list = ListUtils.toNumeratedList(order.getItems());
        System.out.println(list);
    }
}
