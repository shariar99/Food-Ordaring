package com.shariar99.foodordaring;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.shariar99.foodordaring.Models.DBHelper;
import com.shariar99.foodordaring.databinding.ActivityDetailsBinding;

public class DetailsActivity extends AppCompatActivity {

    ActivityDetailsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        final int image = getIntent().getIntExtra("image",0);
        final  int price = Integer.parseInt(getIntent().getStringExtra("price"));
        final String name = getIntent().getStringExtra("name");
        final   String description = getIntent().getStringExtra("desc");

        binding.detailsImage.setImageResource(image);
        binding.priceLB.setText(String.format("%d",price));
        binding.detailsNameActivityText.setText(name);
        binding.detailsDescription.setText(description);

        DBHelper helper = new DBHelper(this);

        binding.insertBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              boolean isInserted =  helper.insertOrder(
                        binding.nameBox.getText().toString(),
                        binding.phoneBox.getText().toString(),
                        price,
                        image,
                        name,
                        description,
                        Integer.parseInt(binding.quantity.getText().toString())
                );
              if (isInserted){
                  Toast.makeText(DetailsActivity.this, "Data Success", Toast.LENGTH_SHORT).show();
              }
              else {
                  Toast.makeText(DetailsActivity.this, "error", Toast.LENGTH_SHORT).show();
              }


            }
        });


    }
}