package com.example.eczaneapps;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.eczaneapps.Model.Eczane;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class EczaneActivity extends AppCompatActivity {

    RecyclerView eczane_recyclerView;
    ArrayList<Eczane> eczaneModels = new ArrayList<>();

    EczaneAdapter eczaneAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eczane);

        eczane_recyclerView = findViewById(R.id.recyclerviewid);
        eczane_recyclerView.setLayoutManager(new LinearLayoutManager(this));
        getEczaneResponse();


    }

    private void getEczaneResponse() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("json-url-link")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        JSONInterface requestInterface = retrofit.create(JSONInterface.class);
        
        Call<List<Eczane>> call = requestInterface.getEczaneJson();

        call.enqueue(new Callback<List<Eczane>>() {
            @Override
            public void onResponse(Call<List<Eczane>> call, Response<List<Eczane>> response) {
                eczaneModels = new ArrayList<>(response.body());
                eczaneAdapter = new EczaneAdapter(EczaneActivity.this,eczaneModels);
                eczane_recyclerView.setAdapter(eczaneAdapter);
            }

            @Override
            public void onFailure(Call<List<Eczane>> call, Throwable t) {


            }
        });


    }


}

