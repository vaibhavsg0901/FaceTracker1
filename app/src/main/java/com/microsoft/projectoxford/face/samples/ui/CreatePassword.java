package com.microsoft.projectoxford.face.samples.ui;

/**
 * Created by anurag on 11/4/18.
 */
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.microsoft.projectoxford.face.samples.R;

public class CreatePassword extends AppCompatActivity {

    EditText editText1, editText2;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_password);

        editText1 = (EditText) findViewById(R.id.editText1);
        editText2 = (EditText) findViewById(R.id.editText2);
        button = (Button) findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text1 = editText1.getText().toString();
                String text2 = editText2.getText().toString();

                if (text1.equals("") || text2.equals("")) {
                    //there is no password
                    Toast.makeText(CreatePassword.this, "No password entered!", Toast.LENGTH_SHORT).show();
                }
                else {
                    if (text1.equals(text2)) {
                        //save the password
                        SharedPreferences settings = getSharedPreferences("PREFS", 0);
                        SharedPreferences.Editor editor = settings.edit();
                        editor.putString("password", text1);
                        editor.apply();

                        //enter the app
                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(intent);
                        finish();
                    }
                    else {
                        //there is no match on password
                        Toast.makeText(CreatePassword.this, "Passwords doesn't match", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}

