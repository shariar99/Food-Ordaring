package com.shariar99.foodordaring;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
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
        DBHelper helper = new DBHelper(this);

        if (getIntent().getIntExtra("type",0)==1) {

            final int image = getIntent().getIntExtra("image", 0);
            final int price = Integer.parseInt(getIntent().getStringExtra("price"));
            final String name = getIntent().getStringExtra("name");
            final String description = getIntent().getStringExtra("desc");

            binding.detailsImage.setImageResource(image);
            binding.priceLB.setText(String.format("%d", price));
            binding.detailsNameActivityText.setText(name);
            binding.detailsDescription.setText(description);



            binding.insertBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    boolean isInserted = helper.insertOrder(
                            binding.nameBox.getText().toString(),
                            binding.phoneBox.getText().toString(),
                            price,
                            image,
                            name,
                            description,
                            Integer.parseInt(binding.quantity.getText().toString())
                    );
                    if (isInserted) {
                        Toast.makeText(DetailsActivity.this, "Data Success", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(DetailsActivity.this, "error", Toast.LENGTH_SHORT).show();
                    }


                }
            });
        } else {
            int id = getIntent().getIntExtra("id",0);
            Cursor cursor = helper.getOrderById(id);
            int image = cursor.getInt(4);

            binding.detailsImage.setImageResource(cursor.getInt(4));
            binding.priceLB.setText(String.format("%d", cursor.getInt(3)));
            binding.detailsNameActivityText.setText(cursor.getString(6));
            binding.detailsDescription.setText(cursor.getString(5));
            binding.nameBox.setText(cursor.getString(1));
            binding.phoneBox.setText(cursor.getString(2));
            binding.insertBtn.setText("UPDATE NOW");
            binding.insertBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                 boolean isUpdated=   helper.updateOrder(
                            binding.nameBox.getText().toString(),
                            binding.phoneBox.getText().toString(),
                            Integer.parseInt(binding.priceLB.getText().toString()),
                            image,
                            binding.detailsDescription.getText().toString(),
                            binding.detailsNameActivityText.getText().toString(),
                            1,
                            id
                    );
                 if (isUpdated){
                     Toast.makeText(DetailsActivity.this, "Update successfully", Toast.LENGTH_SHORT).show();
                 }else {
                     Toast.makeText(DetailsActivity.this, "error", Toast.LENGTH_SHORT).show();
                 }

                }
            });
        }


    }
}