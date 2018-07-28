package com.example.joey.progamer;

import android.graphics.drawable.Drawable;

import org.litepal.crud.LitePalSupport;

import java.util.List;

public class Acount extends LitePalSupport{
    private int id;
    private String userName;
    private String passPort;
    private int headIconId;
    private boolean isMale;
    private String bornDate;
    private String area;
    private String school;
    private List<Integer> gameColectedId;

    public List<Integer> getGameColectedId() {
        return gameColectedId;
    }

    public void setGameColectedId(List<Integer> gameColectedId) {
        this.gameColectedId = gameColectedId;
    }

    public boolean isMale() {
        return isMale;
    }

    public void setMale(boolean male) {
        isMale = male;
    }

    public String getBornDate() {
        return bornDate;
    }

    public void setBornDate(String bornDate) {
        this.bornDate = bornDate;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

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

    public int getHeadIconId() {
        return headIconId;
    }

    public void setHeadIconId(int headIconId) {
        this.headIconId = headIconId;
    }
}
