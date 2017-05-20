package com.tom.medical;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {

    private static final String TAG = LoginActivity.class.getSimpleName();
    private EditText edEmail;
    private EditText edPasswd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        edEmail = (EditText) findViewById(R.id.ed_email);
        edPasswd = (EditText) findViewById(R.id.ed_passwd);
    }

    public void login(View v){
        String email = edEmail.getText().toString();
        String passwd = edPasswd.getText().toString();
        final FirebaseAuth auth = FirebaseAuth.getInstance();
        auth.signInWithEmailAndPassword(email, passwd)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            Log.d(TAG, "onComplete: Login Successful");
                            Log.d(TAG, "onComplete: "+auth.getCurrentUser().getUid());
                        }else {
                            Log.d(TAG, "onComplete: Login Failed");
                        }
                    }
                });
    }
}
