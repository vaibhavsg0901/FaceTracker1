package com.microsoft.projectoxford.face.samples.ui;

/**
 * Created by anurag on 11/4/18.
 */

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.microsoft.projectoxford.face.samples.R;

public class SplashActivity extends AppCompatActivity {
    String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        //load the password
        SharedPreferences settings = getSharedPreferences("PREFS", 0);
        password = settings.getString("password", "");

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (password.equals("")) {
                    //if there is no password
                    Intent intent = new Intent(getApplicationContext(), CreatePassword.class);
                    startActivity(intent);
                    finish();
                }
                else {
                    //if there is password
                    Intent intent = new Intent(getApplicationContext(), EnterPassword.class);
                    startActivity(intent);
                    finish();
                }
            }
        }, 2000);
    }
}

