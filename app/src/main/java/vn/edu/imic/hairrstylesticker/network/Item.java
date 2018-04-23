package vn.edu.imic.hairrstylesticker.network;

import java.io.Serializable;

/**
 * Created by MyPC on 22/04/2018.
 */

public class Item implements Serializable{
    private int icon;
    private String item;

    public Item(int icon, String item) {
        this.icon = icon;
        this.item = item;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }
}
