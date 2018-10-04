package br.com.ufrpe.foodguru.estabelecimento.GUI;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import br.com.ufrpe.foodguru.estabelecimento.dominio.MesaLineHolder;
import br.com.ufrpe.foodguru.estabelecimento.dominio.Mesa;

import br.com.ufrpe.foodguru.R;

public class MesaAdapter extends RecyclerView.Adapter<MesaLineHolder> {

    private List<Mesa> mesa;

    public MesaAdapter(ArrayList<Mesa> mesaLista) {
        mesa = mesaLista;

    }

    @Override
    public MesaLineHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return null;/*new MesaLineHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.mesa_list_item, parent, false));*/
    }

    @Override
    public void onBindViewHolder(MesaLineHolder holder, int position) {
        /*
        holder.numero.setText(String.format(Locale.getDefault(), "%s, %d - %s",
                mesa.get(position).getNumero()
        ));
        */

    }
    @Override
    public int getItemCount() {
        return mesa != null ? mesa.size() : 0;
    }


}
