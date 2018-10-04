package br.com.ufrpe.foodguru.cliente.GUI;

import android.support.v4.app.Fragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;
import android.widget.TextView;

import br.com.ufrpe.foodguru.cliente.EscanearQrCodeFragment;
import br.com.ufrpe.foodguru.infraestrutura.utils.Helper;

import com.google.firebase.auth.FirebaseAuth;

import br.com.ufrpe.foodguru.R;
import br.com.ufrpe.foodguru.infraestrutura.persistencia.FirebaseHelper;
import br.com.ufrpe.foodguru.usuario.GUI.LoginActivity;

public class HomeClienteActivity extends AppCompatActivity {
    private FirebaseAuth mAuth = FirebaseHelper.getFirebaseAuth();
    private TextView mTextMessage;
    private BottomNavigationView mNavCliente;
    private FrameLayout mFrameCliente;
    private br.com.ufrpe.foodguru.cliente.EscanearQrCodeFragment escanearQrCodeFragment;
    private MeusDadosClienteFragment meusDadosClienteFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_cliente);


        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.nav_cliente);

        escanearQrCodeFragment = new EscanearQrCodeFragment();
        meusDadosClienteFragment = new MeusDadosClienteFragment();
        setFragment(escanearQrCodeFragment);

        mFrameCliente = (FrameLayout) findViewById(R.id.frame_cliente);
        mNavCliente = (BottomNavigationView) findViewById(R.id.nav_cliente);

        mNavCliente.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.nav_qr_code:
                        setFragment(escanearQrCodeFragment);
                        return true;

                    case R.id.nav_meus_dados:
                        setFragment(meusDadosClienteFragment);
                        return true;

                    default:
                        return false;
                }
            }
        });
    }

    private void setFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frame_cliente, fragment);
        fragmentTransaction.commit();
    }


    //menu da action bar (sair)
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.global, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.menu_action_bar_sair) {
            exibirConfirmacaoSair();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void exibirConfirmacaoSair() {
        AlertDialog.Builder msgBox = new AlertDialog.Builder(this);
        msgBox.setIcon(android.R.drawable.ic_menu_delete);
        msgBox.setTitle("Sair");
        msgBox.setMessage("Deseja mesmo sair?");
        setBtnPositivoSair(msgBox);
        setBtnNegativoSair(msgBox);
        msgBox.show();
    }
    public void setBtnPositivoSair(AlertDialog.Builder msgBox){
        msgBox.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                mAuth.signOut();
                Helper.criarToast(HomeClienteActivity.this,"Até mais");
                FirebaseAuth.getInstance().signOut();
                exibirTelaLogin();
                finish();
            }
        });
    }
    public void setBtnNegativoSair(AlertDialog.Builder msgBox){
        msgBox.setNegativeButton("Não", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            }
        });
    }
    public void exibirTelaLogin(){
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }

    public void exibirTelaLerQrCode(){
        Intent intent = new Intent(this, HomeClienteActivity.class);
        startActivity(intent);
    }
}
