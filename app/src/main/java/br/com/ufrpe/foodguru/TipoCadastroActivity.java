package br.com.ufrpe.foodguru;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class TipoCadastroActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tipo_cadastro);
    }

    public void telaCadastroCliente(View telacadastroestabelecimento){
        Intent intent = new Intent(this, RegistroClienteActivity.class);
        startActivity(intent);
    }

    public void setTelacadastroestabelecimento(View telacadastroestabelecimento){
        Intent intent = new Intent(this, RegistroEstabelecimentoActivity.class);
        startActivity(intent);
    }
}
