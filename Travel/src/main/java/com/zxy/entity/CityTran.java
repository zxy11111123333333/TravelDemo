package com.zxy.entity;

public class CityTran {
    private int Tno;
    private String Cname;
    private String Tname;

    public CityTran(int tno, String cname, String tname) {
        Tno = tno;
        Cname = cname;
        Tname = tname;
    }

    public CityTran() {
        super();
    }

    public CityTran(String cname, String tname) {
        Cname = cname;
        Tname = tname;
    }

    public int getTno() {
        return Tno;
    }

    public void setTno(int tno) {
        Tno = tno;
    }

    public String getCname() {
        return Cname;
    }

    public void setCname(String cname) {
        Cname = cname;
    }

    public String getTname() {
        return Tname;
    }

    public void setTname(String tname) {
        Tname = tname;
    }
}
