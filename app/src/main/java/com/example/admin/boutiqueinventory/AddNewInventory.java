package com.example.admin.boutiqueinventory;

import android.annotation.TargetApi;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AddNewInventory extends AppCompatActivity {
    FirebaseFirestore db = FirebaseFirestore.getInstance();
    private static final String TAG= "Tag";
    @BindView(R.id.item_name)
    EditText itemName;
    @BindView(R.id.color_number_edit_text)
    EditText colorNumber;
    @BindView(R.id.quantity)
    EditText quantity;
    @BindView(R.id.price)
    EditText price;
    @BindView(R.id.add_new_inventory)
    Button addNewInventory;

 //   TextInputEditText itemName, colorNumber, quantity, price;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_inventory);
        ButterKnife.bind(this);
        //OnClick listener for the submit Button

        addNewInventory.setOnClickListener(new View.OnClickListener() {
            @TargetApi(Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View v) {


                if (itemName.getText().toString().isEmpty() && colorNumber.getText().toString().isEmpty()
                        && quantity.getText().toString().isEmpty() && price.getText().toString().isEmpty()) {

                    toast("Please type something some fields are empty");
                }
                else {

                    // Create a new user
                    Map<String, Object> user = new HashMap<>();
                    user.put("itemname", itemName.getText().toString().trim());
                    user.put("colornumber", colorNumber.getText().toString().trim());
                    user.put("quantity", quantity.getText().toString().trim());
                    user.put("price", price.getText().toString().trim());

                      // Add a new document with a generated ID From firestore
                    db.collection("Inventorysystem")
                            .add(user)
                            .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                                @Override
                                public void onSuccess(DocumentReference documentReference) {
                                    Log.d(TAG, "DocumentSnapshot added with ID: " + documentReference.getId());
                                    toast("Information Saved!!");
                                }
                            })
                            .addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Log.w(TAG, "Error adding document", e);
                                }
                            });


                }
            }
        });
    }

    private void toast(String string){
        Toast.makeText(AddNewInventory.this, string, Toast.LENGTH_SHORT).show();
    }

}
