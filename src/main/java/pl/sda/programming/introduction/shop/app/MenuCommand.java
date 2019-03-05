package pl.sda.programming.introduction.shop.app;

interface MenuCommand<T> {

    String getText();

    void execute(T context);

    default boolean isExit() {
        return false;
    }
}
