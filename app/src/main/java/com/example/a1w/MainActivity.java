package com.example.a1w;

import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
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

public class MainActivity extends AppCompatActivity {

    private TextView clock;
    private TextView date;
    private TextView noti_count;
    private Button btnLike_1;
    private Button btnLike_2;
    private Button btnLike_3;
    private Button btnLike_4;
    private Button btnReply_1;
    private Button btnReply_2;
    private Button btnReply_3;
    private Button btnReply_4;
    private Button close_1;
    private Button close_2;
    private Button close_3;
    private Button close_4;
    private Button next;
    private LinearLayout notification;
    private LinearLayout noti1;
    private LinearLayout noti2;
    private LinearLayout noti3;
    private LinearLayout noti4;

    private Thread clockThread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        clock = findViewById(R.id.clock);
        date = findViewById(R.id.date);
        next = findViewById(R.id.home_main);

        btnLike_1 = findViewById(R.id.like_noti1);
        btnLike_2 = findViewById(R.id.like_noti2);
        btnLike_3 = findViewById(R.id.like_noti3);
        btnLike_4 = findViewById(R.id.like_noti4);

        btnReply_1 = findViewById(R.id.reply_noti1);
        btnReply_2 = findViewById(R.id.reply_noti2);
        btnReply_3 = findViewById(R.id.reply_noti3);
        btnReply_4 = findViewById(R.id.reply_noti4);

        noti1 = findViewById(R.id.noti1);
        noti2 = findViewById(R.id.noti2);
        noti3 = findViewById(R.id.noti3);
        noti4 = findViewById(R.id.noti4);

        close_1 = findViewById(R.id.close_noti1);
        close_2 = findViewById(R.id.close_noti2);
        close_3 = findViewById(R.id.close_noti3);
        close_4 = findViewById(R.id.close_noti4);

        noti_count = findViewById(R.id.noti_count);
        notification = findViewById(R.id.notification);

        clockThread = new Thread() {

            @Override
            public void run() {
                try {
                    while (!clockThread.isInterrupted()) {
                        Thread.sleep(500);
                        runOnUiThread(new Runnable() {
                            @RequiresApi(api = Build.VERSION_CODES.O)
                            @Override
                            public void run() {
                                // update TextView here!
                                DateTimeFormatter time = DateTimeFormatter.ofPattern("HH:mm:ss");
                                DateTimeFormatter day = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                                LocalDateTime now = LocalDateTime.now();

                                clock.setText(time.format(now));
                                date.setText(day.format(now));
                                noti_count.setText("" + notification.getChildCount() + " notification(s)");
                            }
                        });
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        clockThread.start();

        noti_count.setText("" + notification.getChildCount() + " notification(s)");

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AppsActivity.class);
                MainActivity.this.startActivity(intent);
            }
        });

        close_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((ViewManager)noti1.getParent()).removeView(noti1);
            }
        });

        close_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((ViewManager)noti2.getParent()).removeView(noti2);
            }
        });

        close_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((ViewManager)noti3.getParent()).removeView(noti3);
            }
        });

        close_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((ViewManager)noti4.getParent()).removeView(noti4);
            }
        });
    }

    public static Intent newFacebookIntent(PackageManager pm, String url) {
        Uri uri = Uri.parse(url);
        try {
            ApplicationInfo applicationInfo = pm.getApplicationInfo("com.facebook.katana", 0);
            if (applicationInfo.enabled) {
                // http://stackoverflow.com/a/24547437/1048340
                uri = Uri.parse("fb://facewebmodal/f?href=" + url);
            }
        } catch (PackageManager.NameNotFoundException ignored) {
        }
        return new Intent(Intent.ACTION_VIEW, uri);
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
        System.out.println("button pressed, keycode = "+keyCode);
        Toast.makeText(MainActivity.this, "keycode = "+keyCode, Toast.LENGTH_SHORT);
        if (keyCode == 25 || keyCode == 96 || keyCode == 67) {
            Intent intent = new Intent(MainActivity.this, HomeActivity.class);
            MainActivity.this.startActivity(intent);
            return true;
        } else {
            return super.onKeyDown(keyCode, event);
        }
    }

    @Override
    //push to dial
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        System.out.println("button pressed, keycode = "+keyCode);
        Toast.makeText(MainActivity.this, "keycode = "+keyCode, Toast.LENGTH_SHORT);
        if (keyCode == 303 || keyCode == 109 ) {
            android:autoLink = "phone";
            return true;
        } else {
            return super.onKeyDown(keyCode, event);
        }
    }
}
