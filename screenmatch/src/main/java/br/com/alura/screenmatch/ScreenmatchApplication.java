package br.com.alura.screenmatch;


import br.com.alura.screenmatch.model.AdviceResponse;
import br.com.alura.screenmatch.model.DadosEpisodio;
import br.com.alura.screenmatch.model.DadosSerie;
import br.com.alura.screenmatch.model.DadosTemporada;
import br.com.alura.screenmatch.service.ConsumoApi;
import br.com.alura.screenmatch.service.ConsumoApiOk;
import br.com.alura.screenmatch.service.ConverteDados;
import br.com.alura.screenmatch.service.Deserializar;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class ScreenmatchApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ScreenmatchApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		ConsumoApi consumoApi = new ConsumoApi();

//		var json = consumoApi.obterEndereco("https://www.omdbapi.com/?t=supernatural&apikey=db0d2886");
		//System.out.println(json);

		//json = consumoApi.obterEndereco("https://coffee.alexflipnote.dev/random.json");
		//System.out.println(json);

//		ConverteDados conversor = new ConverteDados();
//		DadosSerie dados = conversor.obterDados(json,DadosSerie.class);
//		System.out.println(dados);

//		json  = consumoApi.obterEndereco("https://www.omdbapi.com/?t=supernatural&season=1&episode=2&apikey=db0d2886");
//		DadosEpisodio dadosEpisodio = conversor.obterDados(json,DadosEpisodio.class);
//
//		System.out.println(dadosEpisodio);
//
//		List<DadosTemporada> temporadas = new ArrayList<>();
//
//		for(int i = 1; i<=dados.totalTemporada();i++){
//			json = consumoApi.obterEndereco("https://www.omdbapi.com/?t=supernatural&season="+i+"&apikey=db0d2886");
//			DadosTemporada dadosTemporada = conversor.obterDados(json,DadosTemporada.class);
//			temporadas.add(dadosTemporada);
//		}
//		temporadas.forEach(System.out::println);


		ConsumoApiOk cao = new ConsumoApiOk();
		var json = cao.requisicaoOkGet("https://api.adviceslip.com/advice");
//		System.out.println(json);
//		Deserializar des = new Deserializar();
//		var advice = des.deserializarJson(json, AdviceResponse.class);
//
//		System.out.println("ID: " + advice.getSlip().getId());
//		System.out.println("Advice: " + advice.getSlip().getAdvice());

		ObjectMapper om = new ObjectMapper();
		JsonNode rootNode = om.readTree(json);
		JsonNode slipNode = rootNode.path("slip");
		int id = slipNode.path("id").asInt();
		String advice = slipNode.path("advice").asText();
		System.out.println("ID: "+id);
		System.out.println("Advice: "+advice);
	}






}
