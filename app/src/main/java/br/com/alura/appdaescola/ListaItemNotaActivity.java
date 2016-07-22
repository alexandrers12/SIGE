package br.com.alura.appdaescola;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

import br.com.alura.appdaescola.Adapters.ListaDeFrequenciaAdapter;
import br.com.alura.appdaescola.Adapters.ListaDeNotasAdapter;
import br.com.alura.appdaescola.Adapters.SimpleSectionedRecyclerViewAdapter;
import br.com.alura.appdaescola.Utilidades.Aluno;
import br.com.alura.appdaescola.Utilidades.ContextoAplicacao;
import br.com.alura.appdaescola.Utilidades.Disciplinas;
import br.com.alura.appdaescola.Utilidades.Item_Nota;
import br.com.alura.appdaescola.Utilidades.ListaItemNotas;
import br.com.alura.appdaescola.Utilidades.UsuarioResponsavelLegal;

public class ListaItemNotaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_item_nota);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        AdaptaLista();
    }

    private void AdaptaLista() {

        ContextoAplicacao contextoAplicacao = (ContextoAplicacao)getApplication();
        ArrayList<Aluno> listaDeAluno = contextoAplicacao.getResponsavelAlunoContexto().getListaDeDependentes();
        ArrayList<Disciplinas> listaDeDisciplinas = ObtemListaDeDisciplinas(listaDeAluno);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerNota);
        recyclerView.setHasFixedSize(true);

        ListaDeNotasAdapter adapter = new ListaDeNotasAdapter(contextoAplicacao, listaDeDisciplinas);

        RecyclerView.LayoutManager layout = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        recyclerView.setLayoutManager(layout);

        ArrayList<SimpleSectionedRecyclerViewAdapter.Section> sections =
                new ArrayList<SimpleSectionedRecyclerViewAdapter.Section>();

        sections.add(new SimpleSectionedRecyclerViewAdapter.Section(0, listaDeAluno.get(0).getNome()));
        sections.add(new SimpleSectionedRecyclerViewAdapter.Section(7, listaDeAluno.get(1).getNome()));

        /*
        int posicaoHeader = 0;
        for (Aluno aluno: listaDeAluno) {
            int indexDoAluno = listaDeAluno.indexOf(aluno);
            if(indexDoAluno==0){
                sections.add(new SimpleSectionedRecyclerViewAdapter.Section(posicaoHeader, aluno.getNome()));
            }
            else{
                Aluno alunoAnterior = listaDeAluno.get(indexDoAluno-1);
                posicaoHeader+=alunoAnterior.getListaDeDisciplinas().size();
                sections.add(new SimpleSectionedRecyclerViewAdapter.Section(posicaoHeader, aluno.getNome()));
            }
        }
        */

        SimpleSectionedRecyclerViewAdapter.Section[] dummy = new SimpleSectionedRecyclerViewAdapter.Section[sections.size()];
        SimpleSectionedRecyclerViewAdapter mSectionedAdapter = new SimpleSectionedRecyclerViewAdapter(this,R.layout.section,R.id.section_text,adapter);
        mSectionedAdapter.setSections(sections.toArray(dummy));

        recyclerView.setAdapter(mSectionedAdapter);
    }

    private ArrayList<Disciplinas> ObtemListaDeDisciplinas(ArrayList<Aluno> listaDeDependentes) {
        ArrayList<Disciplinas> listaDeDisciplina = new ArrayList<Disciplinas>();

        for (Aluno aluno: listaDeDependentes) {
            for (Disciplinas disciplina: aluno.getListaDeDisciplinas()) {
                listaDeDisciplina.add(disciplina);
            }
        }

        return listaDeDisciplina;
    }

}
