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
        nomeDisciplina.setText(aluno.getListaDeDisciplinas().get(position).getNome());

        ArrayList<Item_Nota> listaDeNotas = aluno.getListaDeDisciplinas().get(position).getListaNotas();
        Item_Nota itemNotaPrimeiro = listaDeNotas.get(0);
        String primeiroPeriodo = FormataNotas(itemNotaPrimeiro.getPeriodo(), itemNotaPrimeiro.getNotaPeriodo());
        Item_Nota itemNotaSegundo = listaDeNotas.get(1);
        String segundoPeriodo = FormataNotas(itemNotaSegundo.getPeriodo(), itemNotaSegundo.getNotaPeriodo());
        Item_Nota itemNotaTerceiro = listaDeNotas.get(2);
        String terceiroPeriodo = FormataNotas(itemNotaTerceiro.getPeriodo(), itemNotaTerceiro.getNotaPeriodo());
        Item_Nota itemNotaQuarto = listaDeNotas.get(3);
        String quartoPeriodo = FormataNotas(itemNotaQuarto.getPeriodo(), itemNotaQuarto.getNotaPeriodo());

        TextView periodoUm = (TextView) convertView.findViewById(R.id.item_nota_primeiro);
        periodoUm.setText(primeiroPeriodo);

        TextView periodoDois = (TextView) convertView.findViewById(R.id.item_nota_segundo);
        periodoDois.setText(segundoPeriodo);

        TextView periodoTres = (TextView) convertView.findViewById(R.id.item_nota_terceiro);
        periodoTres.setText(terceiroPeriodo);

        TextView periodoQuatro = (TextView) convertView.findViewById(R.id.item_nota_quarto);
        periodoQuatro.setText(quartoPeriodo);

        return convertView;
    }

    private String FormataNotas(String periodo, String nota) {
        return periodo + ": " + nota;
    }
}
