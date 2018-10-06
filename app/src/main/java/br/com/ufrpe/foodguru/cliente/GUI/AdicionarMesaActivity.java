package br.com.ufrpe.foodguru.cliente.GUI;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import br.com.ufrpe.foodguru.R;
import br.com.ufrpe.foodguru.estabelecimento.GUI.RegistroEstabelecimentoActivity;
import br.com.ufrpe.foodguru.infraestrutura.utils.Helper;

public class AdicionarMesaActivity extends AppCompatActivity {
    private EditText etNumeroMesa, etCodigoMesa;
    private ProgressDialog progressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adicionar_mesa);
        setUpViews();
    }

    private void setUpViews(){
        etNumeroMesa = findViewById(R.id.etNumeroMesa);
        etCodigoMesa = findViewById(R.id.etCodigoMesa);
        progressDialog.setCanceledOnTouchOutside(false);
    }

    private boolean validarCampos(){
        boolean validacao = true;
        if (etNumeroMesa.getText().toString().trim().isEmpty()){
            etNumeroMesa.setError(getString(R.string.sp_excecao_campo_vazio));
            validacao = false;
        }
        if (etCodigoMesa.getText().toString().trim().isEmpty()){
            etCodigoMesa.setError(getString(R.string.sp_excecao_campo_vazio));
            validacao = false;
        }
        return validacao;
    }
}
