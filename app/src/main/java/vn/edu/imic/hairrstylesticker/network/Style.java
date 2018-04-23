package vn.edu.imic.hairrstylesticker.network;

import java.io.Serializable;
import java.util.List;

/**
 * Created by GMO on 4/20/2018.
 */

public class Style implements Serializable{
    private int type;
    private int icon;
    private String style;
    private List<Item> items;

    public Style(int type,int icon, String style, List<Item> items) {
        this.type = type;
        this.icon = icon;
        this.style = style;
        this.items = items;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}
