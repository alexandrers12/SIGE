package br.com.alura.appdaescola.services;

import android.os.AsyncTask;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

/**
 * Created by Pablo Henrique on 22/07/2016.
 */
public abstract class AlunoService {

    public void buscarFilhos(final String urlWebServices){
        AsyncTask<Void, Void, String> async = new AsyncTask<Void, Void, String>() {
            @Override
            protected String doInBackground(Void... params) {
                URL url = null;
                Scanner scanner = null;

                try {
                    url = new URL(urlWebServices);
                    HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                    InputStream is = connection.getInputStream();
                    scanner = new Scanner(is);
                    StringBuilder stringBuilder = new StringBuilder(is.available());
                    while (scanner.hasNext()){
                        stringBuilder.append(scanner.nextLine());
                    }

                    String response = stringBuilder.toString();
                    return response;

                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }finally {
                    if (scanner!=null){
                        scanner.close();
                    }
                }

                return null;
            }

            @Override
            protected void onPostExecute(String response) {
                preencherDados(response);
            }

        }.execute();
    }

    public abstract void preencherDados(String response);
}
