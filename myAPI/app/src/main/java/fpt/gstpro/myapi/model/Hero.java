package fpt.gstpro.myapi.model;

import com.google.gson.annotations.SerializedName;

public class Hero {
    private String name;
    @SerializedName("realname")
    private String realName;
    private String team;
    @SerializedName("firstappearance")
    private int firstAppearance;
    @SerializedName("createdby")
    private String createdBy;
    private String publisher;
    @SerializedName("imageurl")
    private String imageUrl;
    private String bio;

    public Hero(){}

    public Hero(String name, String realName, String team, int firstAppearance, String createdBy, String publisher, String imageUrl, String bio) {
        this.name = name;
        this.realName = realName;
        this.team = team;
        this.firstAppearance = firstAppearance;
        this.createdBy = createdBy;
        this.publisher = publisher;
        this.imageUrl = imageUrl;
        this.bio = bio;
    }

    public String getName() {
        return name;
    }

    public String getRealName() {
        return realName;
    }

    public String getTeam() {
        return team;
    }

    public int getFirstAppearance() {
        return firstAppearance;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getBio() {
        return bio;
    }
}
