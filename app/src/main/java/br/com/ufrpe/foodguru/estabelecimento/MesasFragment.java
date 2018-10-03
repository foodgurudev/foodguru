package br.com.ufrpe.foodguru.estabelecimento;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
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

    RecyclerView mRecyclerView;

    private MesaAdapter mAdapter;

    public MesasFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_mesas, container, false);
        setupRecycler();
    }

    private void setupRecycler() {

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);

        ArrayList<Mesa> mesaLista = new ArrayList();
        mAdapter = new MesaAdapter(mesaLista);
        mRecyclerView.setAdapter(mAdapter);



}
