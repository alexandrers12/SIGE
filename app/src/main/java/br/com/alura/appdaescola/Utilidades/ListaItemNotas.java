package br.com.alura.appdaescola.Utilidades;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

import br.com.alura.appdaescola.R;

/**
 * Created by Everton on 29/06/2016.
 */
public class ListaItemNotas extends ArrayAdapter<Item_Nota> {
    private ContextoAplicacao contexto;

    ////Aqui está sendo passado apenas um aluno, é preciso tratar para obter uma possível lista de alunos.
    private Aluno aluno;

    public ListaItemNotas(ContextoAplicacao Contexto, Aluno AlunoAtual) {
        super(Contexto, 0, AlunoAtual.getListaDeDisciplinas().get(1).getListaNotas());
        this.contexto = Contexto;
        this.aluno = AlunoAtual;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        //Item_Nota itemNota = this.listaDeItenNota.get(position);

        convertView = LayoutInflater.from(this.contexto).inflate(R.layout.item_nota, null);

        TextView nomeAluno = (TextView) convertView.findViewById(R.id.item_nota_nome_aluno);
        nomeAluno.setText(aluno.getNome());

        TextView nomeDisciplina = (TextView) convertView.findViewById(R.id.item_nota_nome_disciplina);
        nomeDisciplina.setText(aluno.getListaDeDisciplinas().get(0).getNome());

        TextView periodo = (TextView) convertView.findViewById(R.id.item_nota_periodo);
        periodo.setText(aluno.getListaDeDisciplinas().get(0).getListaNotas().get(0).getPeriodo());

        TextView notaPeriodo = (TextView) convertView.findViewById(R.id.item_nota_nota_periodo);
        notaPeriodo.setText(aluno.getListaDeDisciplinas().get(0).getListaNotas().get(0).getNotaPeriodo());

        return convertView;
    }
}
