package com.example.eczaneapps.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Eczane {

    @SerializedName("Id")
    @Expose
    private Integer id;
    @SerializedName("EczaneAdi")
    @Expose
    private String eczaneAdi;
    @SerializedName("EczaneAdres")
    @Expose
    private String eczaneAdres;
    @SerializedName("EczaneTel")
    @Expose
    private String eczaneTel;
    @SerializedName("EczaneKonum")
    @Expose
    private String eczaneKonum;
    @SerializedName("EczaneIlce")
    @Expose
    private String eczaneIlce;
    @SerializedName("EczaciAdi")
    @Expose
    private String eczaciAdi;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEczaneAdi() {
        return eczaneAdi;
    }

    public void setEczaneAdi(String eczaneAdi) {
        this.eczaneAdi = eczaneAdi;
    }

    public String getEczaneAdres() {
        return eczaneAdres;
    }

    public void setEczaneAdres(String eczaneAdres) {
        this.eczaneAdres = eczaneAdres;
    }

    public String getEczaneTel() {
        return eczaneTel;
    }

    public void setEczaneTel(String eczaneTel) {
        this.eczaneTel = eczaneTel;
    }

    public String getEczaneKonum() {
        return eczaneKonum;
    }

    public void setEczaneKonum(String eczaneKonum) {
        this.eczaneKonum = eczaneKonum;
    }

    public String getEczaneIlce() {
        return eczaneIlce;
    }

    public void setEczaneIlce(String eczaneIlce) {
        this.eczaneIlce = eczaneIlce;
    }

    public String getEczaciAdi() {
        return eczaciAdi;
    }

    public void setEczaciAdi(String eczaciAdi) {
        this.eczaciAdi = eczaciAdi;
    }
}
