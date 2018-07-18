package com.example.joey.progamer;

public class Game {
    private String gameName;
    private int imageId;
    private String englishName;
    private String grade;
    private String platform;
    private String gameType;
    private String gameVideo;

    public Game(String gameName,int imageId,String englishName,String grade,String platform,String gameType,String gameVideo){
        this.gameName=gameName;
        this.imageId=imageId;
        this.englishName=englishName;
        this.grade=grade;
        this.platform=platform;
        this.gameType=gameType;
        this.gameVideo=gameVideo;
    }

    public String getGameName() {
        return gameName;
    }

    public int getImageId() {
        return imageId;
    }

    public String getEnglishName() {
        return englishName;
    }

    public String getGrade() {
        return grade;
    }

    public String getPlatform() {
        return platform;
    }

    public String getGameType() {
        return gameType;
    }

    public String getGameVideo() {
        return gameVideo;
    }
}
