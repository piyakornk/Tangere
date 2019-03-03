package com.example.a1w;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.widget.Toast;

public class AppsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apps2);

        AccessibilityManager manager = (AccessibilityManager)getApplicationContext().getSystemService(Context.ACCESSIBILITY_SERVICE);
        if (manager.isEnabled()) {

            AccessibilityEvent e = AccessibilityEvent.obtain();
            e.setEventType(AccessibilityEvent.TYPE_ANNOUNCEMENT);
            e.getText().add("home, next page");

            //There may be other things you need to add like class/packagename, I'm doing this from memory on my non-dev machine, so if this isn't quite right I apologize, I promise it's super close! :)

            manager.sendAccessibilityEvent(e);
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        System.out.println("button pressed, keycode = "+keyCode);
        //Toast.makeText(MainActivity.this, "keycode = "+keyCode, Toast.LENGTH_SHORT);
        //X to home
        if (keyCode == 24 || keyCode == 99 || keyCode == 67) {
            Intent intent = new Intent(AppsActivity.this, HomeActivity.class);
            AppsActivity.this.startActivity(intent);
            return true;
            //A to next page
        } else if (keyCode == 25 || keyCode == 96 || keyCode == 67) {
            Intent intent = new Intent(AppsActivity.this, Apps2Activity.class);
            AppsActivity.this.startActivity(intent);
            return true;
            //select to dialler
        } else if (keyCode == 303 || keyCode == 109 ) {
            Intent intent = new Intent(Intent.ACTION_DIAL);
            startActivity(intent);
            return true;
        }
        return super.onKeyDown(keyCode, event);

    }
}

/*
https://stackoverflow.com/questions/34596644/android-intent-call-number/34596732
 */
