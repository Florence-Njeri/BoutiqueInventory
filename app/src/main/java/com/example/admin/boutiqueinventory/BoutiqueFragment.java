package com.example.admin.boutiqueinventory;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;

public class BoutiqueFragment extends Fragment {;
    RecyclerView recyclerView;
    ArrayList<DisplayItems> inventory;
    BoutiqueAdapter adapter;
    FloatingActionButton addNewInventory;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//Inflate the layout for this fragment



        return inflater.inflate(R.layout.fragment_layout, container, false);


    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.recycler_view);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);

        //Instantiate the arrayList
        inventory=new ArrayList <>();

        adapter=new BoutiqueAdapter(view.getContext(),inventory);
        recyclerView.setAdapter(adapter);

        //Instantiate add new list button
        addNewInventory=view.findViewById(R.id.add_new_inventory);
        addNewInventory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent addInventory=new Intent(getContext(),AddNewInventory.class);
                startActivity(addInventory);
            }
        });
    }
}
