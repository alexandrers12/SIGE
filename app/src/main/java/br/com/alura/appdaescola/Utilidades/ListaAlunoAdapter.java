package br.com.alura.appdaescola.Utilidades;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import br.com.alura.appdaescola.R;

/**
 * Created by Everton on 19/07/2016.
 */
public class ListaAlunoAdapter extends ArrayAdapter<Aluno> {

    private Context contexto;
    private ArrayList<Aluno> ListaDeAluno;


    public ListaAlunoAdapter(Context context, ArrayList<Aluno> listaDeAluno){
        super(context, 0, listaDeAluno);
        this.contexto = context;
        this.ListaDeAluno = listaDeAluno;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Aluno alunoPosicao = this.ListaDeAluno.get(position);

        convertView = LayoutInflater.from(this.contexto).inflate(R.layout.item_aluno, null);

        TextView nomeAlunoText = (TextView)convertView.findViewById(R.id.item_aluno_nome);
        nomeAlunoText.setText(alunoPosicao.getNome());

        TextView serieAlunoText = (TextView)convertView.findViewById(R.id.item_aluno_serie);
        serieAlunoText.setText(alunoPosicao.getSerie());

        return convertView;
    }
}
