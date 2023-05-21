package com.zxy.entity;

public class CityHotel {
    private int Hno;
    private String Cname;
    private String Hname;
    private String Hin;
    private String Himg;

    public CityHotel() {
        super();
    }

    public CityHotel(int hno, String cname, String hname, String hin, String himg) {
        Hno = hno;
        Cname = cname;
        Hname = hname;
        Hin = hin;
        Himg = himg;
    }

    public CityHotel(String cname, String hname, String hin, String himg) {
        Cname = cname;
        Hname = hname;
        Hin = hin;
        Himg = himg;
    }

    public int getHno() {
        return Hno;
    }

    public void setHno(int hno) {
        Hno = hno;
    }

    public String getCname() {
        return Cname;
    }

    public void setCname(String cname) {
        Cname = cname;
    }

    public String getHname() {
        return Hname;
    }

    public void setHname(String hname) {
        Hname = hname;
    }

    public String getHin() {
        return Hin;
    }

    public void setHin(String hin) {
        Hin = hin;
    }

    public String getHimg() {
        return Himg==null? "../img/default.jpg" : Himg;
    }

    public void setHimg(String himg) {
        Himg = himg;
    }

}
