package br.com.alura.appdaescola.Utilidades;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import br.com.alura.appdaescola.R;

/**
 * Created by Everton on 22/07/2016.
 */
public class ItemFrequenciaViewHolder extends RecyclerView.ViewHolder  {

    private TextView disciplina;
    private TextView faltas;

    public ItemFrequenciaViewHolder(View view) {
        super(view);
        this.disciplina = (TextView) view.findViewById(R.id.item_frequencia_disciplina);
        this.faltas = (TextView) view.findViewById(R.id.item_frequencia_faltas);
    }

    public TextView getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(TextView disciplina) {
        this.disciplina = disciplina;
    }

    public TextView getFaltas() {
        return faltas;
    }

    public void setFaltas(TextView faltas) {
        this.faltas = faltas;
    }
}
