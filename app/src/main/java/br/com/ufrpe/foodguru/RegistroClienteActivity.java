package br.com.ufrpe.foodguru;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.database.FirebaseDatabase;

public class RegistroClienteActivity extends AppCompatActivity implements View.OnClickListener{
    private EditText nomeClienteReg;
    private EditText emailClienteReg;
    private EditText senhaClienteReg;
    private EditText confirmaSenhaClienteReg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_cliente);
        nomeClienteReg = findViewById(R.id.etNomeCliente);
        emailClienteReg = findViewById(R.id.etEmailCliente);
        senhaClienteReg = findViewById(R.id.etSenhaCliente);
        confirmaSenhaClienteReg = findViewById(R.id.etConfirmarSenhaCliente);

    }

    private boolean validarCampos(){
        boolean validacao = true;
        if (nomeClienteReg.getText().toString().trim().isEmpty()){
            nomeClienteReg.setError(getString(R.string.sp_excecao_campo_vazio));
            validacao = false;
        }
        if ((!Helper.verificaExpressaoRegularEmail(emailClienteReg.getText().toString())) ||
                emailClienteReg.getText().toString().trim().length() == 0) {
            emailClienteReg.setError(getString(R.string.sp_excecao_email));
            validacao = false;
        }
        if (senhaClienteReg.getText().toString().isEmpty()) {
            senhaClienteReg.setError(getString(R.string.sp_excecao_senha));
            validacao = false;
        }
        if (confirmaSenhaClienteReg.getText().toString().isEmpty()) {
            confirmaSenhaClienteReg.setError(getString(R.string.alerta_campo_vazio));
            validacao = false;
        }
        if (!senhaClienteReg.getText().toString()
                .equals(confirmaSenhaClienteReg.getText().toString())) {
            senhaClienteReg.setError(getString(R.string.sp_excecao_senhas_iguais));
            confirmaSenhaClienteReg.setError(getString(R.string.sp_excecao_senhas_iguais));
            validacao = false;
        }
        if (senhaClienteReg.getText().toString().length() < 6){
            senhaClienteReg.setError("Digite una senha com mais de 6 caracteres.");
            validacao = false;
        }
        return validacao;
    }

    public void confirmarCadastro(String email, String senha){
        if (!validarCampos()){
            return;
        }
        FirebaseHelper.getFirebaseAuth().createUserWithEmailAndPassword(email, senha)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            adicionarUsuario();
                        }else{
                            Helper.criarToast(RegistroClienteActivity.this, "Informe um email válido.");
                        }
                    }
                });


    }
    public void adicionarUsuario(){
        Usuario usuario = criarUsuario();
        FirebaseDatabase.getInstance().getReference(FirebaseHelper.REFERENCIA_USUARIOS)
                .child(FirebaseHelper.getUidUsuario())
                .setValue(usuario).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()){
                    Helper.criarToast(RegistroClienteActivity.this,"Registro conluído com sucesso.");
                }
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_confirmar_cadastro_cliente:
                confirmarCadastro(emailClienteReg.getText().toString(),
                        senhaClienteReg.getText().toString());
                break;
            default:
                break;
        }
    }
    public Usuario criarUsuario(){
        Usuario usuario = new Usuario();
        usuario.setEmail(emailClienteReg.getText().toString());
        usuario.setNome(nomeClienteReg.getText().toString());
        usuario.setTipoConta(TipoContaEnum.CLIENTE.getTipo());
        return usuario;
    }
}
