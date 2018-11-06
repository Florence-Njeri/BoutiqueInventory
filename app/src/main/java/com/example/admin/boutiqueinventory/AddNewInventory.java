package com.example.admin.boutiqueinventory;

import android.annotation.TargetApi;
import android.os.Build;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Objects;

public class AddNewInventory extends AppCompatActivity {
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;
    TextInputEditText itemName, colorNumber, quantity, price;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_inventory);

        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("inventory");

        //Instantiate the EditText views
        itemName = findViewById(R.id.item_name);
        colorNumber = findViewById(R.id.color_number_edit_text);
        quantity = findViewById(R.id.quantity);
        price = findViewById(R.id.price);

        //OnClick listener for the submit Button

        Button addNewInventory = findViewById(R.id.add_new_inventory);
        addNewInventory.setOnClickListener(new View.OnClickListener() {
            @TargetApi(Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View v) {
                String name = Objects.requireNonNull(itemName.getText()).toString();
                String color = Objects.requireNonNull(colorNumber.getText()).toString();
                String quantityEntered = Objects.requireNonNull(quantity.getText()).toString();
                String priceItem = Objects.requireNonNull(price.getText()).toString();

                //Instantiate the DisplayItem class for the data typed in by app user
                DisplayItems displayItems = new DisplayItems(name, Integer.parseInt(color), Integer.parseInt(quantityEntered), Integer.parseInt(priceItem));

                databaseReference.setValue(displayItems);
                Toast.makeText(AddNewInventory.this, "Information Saved!!", Toast.LENGTH_SHORT).show();
            }
        });
    }

}
