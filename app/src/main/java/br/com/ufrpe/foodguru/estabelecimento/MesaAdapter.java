package br.com.ufrpe.foodguru.estabelecimento;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import br.com.ufrpe.foodguru.R;
import br.com.ufrpe.foodguru.estabelecimento.dominio.Mesa;

public class MesaAdapter extends RecyclerView.Adapter<MesaHolder> {

    private List<Mesa> mesas;

    public MesaAdapter(List<Mesa> livros) {
        this.mesas = livros;
    }

    @Override
    public MesaHolder onCreateViewHolder(ViewGroup parent,
                                         int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.mesa_list_item, parent, false);

        MesaHolder holder = new MesaHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(MesaHolder holder, int position) {
        holder.numero.setText(printMesaTela(mesas.get(position)));

    }


    @Override
    public int getItemCount() {
        return mesas.size();
    }

    public StringBuilder printMesaTela(Mesa mesa){
        StringBuilder  mesas = new StringBuilder();
        mesas.append("Mesa ");
        mesas.append(Integer.toString(mesa.getNumero()));
        return mesas;
    }


}
