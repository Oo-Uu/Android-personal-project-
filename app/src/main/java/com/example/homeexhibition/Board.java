package com.example.homeexhibition;

import androidx.annotation.NonNull;

import java.util.Date;

public class Board {
    private String id;
    private String title;
    private String contents;
    private String nick;
    private Date date;
    private String time;


    public Board(){
    }
    public Board(String id, String title, String contents,String nick,String time){
        this.id=id;
        this.title=title;
        this.contents=contents;
        this.nick=nick;
        this.time=time;

    }

    public void setId(String id) {
        this.id = id;
    }
    public String getId(){
        return id;
    }
    public void setContents(String contents) {
        this.contents = contents;
    }
    public String getContents(){
        return contents;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getTitle(){
        return title;
    }

    public String getNick(){
        return nick;
    }
    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getTime(){
        return time;
    }
    public void setTime(String time) {
        this.time = time;
    }

    public void setDate(){
        this.date=date;
    }
    public Date getDate(){
        return date;
    }



    @NonNull
    @Override
    public String toString() {
        return "Board{" +
                "id-'" + id +'\'' +
                ", title-'" + title+ '\''+

                '}';
    }
}
