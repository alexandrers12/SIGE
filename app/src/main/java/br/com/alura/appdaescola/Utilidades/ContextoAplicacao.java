package br.com.alura.appdaescola.Utilidades;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by Everton on 29/06/2016.
 */
public class ContextoAplicacao extends Activity {

    private UsuarioResponsavelLegal ResponsavelAlunoContexto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public UsuarioResponsavelLegal getResponsavelAlunoContexto() {
        return ResponsavelAlunoContexto;
    }

    public void setResponsavelAlunoContexto(UsuarioResponsavelLegal responsavelAlunoContexto) {
        ResponsavelAlunoContexto = responsavelAlunoContexto;
    }
}
