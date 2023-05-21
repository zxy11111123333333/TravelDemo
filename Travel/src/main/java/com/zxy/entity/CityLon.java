package com.zxy.entity;

public class CityLon {
    private int Lno;
    private String Cname;
    private String Lname;
    private String Lin;
    private String Limg;

    public CityLon(int lno, String cname, String lname, String lin, String limg) {
        Lno = lno;
        Cname = cname;
        Lname = lname;
        Lin = lin;
        Limg = limg;
    }

    public CityLon() {
        super();
    }

    public CityLon(String cname, String lname, String lin, String limg) {
        Cname = cname;
        Lname = lname;
        Lin = lin;
        Limg = limg;
    }

    public int getLno() {
        return Lno;
    }

    public void setLno(int lno) {
        Lno = lno;
    }

    public String getCname() {
        return Cname;
    }

    public void setCname(String cname) {
        Cname = cname;
    }

    public String getLname() {
        return Lname;
    }

    public void setLname(String lname) {
        Lname = lname;
    }

    public String getLin() {
        return Lin;
    }

    public void setLin(String lin) {
        Lin = lin;
    }

    public String getLimg() {
        return Limg==null? "../img/default.jpg" : Limg;
    }

    public void setLimg(String limg) {
        Limg = limg;
    }
}
