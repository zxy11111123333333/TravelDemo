package com.zxy.entity;

public class User {
    private int Uno;
    private String Uname;
    private String Upass;

    public User(String uname, String upass) {
        Uname = uname;
        Upass = upass;
    }

    public User() {
        super();
    }

    public User(int uno, String uname, String upass) {
        Uno = uno;
        Uname = uname;
        Upass = upass;
    }

    public int getUno() {
        return Uno;
    }

    public void setUno(int uno) {
        Uno = uno;
    }

    public String getUname() {
        return Uname;
    }

    public void setUname(String uname) {
        Uname = uname;
    }

    public String getUpass() {
        return Upass;
    }

    public void setUpass(String upass) {
        Upass = upass;
    }
}
