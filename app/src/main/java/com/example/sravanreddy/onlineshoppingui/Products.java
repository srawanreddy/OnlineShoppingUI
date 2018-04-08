package com.example.sravanreddy.onlineshoppingui;

/**
 * Created by sravanreddy on 4/7/18.
 */

public class Products {
    int image;
    String mainText, subText;

    public Products(int image, String mainText, String subText) {
        this.image = image;
        this.mainText = mainText;
        this.subText = subText;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getMainText() {
        return mainText;
    }

    public void setMainText(String mainText) {
        this.mainText = mainText;
    }

    public String getSubText() {
        return subText;
    }

    public void setSubText(String subText) {
        this.subText = subText;
    }
}
