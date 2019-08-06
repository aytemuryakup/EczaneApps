package com.example.eczaneapps;

import com.example.eczaneapps.Model.Eczane;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

interface JSONInterface {

    @GET("getEczane")
    Call<List<Eczane>> getEczaneJson();


}


