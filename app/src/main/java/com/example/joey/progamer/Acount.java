package com.example.joey.progamer;

import android.graphics.drawable.Drawable;

import org.litepal.crud.LitePalSupport;

public class Acount extends LitePalSupport{
    private int id;
    private String userName;
    private String passPort;
    private Drawable headIcon;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassPort() {
        return passPort;
    }

    public void setPassPort(String passPort) {
        this.passPort = passPort;
    }

    public Drawable getHeadIcon() {
        return headIcon;
    }

    public void setHeadIcon(Drawable headIcon) {
        this.headIcon = headIcon;
    }
}
