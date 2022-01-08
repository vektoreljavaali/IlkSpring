package com.vektorel.IlkSpring.constants;

import org.springframework.beans.factory.annotation.Value;

public class RestApiUrls {

/*
    @Value("${muhammeturls.urun.save}")
    static
    String save;
    @Value("${muhammeturls.urun.update}")
    static
    String update;
*/
    public static final String VERSION = "/v1";
    public static final String URUNCONTROLLER = "/urun";
    public static final String URUNCONTROLLER_ADDURUN= "/urun";

    public static final String SAVE = "/save";
    public static final String UPDATE = "/update";
    public static final String DELETE = "/delete";
    public static final String FINDALL = "/findall";
    public static final String FINDBYID = "/findbyid";
    public static final String FINDBYNAME = "/findbyname";

}
