package com.example.myapplication.data.model;

public class Channel {
    private String name;
    private String api_key;
    private String write_api_key;
    private Boolean write_flag;
    private int id;

    public String getWrite_api_key() {
        return write_api_key;
    }

    public void setWrite_api_key(String write_api_key) {
        this.write_api_key = write_api_key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getApi_key() {
        return api_key;
    }

    public void setApi_key(String api_key) {
        this.api_key = api_key;
    }

    public Boolean getWrite_flag() {
        return write_flag;
    }

    public void setWrite_flag(Boolean write_flag) {
        this.write_flag = write_flag;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String toString(){
        return "new channel created"+"\n"+ "api-key:"+api_key+"\n"+"write_api_key"+write_api_key ;
    }
}
