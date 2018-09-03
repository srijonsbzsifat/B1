package com.example.sifatbinzaman.b1;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import javax.xml.transform.Templates;


public class MainActivity extends AppCompatActivity {


    EditText txtUserName, txtPassword;
    Button btnLogin, btnSignUp;
    private FirebaseAuth mAuth;
    private ProgressDialog progressDialog;
    private String email,password;

    String sUserName, sPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {//onCreate is a func of the AppCopatActivity class
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Toast.makeText(getApplicationContext(), "onCreate()", Toast.LENGTH_LONG).show();

        mAuth = FirebaseAuth.getInstance();
        progressDialog = new ProgressDialog(this);
        btnLogin = findViewById(R.id.btnLogin);
        btnSignUp = findViewById(R.id.btnSignUp);
        txtUserName = findViewById(R.id.txtUserName);
        txtPassword = findViewById(R.id.txtPassword);


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signIn();


            }
        });
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signUp();
                Intent i = new Intent(getApplicationContext(),SecondActivity.class);


                i.putExtra("Username",email);
                i.putExtra("Password",password);
                i.putExtra("flag", 1);

//Fire that second activity

                startActivity(i);

            }
        });

    }
    private void signIn()
    {
        email = txtUserName.getText().toString().trim();
        password = txtPassword.getText().toString().trim();
        if(email.isEmpty())
        {
            Toast.makeText(getApplicationContext(),"Pkease enter user name",Toast.LENGTH_SHORT).show();

        }
        else if(password.isEmpty())
        {
            Toast.makeText(getApplicationContext(),"Pkease enter password",Toast.LENGTH_SHORT).show();

        }

        progressDialog.setMessage("Please Wait!!");
        progressDialog.show();

        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            //Log.d(TAG, "signInWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            Toast.makeText(getApplicationContext(),"Login Success",Toast.LENGTH_SHORT).show();
                            Intent i = new Intent(getApplicationContext(),SecondActivity.class);
                            i.putExtra("Username",email);
                            i.putExtra("Password",password);
                            i.putExtra("flag", 2);
                            startActivity(i);

                            //updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            //Log.w(TAG, "signInWithEmail:failure", task.getException());
                            Toast.makeText(MainActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                            //updateUI(null);
                        }
                        progressDialog.dismiss();

                        // ...
                    }
                });



    }

    private void signUp()
    {

        email = txtUserName.getText().toString().trim();
        password = txtPassword.getText().toString().trim();
        if(email.isEmpty())
        {
            Toast.makeText(getApplicationContext(),"Pkease enter user name",Toast.LENGTH_SHORT).show();

        }
        else if(password.isEmpty())
        {
            Toast.makeText(getApplicationContext(),"Pkease enter password",Toast.LENGTH_SHORT).show();

        }

        progressDialog.setMessage("Please Wait!!");
        progressDialog.show();

        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            //Log.d(TAG, "createUserWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            Toast.makeText(getApplicationContext(),"SignUp Success",Toast.LENGTH_SHORT).show();

                            //updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            //Log.w(TAG, "createUserWithEmail:failure", task.getException());
                            Toast.makeText(MainActivity.this, "Sign Up failed.",
                                    Toast.LENGTH_SHORT).show();
                            //updateUI(null);
                        }
                        progressDialog.dismiss();

                        // ...
                    }
                });
    }


    @Override
    protected void onResume(){
        super.onResume();
        Toast.makeText(getApplicationContext(),"onResume()",Toast.LENGTH_SHORT).show();

    }
    @Override
    protected void onPause(){
        super.onPause();
        Toast.makeText(getApplicationContext(),"onPause()",Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onStop(){
        super.onStop();
        Toast.makeText(getApplicationContext(),"onStop()",Toast.LENGTH_SHORT).show();

    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
        Toast.makeText(getApplicationContext(),"onDestroy()",Toast.LENGTH_SHORT).show();

    }

}
