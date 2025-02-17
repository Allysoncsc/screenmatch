package br.com.alura.screenmatch.service;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import java.io.IOException;

public class ConsumoApiOk {


    public String requisicaoOkGet(String url) {
        OkHttpClient client = new OkHttpClient();

            Request request = new Request.Builder()
                    .url(url)
                    .build();

            try (Response response = client.newCall(request).execute()) {
                return response.body().string();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
}
