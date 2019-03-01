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
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        System.out.println("button pressed, keycode = "+keyCode);
        Toast.makeText(MainActivity.this, "keycode = "+keyCode, Toast.LENGTH_SHORT);
        //X to home
        if (keyCode == 24 || keyCode == 99 || keyCode == 67) {
            Intent intent = new Intent(AppsActivity.this, HomeActivity.class);
            AppsActivity.this.startActivity(intent);
            return true;
            //A to next page
       /* } else if (keyCode == 25 || keyCode == 96 || keyCode == 67) {
            Intent intent = new Intent(AppsActivity.this, .class);
            AppsActivity.this.startActivity(intent);
            return true;*/ UNTIL WE HAVE THE NEXT ACTIVITY
            // select to dial
        } else if (keyCode == 303 || keyCode == 109 ) {
            Intent intent = new Intent(Intent.ACTION_DIAL)
            startActivity(intent);
            return true;
        }
        return super.onKeyDown(keyCode, event);

    }
}

/*
https://stackoverflow.com/questions/34596644/android-intent-call-number/34596732
 */
