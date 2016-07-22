package br.com.alura.appdaescola.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import br.com.alura.appdaescola.Item_Frequencia;
import br.com.alura.appdaescola.R;
import br.com.alura.appdaescola.Utilidades.ContextoAplicacao;
import br.com.alura.appdaescola.Utilidades.Disciplinas;
import br.com.alura.appdaescola.Utilidades.ItemFrequenciaViewHolder;
import br.com.alura.appdaescola.Utilidades.ItemNotaViewHolder;
import br.com.alura.appdaescola.Utilidades.Item_Nota;

/**
 * Created by Everton on 22/07/2016.
 */
public class ListaDeNotasAdapter extends RecyclerView.Adapter {

    private ArrayList<Disciplinas> ListaDeDisciplina;
    private ContextoAplicacao Contexto;

    public ListaDeNotasAdapter(ContextoAplicacao contexto, ArrayList<Disciplinas> listaDeItensDisciplinas){
        this.ListaDeDisciplina = listaDeItensDisciplinas;
        this.Contexto = contexto;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(Contexto).inflate(R.layout.item_nota, parent, false);
        ItemNotaViewHolder holder = new ItemNotaViewHolder(view);
        return holder;

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {

        ItemNotaViewHolder holder = (ItemNotaViewHolder) viewHolder;

        Disciplinas disciplina = this.ListaDeDisciplina.get(position);
        String notas  = FormataNotas(disciplina.getListaNotas());

        holder.getDisciplina().setText(disciplina.getNome());
        holder.getNotas().setText(notas);
    }

    private String FormataNotas(ArrayList<Item_Nota> listaNotas) {
        String notaFormatada = "";
        for (Item_Nota nota:listaNotas) {
            notaFormatada += nota.getPeriodo() + ": " + nota.getNotaPeriodo() + "    ";
        }

        return notaFormatada;
    }

    @Override
    public int getItemCount() {
        return ListaDeDisciplina.size();
    }

}
