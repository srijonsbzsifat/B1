package com.example.sifatbinzaman.b1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class SecondActivity extends AppCompatActivity {

    EditText result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        result = findViewById(R.id.result);
        String username= getIntent().getStringExtra("Username");
        String password= getIntent().getStringExtra("Password");

        int flag = getIntent().getIntExtra("flag", 0);
        if(flag==1)
        {
            result.append("U have signed up successfully!!\nUsername is: " + username + "\nPassword is: " + password);
        }
        else if(flag==2)
        {
            result.append("Login successful!!\nUsername is: " + username + "\nPassword is: " + password);

        }






    }
}
