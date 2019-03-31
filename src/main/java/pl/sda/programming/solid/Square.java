package pl.sda.programming.solid;

public class Square extends Rectangle {

    public Square(int size) {
        setWidth(size);
        setHeight(size);
    }

    public Rectangle setWidth(int width) {
        this.width = width;
        this.height = width;
        return this;
    }

    public Rectangle setHeight(int height) {
        this.height = height;
        this.width = height;
        return this;
    }

}
