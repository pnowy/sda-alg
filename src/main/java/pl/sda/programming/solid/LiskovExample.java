package pl.sda.programming.solid;

public class LiskovExample {

    private final static String PATTERN_XYZ = "";
    public static final int DEFAULT_RECTANGLE_SIZE = 15;

    public static void main(String[] args) {
        Rectangle rectangle = new Square(15);

        final Rectangle fluentRectangle = new Rectangle()
                .setWidth(DEFAULT_RECTANGLE_SIZE)
                .setHeight(15);

        printShape(rectangle);
    }

    private static void printShape(Rectangle rectangle) {
        rectangle.setWidth(2 * rectangle.getHeight());
        System.out.println(rectangle.getWidth() + "  /  " + rectangle.getHeight());
    }

}
