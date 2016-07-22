package br.com.alura.appdaescola;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;

import br.com.alura.appdaescola.Utilidades.Aluno;
import br.com.alura.appdaescola.Utilidades.ContextoAplicacao;
import br.com.alura.appdaescola.Utilidades.UsuarioResponsavelLegal;
import br.com.alura.appdaescola.services.AlunoService;
import br.com.alura.appdaescola.services.LoginService;

public class EntrarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entrar);

        Button btnEntrar = (Button) findViewById(R.id.btnEntrarEntrar);
        final EditText edtSenha = (EditText) findViewById(R.id.edtSenhaEntrar);

        btnEntrar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                LoginService loginService = new LoginService() {
                    @Override
                    public void preencherDados(String response) {
                        Log.d("resultado primeira requisição", response);
                        if (response.equals("true")){
                            carregarContexto();
                            Intent intent = new Intent(EntrarActivity.this, PrincipalActivity.class);
                            startActivity(intent);
                        }
                    }

                };
                loginService.validarLogin("http://10.0.3.2:8081/aluno/logar/login/senha");
            }
        });
    }

    private void carregarContexto(){

        AlunoService alunoService = new AlunoService() {
            @Override
            public void preencherDados(String response) {
                Log.d("Resultado da segunda requisição", response);
                ContextoAplicacao contexto = (ContextoAplicacao)getApplication();
                UsuarioResponsavelLegal responsavelLegal = ObtemDadosUsusarioResponsavelLogado(response);
                contexto.setResponsavelAlunoContexto(responsavelLegal);
            }
        };
        alunoService.buscarFilhos("http://10.0.3.2:8081/aluno/buscarFilhos/1");
    }

    private UsuarioResponsavelLegal ObtemDadosUsusarioResponsavelLogado(String json) {
        Log.d("Json" , json);
        ArrayList<Aluno> listaDeDependenteAluno = new ArrayList<Aluno>();
        try {
            JSONArray jsonArray = new JSONArray(json);
            Log.d("Array", String.valueOf(jsonArray.length()));

            for (int i = 0; jsonArray.length() > i;i++){
                Log.d("Metodo", "Entrou no metodo");
                Aluno aluno = new Aluno();
                aluno.popularAluno(jsonArray.getJSONObject(i));
                listaDeDependenteAluno.add(aluno);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return new UsuarioResponsavelLegal("Judith", listaDeDependenteAluno);
    }

}
