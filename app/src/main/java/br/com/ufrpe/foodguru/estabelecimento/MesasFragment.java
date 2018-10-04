package br.com.ufrpe.foodguru.estabelecimento;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import br.com.ufrpe.foodguru.R;
import br.com.ufrpe.foodguru.estabelecimento.dominio.Mesa;

/**
 * A simple {@link Fragment} subclass.
 */
public class MesasFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private Context context;

    private MesaAdapter mAdapter;

    public MesasFragment(Context context) {
        // Required empty public constructor
        this.context = context;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        setupRecycler();
        return inflater.inflate(R.layout.fragment_mesas, container, false);
    }

    private void setupRecycler() {

        LinearLayoutManager layoutManager = new LinearLayoutManager(context);
        mRecyclerView.setLayoutManager(layoutManager);

        ArrayList<Mesa> mesaLista = new ArrayList();
        mAdapter = new MesaAdapter(mesaLista);
        mRecyclerView.setAdapter(mAdapter);
    }



}
