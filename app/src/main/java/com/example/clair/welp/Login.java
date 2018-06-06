package com.example.clair.welp;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.support.constraint.ConstraintLayout;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;

public class Login extends AppCompatActivity {
    Button btnLogin;
    Button btnSignUp;
    EditText etEmail;
    EditText etPassword;
    ConstraintLayout activity_login;
    private FirebaseAuth fFirebaseAuth;
    Snackbar snackbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //region declare widgets and set listeners
        btnLogin=findViewById(R.id.btnLogin);
        btnSignUp=findViewById(R.id.btn_SignUp);
        etEmail=findViewById(R.id.et_Email);
        etPassword=findViewById(R.id.et_Password);
        activity_login=findViewById(R.id.activityLogin);

        btnLogin.setOnClickListener(mListener);
        btnSignUp.setOnClickListener(mListener);
        //endregion

        fFirebaseAuth= FirebaseAuth.getInstance();
    }
    private View.OnClickListener mListener=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if(view.getId()==btnLogin.getId()){
                try{
                    loginUser(etEmail.getText().toString(),etPassword.getText().toString());}
                catch (Exception e){
                    snackbar=Snackbar.make(activity_login,e.getMessage(),Snackbar.LENGTH_SHORT);
                    snackbar.show();
                }
            }
            else if (view.getId()==btnSignUp.getId()){
                startActivity(new Intent(Login.this,SignUp_Year.class));
            }

    }
    };


    //login with firebase
    private void loginUser(String email, final String password){
        fFirebaseAuth.signInWithEmailAndPassword(email,password)
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        if (e instanceof FirebaseAuthException) {
                            ((FirebaseAuthException) e).getErrorCode();
                            Log.d("error",e.getMessage());
                            snackbar=Snackbar.make(activity_login,e.getMessage(),Snackbar.LENGTH_SHORT);
                            snackbar.setActionTextColor(getResources().getColor(R.color.text_color_whenInDoubtUseThis));
                            snackbar.show();
                        }
                    }
                });
        fFirebaseAuth.signInWithEmailAndPassword(email,password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(!task.isSuccessful()){
                            if(password.length()<6){
                                snackbar= Snackbar.make(activity_login,"Password length must be over 6",Snackbar.LENGTH_SHORT);
                                snackbar.setActionTextColor(getResources().getColor(R.color.text_color_whenInDoubtUseThis));
                                snackbar.show();
                            }
                            else {
                                snackbar=Snackbar.make(activity_login,"Invalid Email or Password",Snackbar.LENGTH_SHORT);
                                snackbar.show();
                            }
                        }
                        else {
                            startActivity(new Intent(Login.this,MainActivity.class));
                        }
                    }
                });
    }


    //todo: find a better way to do this
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}
