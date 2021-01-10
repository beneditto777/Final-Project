package com.example.myezyfood;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;



public class Menu4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu4);

        TextView textView = (TextView) findViewById(R.id.judulText);
        textView.setPaintFlags(textView.getPaintFlags()| Paint.UNDERLINE_TEXT_FLAG);
    }

    public void MyOrder(View view) {
        Intent intent = new Intent(Menu4.this, MyOrder.class);
        startActivity(intent);
    }

    private int calculateprice(boolean addroticokelat,boolean addrotisrikaya,boolean addbiskuit,boolean addkacang){
        int harga = 0;

        if(addroticokelat){
            harga = harga + 5000;
        }

        if (addrotisrikaya){
            harga = harga + 5000;
        }

        if (addbiskuit){
            harga = harga + 8000;
        }

        if (addkacang) {
            harga = harga + 3000;
        }
        return quantity * harga;
    }

    public void submitOrder(View view) {
        EditText nameEditText=(EditText)findViewById(R.id.editName);
        String name=nameEditText.getText().toString();
        Log.v("activity_menu4","Nama:"+name);

        CheckBox roticokelatChekBox= (CheckBox) findViewById(R.id.rotiCokelat);
        boolean roticokelat = roticokelatChekBox.isChecked();
        Log.v("activity_menu4","Roti Cokelat" +roticokelat);

        CheckBox rotisrikayaChekBox= (CheckBox) findViewById(R.id.rotiSrikaya);
        boolean rotisrikaya = rotisrikayaChekBox.isChecked();
        Log.v("activity_menu4","Roti Srikaya" +rotisrikaya);

        CheckBox biskuitChekBox= (CheckBox) findViewById(R.id.biskuit);
        boolean biskuit = biskuitChekBox.isChecked();
        Log.v("activity_menu4","Hot Dog" +biskuit);

        CheckBox kacangChekBox= (CheckBox) findViewById(R.id.kacang);
        boolean kacang = kacangChekBox.isChecked();
        Log.v("activity_menu4","Spagetti" +kacang);

        int price = calculateprice(roticokelat, rotisrikaya, biskuit, kacang);
        String pricemessage = Order(price, name, roticokelat, rotisrikaya, biskuit, kacang);


        displayMessage(pricemessage);

    }

    private String Order(int price, String name, boolean addroticokelat,boolean addrotisrikaya,boolean addbiskuit,boolean addkacang){
        String pricemessage= "\nNama             : "+name;
        pricemessage+="\nRoti Cokelat  : "+addroticokelat;
        pricemessage+="\nRoti Srikaya  : "+addrotisrikaya;
        pricemessage+="\nBiskuit           : "+addbiskuit;
        pricemessage+="\nKacang         : "+addkacang;
        pricemessage+="\nQuantity        : "+quantity;
        pricemessage+="\nTotal              : Rp."+price;
        pricemessage+="\n\nKlik Order untuk memesan..";
        return  pricemessage;
    }

    int quantity = 0;
    public void increment(View view){
        if(quantity == 100){
            Toast.makeText(this,"Maximal 50",Toast.LENGTH_SHORT).show();
            return;
        }
        quantity = quantity+1 ;
        display(quantity);
    }

    public void decrement(View view){
        if (quantity == 1){
            Toast.makeText(this,"Minimal 1",Toast.LENGTH_SHORT).show();
            return;
        }
        quantity = quantity -1;
        display(quantity);
    }


    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantitySnacks);
        quantityTextView.setText("" + number);
    }

    private void displayMessage(String pricemessage) {
        TextView priceTextView = (TextView) findViewById(R.id.price);
        priceTextView.setText(pricemessage);
    }

}