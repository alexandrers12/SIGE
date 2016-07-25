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
import br.com.alura.appdaescola.Adapters.SimpleAdapter;
import br.com.alura.appdaescola.Adapters.SimpleSectionedRecyclerViewAdapter;
import br.com.alura.appdaescola.Utilidades.Aluno;
import br.com.alura.appdaescola.Utilidades.ContextoAplicacao;
import br.com.alura.appdaescola.Utilidades.Disciplinas;

public class ListaItemActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_item);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        AdaptaLista();
    }

    private void AdaptaLista() {
        ContextoAplicacao contextoAplicacao = (ContextoAplicacao)getApplication();
        ArrayList<Aluno> listaDeAluno = contextoAplicacao.getResponsavelAlunoContexto().getListaDeDependentes();
        ArrayList<Item_Frequencia> listaDeAlunosFrequencia = ObtemListaItemFrequencia(listaDeAluno);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler);
        recyclerView.setHasFixedSize(true);

        ListaDeFrequenciaAdapter adapter = new ListaDeFrequenciaAdapter(contextoAplicacao, listaDeAlunosFrequencia);

        RecyclerView.LayoutManager layout = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        recyclerView.setLayoutManager(layout);

        ArrayList<SimpleSectionedRecyclerViewAdapter.Section> sections =
                new ArrayList<SimpleSectionedRecyclerViewAdapter.Section>();

        sections.add(new SimpleSectionedRecyclerViewAdapter.Section(0,listaDeAluno.get(0).getNome()));
        sections.add(new SimpleSectionedRecyclerViewAdapter.Section(7,listaDeAluno.get(1).getNome()));

        SimpleSectionedRecyclerViewAdapter.Section[] dummy = new SimpleSectionedRecyclerViewAdapter.Section[sections.size()];
        SimpleSectionedRecyclerViewAdapter mSectionedAdapter = new SimpleSectionedRecyclerViewAdapter(this,R.layout.section,R.id.section_text,adapter);
        mSectionedAdapter.setSections(sections.toArray(dummy));

        recyclerView.setAdapter(mSectionedAdapter);
    }

    @NonNull
    private ArrayList<Item_Frequencia> ObtemListaItemFrequencia(ArrayList<Aluno> listaAlunoDoContexto) {
        ArrayList<Item_Frequencia> listaDeAlunosFrequencia = new ArrayList<Item_Frequencia>();

        for (Aluno aluno: listaAlunoDoContexto) {
            for (Disciplinas disciplina: aluno.getListaDeDisciplinas()) {

                Item_Frequencia item = new Item_Frequencia(disciplina.getNome(), disciplina.getFaltas());
                listaDeAlunosFrequencia.add(item);
            }
        }

        return listaDeAlunosFrequencia;
    }
}
