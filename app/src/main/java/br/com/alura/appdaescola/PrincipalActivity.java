package br.com.alura.appdaescola;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.ArrayList;

import br.com.alura.appdaescola.Utilidades.Aluno;
import br.com.alura.appdaescola.Utilidades.ContextoAplicacao;
import br.com.alura.appdaescola.Utilidades.Disciplinas;
import br.com.alura.appdaescola.Utilidades.Item_Nota;
import br.com.alura.appdaescola.Utilidades.ListaAlunoAdapter;

public class PrincipalActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        ContextoAplicacao contextoAplicacao = (ContextoAplicacao)getApplication();
        ArrayList<Aluno> listaDeAluno = contextoAplicacao.getResponsavelAlunoContexto().getListaDeDependentes();

        ListaAlunoAdapter listaAdapter = new ListaAlunoAdapter(this, listaDeAluno);
        ListView listView = (ListView)findViewById(R.id.content_principal_listView);

        listView.setAdapter(listaAdapter);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.principal, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        CarregaDisciplinasNoContextoDaAplicacao();

        if (id == R.id.nav_notas) {
            Intent intentVaiPraNota = new Intent(this, ListaItemNotaActivity.class);
            startActivity(intentVaiPraNota);
        } else if (id == R.id.nav_faltas) {
            Intent intentVaiParaFrequencia = new Intent(this, ListaItemActivity.class);
            startActivity(intentVaiParaFrequencia);
        } else if (id == R.id.nav_taxas) {
            //TODO: Implementar rotina para consultar taxas escolares.
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void CarregaDisciplinasNoContextoDaAplicacao() {
        ContextoAplicacao contextoAplicacao = (ContextoAplicacao)getApplication();
        ArrayList<Aluno> listaAluno = contextoAplicacao.getResponsavelAlunoContexto().getListaDeDependentes();

        Boolean estaConectadoNaInternet = VerificaConexao();
        Boolean alunosTemDisciplinasEmCache = VerificaSeAlunosTemDisciplinasEmCache(listaAluno);

        if(!alunosTemDisciplinasEmCache && !estaConectadoNaInternet){
            //TODO: Sobe mensagem de erro indicando que não foi possível
            //obter as notas dos alunos porque não tem conexão com a internet.
            //Descobrir como fazer isso...
        }
        else if(estaConectadoNaInternet){
            //TODO: PABLO Serviço carrega ou atualiza os alunos da listaDeAluno com as notas.
            CarregaListaDeDisciplinas(listaAluno);
        }
    }

    private void CarregaListaDeDisciplinas(ArrayList<Aluno> listaAluno) {
        //Pablo, vou criar a disciplina manualmente para teste. Carregue através do serviço.
        ArrayList<Item_Nota> listaDeNotas = new ArrayList<Item_Nota>();
        Item_Nota primeiroBimestre = new Item_Nota("1° bimestre", "8.0");
        listaDeNotas.add(primeiroBimestre);
        Item_Nota segundoBimestre = new Item_Nota("2° bimestre", "7.0");
        listaDeNotas.add(segundoBimestre);
        Item_Nota terceiroBimestre = new Item_Nota("3° bimestre", "6.0");
        listaDeNotas.add(terceiroBimestre);
        Item_Nota quartoBimestre = new Item_Nota("4° bimestre", "6.0");
        listaDeNotas.add(quartoBimestre);

        Disciplinas matematica = new Disciplinas("Matematica", listaDeNotas, "4");
        Disciplinas portugues = new Disciplinas("Português", listaDeNotas, "12");
        Disciplinas geografia = new Disciplinas("Geografia", listaDeNotas, "12");
        Disciplinas historia = new Disciplinas("História", listaDeNotas, "12");
        Disciplinas ingles = new Disciplinas("Inglês", listaDeNotas, "12");
        Disciplinas ensinoReligioso = new Disciplinas("Ensino Religioso", listaDeNotas, "12");
        Disciplinas educacaoFisica = new Disciplinas("Educação Física", listaDeNotas, "12");
        ArrayList<Disciplinas> listaDeDisciplinas = new ArrayList<Disciplinas>();
        listaDeDisciplinas.add(matematica);
        listaDeDisciplinas.add(portugues);
        listaDeDisciplinas.add(geografia);
        listaDeDisciplinas.add(historia);
        listaDeDisciplinas.add(ingles);
        listaDeDisciplinas.add(ensinoReligioso);
        listaDeDisciplinas.add(educacaoFisica);

        for (Aluno aluno: listaAluno) {
            aluno.setListaDeDisciplinas(listaDeDisciplinas);
        }
    }

    private Boolean VerificaSeAlunosTemDisciplinasEmCache(ArrayList<Aluno> listaAluno) {

        for (Aluno aluno: listaAluno) {
            ArrayList<Disciplinas> listaDisciplinas = aluno.getListaDeDisciplinas();
            if(listaDisciplinas != null){
                return true;
            }
        }

        return false;
    }

    public  boolean VerificaConexao() {
        boolean conectado;
        ConnectivityManager conectivtyManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        if (conectivtyManager.getActiveNetworkInfo() != null
                && conectivtyManager.getActiveNetworkInfo().isAvailable()
                && conectivtyManager.getActiveNetworkInfo().isConnected()) {
            conectado = true;
        } else {
            conectado = false;
        }
        return conectado;
    }
}
