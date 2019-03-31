package pl.sda.programming.solid;

public class LiskovExample {
    public static void main(String[] args) {
        Rectangle rectangle = new Square(15);

        printShape(rectangle);
    }

    private static void printShape(Rectangle rectangle) {
        rectangle.setWidth(2 * rectangle.getHeight());
        System.out.println(rectangle.getWidth() + "  /  " + rectangle.getHeight());

    }

}
