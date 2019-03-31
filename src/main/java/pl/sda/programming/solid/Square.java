package pl.sda.programming.solid;

public class Square extends Rectangle {

    public Square(int size) {
        setWidth(size);
        setHeight(size);
    }

    public void setWidth(int width) {
        this.width = width;
        this.height = width;
    }

    public void setHeight(int height) {
        this.height = height;
        this.width = height;
    }

}
