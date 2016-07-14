package br.com.alura.appdaescola;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

import br.com.alura.appdaescola.Utilidades.Aluno;
import br.com.alura.appdaescola.Utilidades.ContextoAplicacao;
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

        ContextoAplicacao contextoAplicacao = (ContextoAplicacao)getApplication();
        UsuarioResponsavelLegal responsavel = contextoAplicacao.getResponsavelAlunoContexto();
        ArrayList<Aluno> listaAluno = responsavel.getListaDeDependentes();
        Aluno aluno = listaAluno.get(0);

        //No segundo parâmetro desse método está sendo passada a lista de notas do aluno de uma matéria
        //é preciso tratar para pegar da lista de matérias e exibir todas.
        ListaItemNotas listaAdapterNota = new ListaItemNotas(contextoAplicacao, aluno);

        ListView listView = (ListView) findViewById(R.id.list_view_nota);

        listView.setAdapter(listaAdapterNota);
    }

}
