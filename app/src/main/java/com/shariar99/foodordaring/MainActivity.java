package com.shariar99.foodordaring;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.app.Activity;
import android.os.Bundle;

import com.shariar99.foodordaring.Adapters.MainAdapter;
import com.shariar99.foodordaring.Models.MainModel;
import com.shariar99.foodordaring.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        ArrayList<MainModel> list = new ArrayList<>();
        list.add(new MainModel(R.drawable.bergar,"Bergar","5","Akon disc dea ki hoba pora change korbo"));
        list.add(new MainModel(R.drawable.france,"France","7","Akon disc dea ki hoba pora change korbo"));
        list.add(new MainModel(R.drawable.pizza,"Pizza","9","Akon disc dea ki hoba pora change korbo"));
        list.add(new MainModel(R.drawable.barfrance,"Bargar Francefry","10","Akon disc dea ki hoba pora change korbo"));
        list.add(new MainModel(R.drawable.desert,"Desert","10","Akon disc dea ki hoba pora change korbo"));
        list.add(new MainModel(R.drawable.icecream,"Ice Cream","10","Akon disc dea ki hoba pora change korbo"));

        MainAdapter adapter = new MainAdapter(list,this);
        binding.recyclerView.setAdapter(adapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        binding.recyclerView.setLayoutManager(layoutManager);


    }
}