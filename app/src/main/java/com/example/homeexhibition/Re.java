package com.example.homeexhibition;

public class Re {
    private String Nick;
    private String Reply;
    private String id;

    public Re(){
    }
    public Re(String id,String Nick, String Reply){
        this.id=id;
        this.Nick=Nick;
        this.Reply=Reply;
    }

    public void setNick(String Nick) {
        this.Nick = Nick;
    }
    public String getNick(){
        return Nick;
    }
    public void setReply(String Reply) {
        this.Reply = Reply;
    }
    public String getReply(){
        return Reply;
    }
    public void setId(String Reply) {
        this.id = id;
    }
    public String getId(){
        return id;
    }

}
