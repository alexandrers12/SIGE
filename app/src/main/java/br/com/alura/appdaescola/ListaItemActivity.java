package br.com.alura.appdaescola;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

import br.com.alura.appdaescola.Utilidades.Aluno;
import br.com.alura.appdaescola.Utilidades.ContextoAplicacao;

public class ListaItemActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_item);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ContextoAplicacao contextoAplicacao = (ContextoAplicacao)getApplication();

        ArrayList<Item_Frequencia> listaDeAlunosFrequencia = ObtemListaItemFrequencia();

        ListaItemFrequencia listaAdapter = new ListaItemFrequencia(this, listaDeAlunosFrequencia);

        ListView listView = (ListView) findViewById(R.id.list_view_frequencia);

        listView.setAdapter(listaAdapter);
    }

    @NonNull
    private ArrayList<Item_Frequencia> ObtemListaItemFrequencia() {
        ContextoAplicacao contexto = (ContextoAplicacao)getApplication();
        ArrayList<Aluno> listaAlunoDoContexto = contexto.getResponsavelAlunoContexto().getListaDeDependentes();
        ArrayList<Item_Frequencia> listaDeAlunosFrequencia = new ArrayList<Item_Frequencia>();
        Item_Frequencia itemA = new Item_Frequencia("Waltim", "Matematica Discreta", "36");
        Item_Frequencia itemB = new Item_Frequencia("Kaique Pedreiro", "Matemática Discreta", "0");
        Item_Frequencia itemC = new Item_Frequencia("Pablo a Voz Romantica", "Matemática Discreta", "12");

        listaDeAlunosFrequencia.add(itemA);
        listaDeAlunosFrequencia.add(itemB);
        listaDeAlunosFrequencia.add(itemC);
        return listaDeAlunosFrequencia;
    }

}
