package com.example.clair.welp;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.support.constraint.ConstraintLayout;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignUp_Auth extends AppCompatActivity {
    EditText etUsername,etEmail,etPassword,etConfirmPassword;
    Button btnRegister;
    ImageButton ibBack;
    ConstraintLayout activity_sign_up_auth;
    private FirebaseAuth auth;
    Snackbar snackbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up__auth);

        //region widgets and listeners
        etUsername=findViewById(R.id.et_Username);
        etEmail=findViewById(R.id.et_Email);
        etPassword=findViewById(R.id.et_Password);
        etConfirmPassword=findViewById(R.id.et_CfmPassword);
        btnRegister=findViewById(R.id.btnRegister);
        ibBack=findViewById(R.id.ib_Back);
        activity_sign_up_auth=findViewById(R.id.activity_sign_up_auth);

        btnRegister.setOnClickListener(mListener);
        ibBack.setOnClickListener(mListener);
        //endregion

        auth= FirebaseAuth.getInstance();
    }
    private View.OnClickListener mListener=new View.OnClickListener(){
        @Override
        public void onClick(View view) {
            if(view.getId()==btnRegister.getId()){
                try {
                    if (etPassword.getText().toString().equals(etConfirmPassword.getText().toString()))
                        signUpUser(etUsername.getText().toString(), etEmail.getText().toString(), etPassword.getText().toString());
                    else {
                        throw new Exception("Password does not match");
                    }
                }catch (Exception e){
                    snackbar=Snackbar.make(activity_sign_up_auth,e.getMessage(),Snackbar.LENGTH_SHORT);
                    snackbar.show();
                }
            }
            else if (view.getId()==ibBack.getId()){
                onBackPressed();
            }

        }
    };
    private void signUpUser(String username,String email, String password){
        auth.createUserWithEmailAndPassword(email,password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(!task.isSuccessful()){
                            snackbar=Snackbar.make(activity_sign_up_auth,"Error"+task.getException(),Snackbar.LENGTH_INDEFINITE);
                            snackbar.show();
                        }
                        else{
                            //todo: put user obj in firebase
                            startActivity(new Intent(SignUp_Auth.this,MainActivity.class));
                        }
                    }
                });
    }
}

