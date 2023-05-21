package com.zxy.entity;

public class CityFood {
    private int Fno;
    private String Cname;
    private String Fname;
    private String Fin;
    private String Fimg;

    private int uno;
    private String Uname;


    public CityFood() {
        super();
    }

    public CityFood(String cname, String fname, String fin, String fimg) {
        Cname = cname;
        Fname = fname;
        Fin = fin;
        Fimg = fimg;
    }

    public CityFood(int fno, String cname, String fname, String fin, String fimg) {
        Fno = fno;
        Cname = cname;
        Fname = fname;
        Fin = fin;
        Fimg = fimg;
    }

    public int getFno() {
        return Fno;
    }

    public void setFno(int fno) {
        Fno = fno;
    }

    public String getCname() {
        return Cname;
    }

    public void setCname(String cname) {
        Cname = cname;
    }

    public String getFname() {
        return Fname;
    }

    public void setFname(String fname) {
        Fname = fname;
    }

    public String getFin() {
        return Fin;
    }

    public void setFin(String fin) {
        Fin = fin;
    }

    public String getFimg() {
        return Fimg==null? "../img/default.jpg" : Fimg;
    }

    public void setFimg(String fimg) {
        Fimg = fimg;
    }

    public int getUno() {
        return uno;
    }

    public void setUno(int uno) {
        this.uno = uno;
    }

    public String getUname() {
        return Uname;
    }

    public void setUname(String uname) {
        Uname = uname;
    }

    @Override
    public String toString() {
        return "CityFood{" +
                "Fno=" + Fno +
                ", Cname='" + Cname + '\'' +
                ", Fname='" + Fname + '\'' +
                ", Fin='" + Fin + '\'' +
                ", Fimg='" + Fimg + '\'' +
                '}';
    }
}
