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
        super(Contexto, 0, AlunoAtual.getListaDeDisciplinas().get(0).getListaNotas());
        this.contexto = Contexto;
        this.aluno = AlunoAtual;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        //Item_Nota itemNota = this.listaDeItenNota.get(position);

        convertView = LayoutInflater.from(this.contexto).inflate(R.layout.item_nota, null);

        TextView nomeDisciplina = (TextView) convertView.findViewById(R.id.item_nota_nome_disciplina);
        nomeDisciplina.setText(aluno.getListaDeDisciplinas().get(0).getNome());

        String notaFormatadaParaImpressao = FormataNotas(aluno.getListaDeDisciplinas().get(0).getListaNotas());

        TextView periodo = (TextView) convertView.findViewById(R.id.item_nota_notas);
        periodo.setText(notaFormatadaParaImpressao);

        return convertView;
    }

    private String FormataNotas(ArrayList<Item_Nota> listaNotas) {
        String notaFormatada = "";
        for (Item_Nota nota:listaNotas) {
            notaFormatada += nota.getPeriodo() + ": " + nota.getNotaPeriodo() + "   ";
        }

        return notaFormatada;
    }
}
