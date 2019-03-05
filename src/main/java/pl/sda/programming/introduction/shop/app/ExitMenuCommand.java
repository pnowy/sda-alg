package pl.sda.programming.introduction.shop.app;

final class ExitMenuCommand<T> implements MenuCommand<T> {

    private final String label;

    ExitMenuCommand(String label) {
        this.label = label;
    }

    @Override
    public String getText() {
        return label;
    }

    @Override
    public void execute(T context) {
    }

    @Override
    public boolean isExit() {
        return true;
    }
}
