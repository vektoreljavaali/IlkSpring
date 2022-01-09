package com.vektorel.IlkSpring.modelpages;


public class UrunModel {

   private  String pagename;

    public UrunModel() {
    }

    public UrunModel(String pagename) {
        this.pagename = pagename;
    }

    public String getPagename() {
        return pagename;
    }

    public void setPagename(String pagename) {
        this.pagename = pagename;
    }
}
