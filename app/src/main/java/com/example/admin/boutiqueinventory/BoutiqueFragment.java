package com.example.admin.boutiqueinventory;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class BoutiqueFragment extends Fragment {;
    RecyclerView recyclerView;
    ArrayList<DisplayItems> inventory;
    BoutiqueAdapter adapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//Inflate the layout for tis fragment
        View rootView = inflater.inflate(R.layout.fragment_layout, container, false);
        recyclerView = rootView.findViewById(R.id.recycler_view);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);

        //Instantiate the arrayList
        inventory=new ArrayList <>();

        adapter=new BoutiqueAdapter(rootView.getContext(),inventory);
        recyclerView.setAdapter(adapter);

        return rootView;
    }
}
