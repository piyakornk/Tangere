package com.example.a1w;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    }
    @Override
    //A to next page
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        System.out.println("button pressed, keycode = " + keyCode);
        Toast.makeText(HomeActivity.this, "keycode = " + keyCode, Toast.LENGTH_SHORT);
        if (keyCode == 25 || keyCode == 96 || keyCode == 67) {
            Intent intent = new Intent(HomeActivity.this, AppsActivity.class);
            HomeActivity.this.startActivity(intent);
            return true;
        } else {
            return super.onKeyDown(keyCode, event);
        }
     }
}
