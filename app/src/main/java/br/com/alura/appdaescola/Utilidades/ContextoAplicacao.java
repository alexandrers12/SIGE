package br.com.alura.appdaescola.Utilidades;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

/**
 * Created by Everton on 29/06/2016.
 */
public class ContextoAplicacao extends Application {

    private UsuarioResponsavelLegal ResponsavelAlunoContexto;

    public UsuarioResponsavelLegal getResponsavelAlunoContexto() {
        return ResponsavelAlunoContexto;
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    public void setResponsavelAlunoContexto(UsuarioResponsavelLegal responsavelAlunoContexto) {
        ResponsavelAlunoContexto = responsavelAlunoContexto;
    }
}
