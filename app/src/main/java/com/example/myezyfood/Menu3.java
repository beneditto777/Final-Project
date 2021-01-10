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





public class Menu3 extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu3);

        TextView textView = (TextView) findViewById(R.id.judulText);
        textView.setPaintFlags(textView.getPaintFlags()| Paint.UNDERLINE_TEXT_FLAG);
    }

    public void MyOrder(View view) {
        Intent intent = new Intent(Menu3.this, MyOrder.class);
        startActivity(intent);
    }

    private int calculateprice(boolean addairmineral, boolean addjusapel, boolean addjusmangga, boolean addjusalpukat){
        int harga = 0;

        if(addairmineral){
            harga = harga + 5000;
        }

        if (addjusapel){
            harga = harga + 7000;
        }

        if (addjusmangga){
            harga = harga + 7000;
        }

        if (addjusalpukat) {
            harga = harga + 7000;
        }
        return quantity * harga;
    }

    public void submitOrder(View view) {
        EditText nameEditText=(EditText)findViewById(R.id.editName);
        String name=nameEditText.getText().toString();
        Log.v("activity_menu3","Nama:"+name);

        CheckBox airmineralChekBox= (CheckBox) findViewById(R.id.airMineral);
        boolean airmineral=airmineralChekBox.isChecked();
        Log.v("activity_menu3","Air Mineral"+airmineral);

        CheckBox jusapelChekBox= (CheckBox) findViewById(R.id.jusApel);
        boolean jusapel=jusapelChekBox.isChecked();
        Log.v("activity_menu3","Jus Apel"+jusapel);

        CheckBox jusmanggaChekBox= (CheckBox) findViewById(R.id.jusMangga);
        boolean jusmangga=jusmanggaChekBox.isChecked();
        Log.v("activity_menu3","Jus Mangga"+jusmangga);

        CheckBox jusalpukatChekBox= (CheckBox) findViewById(R.id.jusAlpukat);
        boolean jusalpukat=jusalpukatChekBox.isChecked();
        Log.v("activity_menu3","Jus Alpukat"+jusalpukat);

        int price=calculateprice(airmineral,jusapel,jusmangga,jusalpukat);
        String pricemessage = Order(price, name, airmineral, jusapel, jusmangga, jusalpukat);


        displayMessage(pricemessage);

    }

    private String Order(int price, String name, boolean addairmineral, boolean addjusapel, boolean addjusmangga, boolean addjusalpukat) {
        String pricemessage= "\nNama            : "+name;
        pricemessage+="\nAir Mineral    : "+addairmineral;
        pricemessage+="\nJus Apel        : "+addjusapel;
        pricemessage+="\nJus Mangga : "+addjusmangga;
        pricemessage+="\nJus Alpukat  : "+addjusalpukat;
        pricemessage+="\nQuantity        : "+quantity;
        pricemessage+="\nTotal             : Rp."+price;
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
        TextView quantityTextView = (TextView) findViewById(R.id.quantityDrinks);
        quantityTextView.setText("" + number);
    }

    private void displayMessage(String pricemessage) {
        TextView priceTextView = (TextView) findViewById(R.id.price);
        priceTextView.setText(pricemessage);
    }


}
