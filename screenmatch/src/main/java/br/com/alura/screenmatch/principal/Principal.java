package br.com.alura.screenmatch.principal;


import br.com.alura.screenmatch.service.ConsumoApi;

import java.util.Scanner;

public class Principal {
    private Scanner leitura = new Scanner(System.in);

    ConsumoApi consumoApi = new ConsumoApi();

    private final String ENDERECO= "https://www.omdbapi.com/?t=";

    private final String API_KEY = "&apikey=db0d2886";

    public void exibeMenu() throws Exception {
        System.out.println("Digite o nome da série: ");
        var nomeSerie = leitura.nextLine();

        var json = consumoApi.obterEndereco(ENDERECO+nomeSerie.replace("","+")+API_KEY);
    }
}
