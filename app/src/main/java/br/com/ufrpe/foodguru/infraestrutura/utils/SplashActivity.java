package br.com.ufrpe.foodguru.infraestrutura.utils;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import br.com.ufrpe.foodguru.R;
import br.com.ufrpe.foodguru.usuario.GUI.LoginActivity;
import br.com.ufrpe.foodguru.infraestrutura.persistencia.FirebaseHelper;

public class SplashActivity extends AppCompatActivity {
    private final int TEMPO_SPLASH = 1000;
    private final FirebaseAuth mAuth = FirebaseHelper.getFirebaseAuth();
    private final DatabaseReference firebaseReference = FirebaseDatabase.getInstance().getReference();
    private final String TIPO_CONTA = "tipoConta";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        startHandler();
    }

    private void startHandler() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startLoginActivity();
            }
        }, TEMPO_SPLASH);

    }

    private void startLoginActivity() {
        Intent loginIntent = new Intent(this, LoginActivity.class);
        startActivity(loginIntent);
        finish();
    }

}