package com.example.admin.boutiqueinventory;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class BoutiqueAdapter extends RecyclerView.Adapter<BoutiqueAdapter.BoutiqueViewHolder> {
    ArrayList<DisplayItems> inventory;
    Context context;
    public BoutiqueAdapter(Context context, ArrayList<DisplayItems> inventory){
        this.context=context;
        this.inventory=inventory;
    }
    /**This method checks whether the view is empty if it is, therefore inflates it with views
     * to fill up the screen via the LayoutManager
     * @return the inflated view on to the empty screen
     *
     */
    @NonNull
    @Override
    public BoutiqueViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recycler_view, viewGroup, false);
        return new BoutiqueViewHolder(view);

    }

    /**Replaces the content of the views once no longer in sight
     * @param boutiqueViewHolder an object of the BoutiqueViewHolder class
     */
    @Override
    public void onBindViewHolder(@NonNull BoutiqueViewHolder boutiqueViewHolder, int position) {
        DisplayItems boutiqueStockView=inventory.get(position);


        boutiqueViewHolder.name.setText(boutiqueStockView.getItemName());
        boutiqueViewHolder.color.setText(boutiqueStockView.getColorNo());
        boutiqueViewHolder.quantity.setText(boutiqueStockView.getQuantity());
        boutiqueViewHolder.price.setText(boutiqueStockView.getPrice());

    }

    @Override
    public int getItemCount() {
        return inventory.size();
    }

    /**
     * @class BoutiqueViewHolder creates views for the items on screen and populates new data to the screen when old
     * view is no longer visible
     * Initialize the views contained in the @layout recycler_view.xml since those are the views to be populated
     * and recycled with data
     */
    public static class BoutiqueViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        TextView color;
        TextView quantity;
        TextView price;

        public BoutiqueViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            color = itemView.findViewById(R.id.color_no);
            quantity = itemView.findViewById(R.id.quantity);
            price = itemView.findViewById(R.id.price);

        }
    }
}
