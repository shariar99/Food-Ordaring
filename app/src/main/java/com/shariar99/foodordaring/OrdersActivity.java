package com.shariar99.foodordaring;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.shariar99.foodordaring.Adapters.OrderAdapter;
import com.shariar99.foodordaring.Models.DBHelper;
import com.shariar99.foodordaring.Models.OrdersModel;
import com.shariar99.foodordaring.databinding.ActivityOrdersBinding;

import java.util.ArrayList;

public class OrdersActivity extends AppCompatActivity {

    ActivityOrdersBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityOrdersBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());



        DBHelper helper = new DBHelper(this);
        ArrayList<OrdersModel> list= helper.getOrder();




//        list.add(new OrdersModel(R.drawable.bergar,"Burgar","4","2324425"));
//        list.add(new OrdersModel(R.drawable.bergar,"Burgar","4","2324425"));
//        list.add(new OrdersModel(R.drawable.bergar,"Burgar","4","2324425"));
//        list.add(new OrdersModel(R.drawable.bergar,"Burgar","4","2324425"));
//        list.add(new OrdersModel(R.drawable.bergar,"Burgar","4","2324425"));
//        list.add(new OrdersModel(R.drawable.bergar,"Burgar","4","2324425"));
//        list.add(new OrdersModel(R.drawable.bergar,"Burgar","4","2324425"));
//        list.add(new OrdersModel(R.drawable.bergar,"Burgar","4","2324425"));
//        list.add(new OrdersModel(R.drawable.bergar,"Burgar","4","2324425"));

        OrderAdapter adapter = new OrderAdapter(list,this);
        binding.orderRecyclerView.setAdapter(adapter);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        binding.orderRecyclerView.setLayoutManager(layoutManager);

    }
}