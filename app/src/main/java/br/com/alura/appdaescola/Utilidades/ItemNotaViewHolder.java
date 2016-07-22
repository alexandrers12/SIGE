package br.com.alura.appdaescola.Utilidades;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import br.com.alura.appdaescola.R;

/**
 * Created by Everton on 22/07/2016.
 */
public class ItemNotaViewHolder extends RecyclerView.ViewHolder {

    private TextView disciplina;
    private TextView notas;

    public ItemNotaViewHolder(View view) {
        super(view);
        this.disciplina = (TextView) view.findViewById(R.id.item_nota_nome_disciplina);
        this.notas = (TextView) view.findViewById(R.id.item_nota_notas);
    }

    public TextView getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(TextView disciplina) {
        this.disciplina = disciplina;
    }

    public TextView getNotas() {
        return notas;
    }

    public void setNotas(TextView notas) {
        this.notas = notas;
    }
}
