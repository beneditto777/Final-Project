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



import java.text.NumberFormat;

public class Menu2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu2);

        TextView textView = (TextView) findViewById(R.id.judulText);
        textView.setPaintFlags(textView.getPaintFlags()| Paint.UNDERLINE_TEXT_FLAG);
    }

    public void MyOrder(View view) {
        Intent intent = new Intent(Menu2.this, MyOrder.class);
        startActivity(intent);
    }

    private int calculateprice(boolean addnasigoreng,boolean addcheeseburger,boolean addhotdog,boolean addspagetti){
        int harga = 0;

        if(addnasigoreng){
            harga = harga + 15000;
        }

        if (addcheeseburger){
            harga = harga + 15000;
        }

        if (addhotdog){
            harga = harga + 10000;
        }

        if (addspagetti) {
            harga = harga + 20000;
        }
        return quantity * harga;
    }

    public void submitOrder(View view) {
        EditText nameEditText=(EditText)findViewById(R.id.editName);
        String name=nameEditText.getText().toString();
        Log.v("activity_menu2","Nama:"+name);

        CheckBox nasigorengChekBox= (CheckBox) findViewById(R.id.nasiGoreng);
        boolean nasigoreng = nasigorengChekBox.isChecked();
        Log.v("activity_menu2","Nasi Goreng" +nasigoreng);

        CheckBox cheeseburgerChekBox= (CheckBox) findViewById(R.id.cheeseBurger);
        boolean cheeseburger = cheeseburgerChekBox.isChecked();
        Log.v("activity_menu2","Cheese Burger" +cheeseburger);

        CheckBox hotdogChekBox= (CheckBox) findViewById(R.id.hotDog);
        boolean hotdog = hotdogChekBox.isChecked();
        Log.v("activity_menu2","Hot Dog" +hotdog);

        CheckBox spagettiChekBox= (CheckBox) findViewById(R.id.spagetti);
        boolean spagetti = spagettiChekBox.isChecked();
        Log.v("activity_menu2","Spagetti" +spagetti);

        int price = calculateprice(nasigoreng, cheeseburger, hotdog, spagetti);
        String pricemessage = Order(price, name, nasigoreng, cheeseburger, hotdog, spagetti);


        displayMessage(pricemessage);

    }

    private String Order(int price, String name, boolean addnasigoreng,boolean addcheeseburger,boolean addhotdog,boolean addspagetti){
        String pricemessage= "\nNama                : "+name;
        pricemessage+="\nNasi Goreng     : "+addnasigoreng;
        pricemessage+="\nCheese Burger : "+addcheeseburger;
        pricemessage+="\nHot Dog            : "+addhotdog;
        pricemessage+="\nSpagetti            : "+addspagetti;
        pricemessage+="\nQuantity            : "+quantity;
        pricemessage+="\nTotal                  : Rp."+price;
        pricemessage+="\n\nKlik Order untuk memesan..";
        return  pricemessage;
    }

    int quantity = 0;
    public void increment(View view){
        if(quantity == 100){
            Toast.makeText(this,"Maximal 50", Toast.LENGTH_SHORT).show();
            return;
        }
        quantity = quantity+1 ;
        display(quantity);
    }

    public void decrement(View view){
        if (quantity == 1){
            Toast.makeText(this,"Minimal 1", Toast.LENGTH_SHORT).show();
            return;
        }
        quantity = quantity -1;
        display(quantity);
    }


    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantityFoods);
        quantityTextView.setText("" + number);
    }

    private void displayMessage(String pricemessage) {
        TextView priceTextView = (TextView) findViewById(R.id.price);
        priceTextView.setText(pricemessage);
    }

}