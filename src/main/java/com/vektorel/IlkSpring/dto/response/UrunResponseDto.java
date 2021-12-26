package com.vektorel.IlkSpring.dto.response;

import com.fasterxml.jackson.annotation.JsonCreator;

public class UrunResponseDto {

    long id;
    String ad;
    double fiyat;

    @JsonCreator
    public UrunResponseDto(long id, String ad, double fiyat) {
        this.id = id;
        this.ad = ad;
        this.fiyat = fiyat;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public double getFiyat() {
        return fiyat;
    }

    public void setFiyat(double fiyat) {
        this.fiyat = fiyat;
    }
}
