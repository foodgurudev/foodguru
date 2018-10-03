package br.com.ufrpe.foodguru.infraestrutura.utils;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

<<<<<<< HEAD:app/src/main/java/br/com/ufrpe/foodguru/infraestrutura/SplashActivity.java
import br.com.ufrpe.foodguru.cliente.HomeClienteActivity;
import br.com.ufrpe.foodguru.R;
import br.com.ufrpe.foodguru.estabelecimento.HomeEstabelecimentoActivity;
import br.com.ufrpe.foodguru.estabelecimento.PerfilEstabelecimentoActivity;
=======
import br.com.ufrpe.foodguru.R;
import br.com.ufrpe.foodguru.usuario.GUI.LoginActivity;
import br.com.ufrpe.foodguru.infraestrutura.persistencia.FirebaseHelper;
>>>>>>> ConsertoLogin:app/src/main/java/br/com/ufrpe/foodguru/infraestrutura/utils/SplashActivity.java

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

<<<<<<< HEAD:app/src/main/java/br/com/ufrpe/foodguru/infraestrutura/SplashActivity.java
    private void abrirTelaCliente(){
        Intent intentAbrirTelaCliente = new Intent(SplashActivity.this, HomeClienteActivity.class);
        startActivity(intentAbrirTelaCliente);
        finish();
    }

    private void abrirTelaEstabelecimento() {
        Intent intentAbrirTelaEstabelecimento = new Intent(SplashActivity.this, HomeEstabelecimentoActivity.class);
        startActivity(intentAbrirTelaEstabelecimento);
        finish();
    }
    private void verificarTipoConta(FirebaseUser user) {
        firebaseReference.child(FirebaseHelper.REFERENCIA_USUARIOS)
                .child(user.getUid())
                .child(TIPO_CONTA)
                .addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        String tipoConta = dataSnapshot.getValue(String.class);
                        if (dataSnapshot.getValue(String.class) != null){
                            if(tipoConta.equals(TipoContaEnum.CLIENTE.getTipo())) {
                                abrirTelaCliente();
                            } else {
                                abrirTelaEstabelecimento();
                            }
                        }
                    }
                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                    }
                });
    }
}
=======
}
>>>>>>> ConsertoLogin:app/src/main/java/br/com/ufrpe/foodguru/infraestrutura/utils/SplashActivity.java
