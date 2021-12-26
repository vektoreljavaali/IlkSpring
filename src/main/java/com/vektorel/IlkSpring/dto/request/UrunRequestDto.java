package com.vektorel.IlkSpring.dto.request;

import com.fasterxml.jackson.annotation.JsonCreator;

public class UrunRequestDto {

    String ad;
    double fiyat;

    @JsonCreator
    public UrunRequestDto(String ad, double fiyat) {
        this.ad = ad;
        this.fiyat = fiyat;
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
