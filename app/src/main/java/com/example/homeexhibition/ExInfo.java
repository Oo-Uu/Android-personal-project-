package com.example.homeexhibition;

public class ExInfo {
    private String profile;
    private String painter;
    private String exhibitionname;

    public ExInfo(){

    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public void setPainter(String painter) {
        this.painter = painter;
    }

    public void setExhibitionname(String exhibitionname) {
        this.exhibitionname = exhibitionname;
    }

    public String getProfile() {
        return profile;
    }

    public String getPainter() {
        return painter;
    }

    public String getExhibitionname() {
        return exhibitionname;
    }
}
