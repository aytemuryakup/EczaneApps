package com.example.eczaneapps;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.app.Activity;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.eczaneapps.Model.Eczane;

import java.util.ArrayList;

public class EczaneAdapter extends RecyclerView.Adapter<EczaneAdapter.ViewHolder> {

    private ArrayList<Eczane> eczaneModels = new ArrayList<>();
    private Context context;




    public EczaneAdapter(Context context, ArrayList<Eczane> eczaneModels) {

        this.eczaneModels = eczaneModels;
        this.context = context;
    }


    @NonNull
    @Override
    public EczaneAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.eczane_list_item, parent, false);
        return new EczaneAdapter.ViewHolder(view);


    }

    @Override
    public void onBindViewHolder(@NonNull final EczaneAdapter.ViewHolder holder, int position) {

        final Eczane eczane = eczaneModels.get(position);


        holder.eczane_name.setText(eczaneModels.get(position).getEczaneAdi());
        holder.eczane_adres.setText(eczaneModels.get(position).getEczaneAdres());
        final String eczane_tel = eczaneModels.get(position).getEczaneTel();



        holder.eczane_ara.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:" + eczane_tel));
                context.startActivity(intent);
            }
        });

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,EczaneMapsActivity.class);
                intent.putExtra("EczaneKonum",eczane.getEczaneKonum());
                intent.putExtra("EczaneAdi",eczane.getEczaneAdi());
                intent.putExtra("EczaneAdres",eczane.getEczaneAdres());
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {

        return eczaneModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {


        private TextView eczane_name, eczane_adres, eczane_ara;
        private CardView cardView;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            eczane_name = itemView.findViewById(R.id.eczane_name);
            eczane_adres = itemView.findViewById(R.id.eczane_adress);
            eczane_ara = itemView.findViewById(R.id.eczane_ara);
            cardView = itemView.findViewById(R.id.cardview);





        }


    }


}
