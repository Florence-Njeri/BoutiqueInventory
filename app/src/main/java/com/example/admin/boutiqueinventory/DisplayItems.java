package com.example.admin.boutiqueinventory;

public class DisplayItems {
    private String itemName;
    private int colorNo;
    private int quantity;
    private int price;

    public DisplayItems(String itemName,int colorNo,int quantity,int price){
        this.itemName=itemName;
        this.colorNo=colorNo;
        this.quantity=quantity;
        this.price=price;


    }

    public String getItemName() {
        return itemName;
    }

    public int getColorNo() {
        return colorNo;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getPrice() {
        return price;
    }
}
