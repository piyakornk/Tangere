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
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        System.out.println("button pressed, keycode = " + keyCode);
        Toast.makeText(HomeActivity.this, "keycode = " + keyCode, Toast.LENGTH_SHORT);
        //A to next page
        if (keyCode == 25 || keyCode == 96 || keyCode == 67) {
            Intent intent = new Intent(HomeActivity.this, AppsActivity.class);
            HomeActivity.this.startActivity(intent);
            return true;
            // select to dial
        } else if (keyCode == 303 || keyCode == 109 ) {
            Intent intent = new Intent(Intent.ACTION_DIAL)
            startActivity(intent);
            return true;
        }
        return super.onKeyDown(keyCode, event);

    }
}
