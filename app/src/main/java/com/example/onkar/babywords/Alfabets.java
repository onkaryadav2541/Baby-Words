package com.example.onkar.babywords;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.ColorSpace;
import android.os.Bundle;

import java.util.ArrayList;

public class Alfabets extends AppCompatActivity {

    RecyclerView recyclerView;

    ArrayList<MainModel> mainModels;
    MainAdapter mainAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alfabets);

        recyclerView = findViewById(R.id.recycler_view);

        Integer[] langLogo = {R.drawable.apple,R.drawable.ball,R.drawable.cat,R.drawable.donkey,R.drawable.elephant,R.drawable.fish,R.drawable.gorilla,R.drawable.hen,R.drawable.island,R.drawable.joker,R.drawable.kite,R.drawable.lion,R.drawable.mango,R.drawable.nest,R.drawable.owl,R.drawable.parrot,R.drawable.queen,R.drawable.rabbit,R.drawable.santaclaus,R.drawable.tree,R.drawable.umbrella,R.drawable.van,R.drawable.watermelon,R.drawable.xmas,R.drawable.yacht,R.drawable.zebra};
        String [] langName = {"A","B","C","D","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
        String [] langDetail = {"A for APPLE","B for BALL","C for CAT","D for DONKEY","E for ELEPHANT","F for FISH","G for GORILLA","H for HEN","I for ISLAND","J for JOKER","K for KITE","L for LION","M for MANGO","N for NEST","O for OWL","P for PARROT","Q for QUEEN","R for RABBIT","S for SANTA CLAUS","T for TREE","U for UMBRELLA","V for VAN","W for WATERMELON","X for XMAS TREE","Y for YACHT","Z for ZEBRA"};


        mainModels = new ArrayList<>();
        for (int i=0;i<langLogo.length;i++){
            MainModel model = new MainModel(langLogo[i],langName[i],langDetail[i]);
            mainModels.add(model);
        }
        LinearLayoutManager layoutManager = new LinearLayoutManager(
                Alfabets.this,LinearLayoutManager.HORIZONTAL,false
        );
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        mainAdapter = new MainAdapter(Alfabets.this,mainModels);
        recyclerView.setAdapter(mainAdapter);
    }

}