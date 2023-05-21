package com.zxy.entity;

public class City {
    private int Cno;
    private String Cname;
    private String Cin;

    public City() {
        super();
    }

    public City(String cname, String cin) {
        Cname = cname;
        Cin = cin;
    }

    public City(int cno, String cname, String cin) {
        Cno = cno;
        Cname = cname;
        Cin = cin;
    }

    public int getCno() {
        return Cno;
    }

    public void setCno(int cno) {
        Cno = cno;
    }

    public String getCname() {
        return Cname;
    }

    public void setCname(String cname) {
        Cname = cname;
    }

    public String getCin() {
        return Cin;
    }

    public void setCin(String cin) {
        Cin = cin;
    }

    @Override
    public String toString() {
        return "City{" +
                "Cno=" + Cno +
                ", Cname='" + Cname + '\'' +
                ", Cin='" + Cin + '\'' +
                '}';
    }
}
