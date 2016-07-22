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

        ArrayList<Item_Frequencia> listaDeAlunosFrequencia = ObtemListaItemFrequencia();

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler);
        recyclerView.setHasFixedSize(true);

        ListaDeFrequenciaAdapter adapter = new ListaDeFrequenciaAdapter(contextoAplicacao, listaDeAlunosFrequencia);

        RecyclerView.LayoutManager layout = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        recyclerView.setLayoutManager(layout);

        ArrayList<SimpleSectionedRecyclerViewAdapter.Section> sections =
                new ArrayList<SimpleSectionedRecyclerViewAdapter.Section>();

        sections.add(new SimpleSectionedRecyclerViewAdapter.Section(0,"Pablo Pexero"));
        sections.add(new SimpleSectionedRecyclerViewAdapter.Section(3,"Kaique Pedreiro"));

        SimpleSectionedRecyclerViewAdapter.Section[] dummy = new SimpleSectionedRecyclerViewAdapter.Section[sections.size()];
        SimpleSectionedRecyclerViewAdapter mSectionedAdapter = new SimpleSectionedRecyclerViewAdapter(this,R.layout.section,R.id.section_text,adapter);
        mSectionedAdapter.setSections(sections.toArray(dummy));

        recyclerView.setAdapter(mSectionedAdapter);
    }

    @NonNull
    private ArrayList<Item_Frequencia> ObtemListaItemFrequencia() {
        ContextoAplicacao contexto = (ContextoAplicacao)getApplication();
        ArrayList<Aluno> listaAlunoDoContexto = contexto.getResponsavelAlunoContexto().getListaDeDependentes();
        ArrayList<Item_Frequencia> listaDeAlunosFrequencia = new ArrayList<Item_Frequencia>();
        Item_Frequencia itemA = new Item_Frequencia("Matematica Discreta", "36");
        Item_Frequencia itemB = new Item_Frequencia("Sistema Operacional", "0");
        Item_Frequencia itemC = new Item_Frequencia("Persistência (Tio Fábio)", "12");
        Item_Frequencia itemD = new Item_Frequencia("Matematica Discreta", "3");
        Item_Frequencia itemE = new Item_Frequencia("Sistema Operacional", "4");
        Item_Frequencia itemF = new Item_Frequencia("Persistência (Tio Fábio)", "6");

        listaDeAlunosFrequencia.add(itemA);
        listaDeAlunosFrequencia.add(itemB);
        listaDeAlunosFrequencia.add(itemC);
        listaDeAlunosFrequencia.add(itemD);
        listaDeAlunosFrequencia.add(itemE);
        listaDeAlunosFrequencia.add(itemF);
        return listaDeAlunosFrequencia;
    }

}
