package com.example.a1w;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.Toast;

public class AppsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apps2);
    }

    @Override
    //X to home
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        System.out.println("button pressed, keycode = "+keyCode);
        // Toast.makeText(MainActivity.this, "keycode = "+keyCode, Toast.LENGTH_SHORT);
        if (keyCode == 24 || keyCode == 99 || keyCode == 67) {
            Intent intent = new Intent(AppsActivity.this, HomeActivity.class);
            this.startActivity(intent);
        } else if (keyCode == 303) {
            // implement your code here
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    //X to home
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        System.out.println("button pressed, keycode = "+keyCode);
        Toast.makeText(MainActivity.this, "keycode = "+keyCode, Toast.LENGTH_SHORT);
        if (keyCode == 24 || keyCode == 99 || keyCode == 67) {
            Intent intent = new Intent(MainActivity.this, HomeActivity.class);
            MainActivity.this.startActivity(intent);
            return true;
        } else {
            return super.onKeyDown(keyCode, event);
        }
    }
    @Override
    //A to next page
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        System.out.println("button pressed, keycode = " + keyCode);
        Toast.makeText(MainActivity.this, "keycode = " + keyCode, Toast.LENGTH_SHORT);
        if (keyCode == 25 || keyCode == 96 || keyCode == 67) {
            Intent intent = new Intent(AppsActivity.this, AppsActivity.class);
            AppsActivity.this.startActivity(intent);
            return true;
        } else {
            return super.onKeyDown(keyCode, event);
        }
    }
}

/*
https://stackoverflow.com/questions/34596644/android-intent-call-number/34596732
 */
