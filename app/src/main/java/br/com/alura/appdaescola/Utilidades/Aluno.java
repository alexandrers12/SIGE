package br.com.alura.appdaescola.Utilidades;

import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Everton on 26/06/2016.
 */
public class Aluno {

    private String nome;

    private String idade;

    private String serie;

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setIdade(String idade) {
        this.idade = idade;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    private int matricula;

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    private ArrayList<Disciplinas> listaDeDisciplinas;

    public String getNome() {
        return nome;
    }

    public void setListaDeDisciplinas(ArrayList<Disciplinas> listaDeDisciplinas) {
        this.listaDeDisciplinas = listaDeDisciplinas;
    }

    public String getIdade() {
        return idade;
    }

    public String getSerie() {
        return serie;
    }

    public ArrayList<Disciplinas> getListaDeDisciplinas() {
        return listaDeDisciplinas;
    }

    public Aluno popularAluno(String json) {
        try {
            JSONObject jsonObject = new JSONObject(json);

            this.nome = jsonObject.getString("nome");
            this.matricula = jsonObject.getInt("matricula");
            this.serie = jsonObject.getString("serie");

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return this;
    }

    public Aluno popularAluno(JSONObject json) {
        try {
            this.nome       = json.getString("nome");
            this.matricula  = json.getInt("matricula");
            this.serie      = json.getString("serie");

            Log.d("Nome", this.nome);
            Log.d("Serie", this.serie);

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return this;
    }
}
