package br.com.caelum.ingresso.rest;

import java.util.Optional;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import br.com.caelum.ingresso.model.DetalhesDoFilme;
import br.com.caelum.ingresso.model.Filme;

@Component
public class OmdbClient {

	public Optional<DetalhesDoFilme> request(Filme filme) {
        RestTemplate restTemplate = new RestTemplate();

        String nomeFormatoParaNaoTerEspaco = filme.getNome().replace(" ", "+");
        String url = "https://omdb-fj22.herokuapp.com/movie?title=" + nomeFormatoParaNaoTerEspaco;


        try {
            DetalhesDoFilme detalheDoFilme = restTemplate.getForObject(url, DetalhesDoFilme.class);
            return Optional.ofNullable(detalheDoFilme);
        } catch (Exception ex) {
            ex.printStackTrace();
            return Optional.empty();
        }
    }
	
}
