package com.example.block6pathvariableheaders;

public class Greeting {

    public int id;
    private String content;

    Greeting(){}

    Greeting(int id, String content){
        this.id = id;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
