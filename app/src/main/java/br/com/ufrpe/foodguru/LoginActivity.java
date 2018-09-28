package br.com.ufrpe.foodguru;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void telaCadastro(View telacadastro) {
        Intent intent = new Intent(this, TipoCadastroActivity.class);
        startActivity(intent);
    }

    public void telaRecuperarSenha(View telaRecuperarSenha) {
        Intent intent = new Intent(this, RecuperarSenhaActivity.class);
        startActivity(intent);
    }

}
