package com.example.a1w;

import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class HomeActivity extends AppCompatActivity {
        private Button next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        next = findViewById(R.id.moreApps);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, AppsActivity.class);
                HomeActivity.this.startActivity(intent);
            }
        });

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        System.out.println("button pressed, keycode = " + keyCode);
        //A to next page
        if (keyCode == 25 || keyCode == 96 || keyCode == 67) {
            Intent intent = new Intent(HomeActivity.this, AppsActivity.class);
            HomeActivity.this.startActivity(intent);
            return true;
            // select to dial
        } else if (keyCode == 303 || keyCode == 109 ) {
            Intent intent = new Intent(Intent.ACTION_DIAL);
            startActivity(intent);
            return true;
        }
        return super.onKeyDown(keyCode, event);

    }
}
