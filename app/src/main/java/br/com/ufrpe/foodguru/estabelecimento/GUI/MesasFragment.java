package br.com.ufrpe.foodguru.estabelecimento.GUI;


import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import br.com.ufrpe.foodguru.R;
import br.com.ufrpe.foodguru.cliente.GUI.AdicionarMesaActivity;
import br.com.ufrpe.foodguru.cliente.GUI.EditarDadosClienteActivity;
import br.com.ufrpe.foodguru.estabelecimento.dominio.Mesa;

/**
 * A simple {@link Fragment} subclass.
 */
public class MesasFragment extends Fragment implements View.OnClickListener {

    private RecyclerView mRecyclerView;
    private Context context;
    private ProgressDialog progressDialog;
    private View viewInflado;
    private MesaAdapter mAdapter;

    public MesasFragment() {

    }

    public MesasFragment(HomeEstabelecimentoActivity homeEstabelecimentoActivity) {

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        viewInflado = inflater.inflate(R.layout.fragment_mesas, container, false);
        setClicks();
        return viewInflado;
    }

    private void setClicks(){
        viewInflado.findViewById(R.id.fabAdicionarMesa).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.fabAdicionarMesa:{
                abrirTelaCriarMesa();
                break;
            }
        }
    }

    public void abrirTelaCriarMesa() {
        Intent intent = new Intent(viewInflado.getContext(), AdicionarMesaActivity.class);
        startActivity(intent);
    }
}
