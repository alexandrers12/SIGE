package br.com.alura.appdaescola.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import br.com.alura.appdaescola.Item_Frequencia;
import br.com.alura.appdaescola.R;
import br.com.alura.appdaescola.Utilidades.ContextoAplicacao;
import br.com.alura.appdaescola.Utilidades.ItemFrequenciaViewHolder;
import br.com.alura.appdaescola.Utilidades.ListaAlunoAdapter;

/**
 * Created by Everton on 22/07/2016.
 */
public class ListaDeFrequenciaAdapter extends RecyclerView.Adapter  {

    private ArrayList<Item_Frequencia> ListaDeItensFrequencia;
    private ContextoAplicacao Contexto;

    public ListaDeFrequenciaAdapter(ContextoAplicacao contexto, ArrayList<Item_Frequencia> listaDeItensFrequencia){
        this.ListaDeItensFrequencia = listaDeItensFrequencia;
        this.Contexto = contexto;
    }

    public ArrayList<Item_Frequencia> getListaDeItensFrequencia() {
        return ListaDeItensFrequencia;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(Contexto).inflate(R.layout.item_frequencia, parent, false);
        ItemFrequenciaViewHolder holder = new ItemFrequenciaViewHolder(view);
        return holder;

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {

        ItemFrequenciaViewHolder holder = (ItemFrequenciaViewHolder) viewHolder;

        Item_Frequencia item_frequencia  = this.ListaDeItensFrequencia.get(position) ;

        holder.getDisciplina().setText(item_frequencia.getDisciplaina());
        holder.getFaltas().setText(item_frequencia.getFaltas());
    }

    @Override
    public int getItemCount() {
        return ListaDeItensFrequencia.size();
    }
}
