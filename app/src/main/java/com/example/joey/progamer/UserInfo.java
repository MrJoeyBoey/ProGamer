package com.example.joey.progamer;

import android.graphics.drawable.Drawable;

import java.io.Serializable;

public class UserInfo implements Serializable {
    private Drawable iconImage;
    private String userName;
    private String eMail;

    public Drawable getIconImage() {
        return iconImage;
    }
    public void setIconImage(Drawable iconImage) {
        this.iconImage = iconImage;
    }

    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String geteMail() {
        return eMail;
    }
    public void seteMail(String eMail) {
        this.eMail = eMail;
    }
}
