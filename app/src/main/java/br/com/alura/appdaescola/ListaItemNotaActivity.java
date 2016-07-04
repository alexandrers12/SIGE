package br.com.alura.appdaescola;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

import br.com.alura.appdaescola.Utilidades.ContextoAplicacao;
import br.com.alura.appdaescola.Utilidades.Item_Nota;
import br.com.alura.appdaescola.Utilidades.ListaItemNotas;

public class ListaItemNotaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_item_nota);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ContextoAplicacao contextoAplicacao = (ContextoAplicacao) getApplicationContext();

        //No segundo parâmetro desse método está sendo passada a lista de notas do aluno de uma matéria
        //é preciso tratar para pegar da lista de matérias e exibir todas.
        ListaItemNotas listaAdapterNota = new ListaItemNotas(this, contextoAplicacao.getResponsavelAlunoContexto().getListaDeDependentes().get(1));

        ListView listView = (ListView) findViewById(R.id.list_view_nota);

        listView.setAdapter(listaAdapterNota);
    }

}
