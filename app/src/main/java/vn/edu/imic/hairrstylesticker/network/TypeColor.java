package vn.edu.imic.hairrstylesticker.network;

/**
 * Created by GMO on 4/20/2018.
 */

public class TypeColor {
    private int image;
    private String color;

    public TypeColor(int image, String color) {
        this.image = image;
        this.color = color;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
