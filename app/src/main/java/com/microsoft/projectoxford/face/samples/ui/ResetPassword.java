package com.microsoft.projectoxford.face.samples.ui;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.microsoft.projectoxford.face.samples.R;

/**
 * Created by anurag on 12/4/18.
 */

public class ResetPassword extends AppCompatActivity{

    String password;
    EditText resetEditText;
    Button resetButton1;

    @Override
    public void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_reset_password);

        //load the password
        SharedPreferences settings = getSharedPreferences("PREFS", 0);
        password = settings.getString("password", "");

        resetEditText = (EditText) findViewById(R.id.resetEditText);
        resetButton1 = (Button) findViewById(R.id.resetButton1);
        resetButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = resetEditText.getText().toString();
                if (text.equals(password)) {
                    //allow user to reset password
                    Intent intent = new Intent(getApplicationContext(), CreatePassword.class);
                    startActivity(intent);
                    finish();
                }
                else
                    Toast.makeText(ResetPassword.this, "Wrong password!", Toast.LENGTH_SHORT).show();
            }
        });
     }
}
