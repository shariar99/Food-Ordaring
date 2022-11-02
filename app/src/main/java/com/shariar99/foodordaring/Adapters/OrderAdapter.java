package com.shariar99.foodordaring.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.shariar99.foodordaring.Models.OrdersModel;
import com.shariar99.foodordaring.R;

import java.util.ArrayList;

public class OrderAdapter extends  RecyclerView.Adapter<OrderAdapter.viewHolder>{

    ArrayList<OrdersModel> list;
    Context context;

    public OrderAdapter(ArrayList<OrdersModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.order_sample,parent,false);

        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {

        final  OrdersModel model = list.get(position);
        holder.orderImage.setImageResource(model.getOrderImage());
        holder.soldItemName.setText(model.getSoldName());
        holder.orderNumber.setText(model.getOrderNum());
        holder.price.setText(model.getOrderprice());


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {

        ImageView orderImage;
        TextView soldItemName,orderNumber,price;


        public viewHolder(@NonNull View itemView) {
            super(itemView);

            orderImage = itemView.findViewById(R.id.orderImageView);
            soldItemName = itemView.findViewById(R.id.orderItemTextView);
            orderNumber = itemView.findViewById(R.id.orderNumberTextView);
            price = itemView.findViewById(R.id.priceOdrerTextView);
        }
    }
}
