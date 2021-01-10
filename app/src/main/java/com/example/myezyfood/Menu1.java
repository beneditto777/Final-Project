package com.example.myezyfood;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Menu1 extends AppCompatActivity {

    private View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu1);

    }



    public void Menu3(View view) {
        Intent intent = new Intent(Menu1.this, Menu3.class);
        startActivity(intent);
    }

    public void Menu4(View view) {
        Intent intent = new Intent(Menu1.this, Menu4.class);
        startActivity(intent);
    }

    public void Menu5(View view) {
        Intent intent = new Intent(Menu1.this, Menu5.class);
        startActivity(intent);
    }

    public void Menu2(View view) {
        Intent intent = new Intent(Menu1.this, Menu2.class);
        startActivity(intent);
    }
}