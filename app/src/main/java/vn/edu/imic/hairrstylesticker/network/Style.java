package vn.edu.imic.hairrstylesticker.network;

/**
 * Created by GMO on 4/20/2018.
 */

public class Style {
    private int type;
    private int icon;
    private String style;

    public Style(int type,int icon, String style) {
        this.type = type;
        this.icon = icon;
        this.style = style;
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
}
