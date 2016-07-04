package br.com.alura.appdaescola.Utilidades;

import android.media.Image;

import java.util.ArrayList;

/**
 * Created by Everton on 26/06/2016.
 */
public class UsuarioResponsavelLegal {

    private String nome;

    private ArrayList<Aluno> listaDeDependentes;

    public UsuarioResponsavelLegal(String Nome, ArrayList<Aluno> ListaAlunoDependente){
        this.nome = Nome;
        this.listaDeDependentes = ListaAlunoDependente;
    }

    public ArrayList<Aluno> getListaDeDependentes() {
        return listaDeDependentes;
    }

    public String getNome() {
        return nome;
    }



}
