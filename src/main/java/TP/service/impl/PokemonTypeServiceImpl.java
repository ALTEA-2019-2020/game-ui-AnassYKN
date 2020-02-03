package TP.service.impl;

import TP.bo.PokemonType;
import TP.service.PokemonTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class PokemonTypeServiceImpl implements PokemonTypeService {

    RestTemplate restTemplate;
    String url="https://pokemon-type-api-anassykn.herokuapp.com/";


    public List<PokemonType> listPokemonsTypes() {
        PokemonType[] listPokemon = this.restTemplate.getForObject(url+"pokemon-types/", PokemonType[].class);
        return List.of(listPokemon);
    }

    public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate=restTemplate;
    }

    public void setPokemonTypeServiceUrl(String pokemonServiceUrl) {
        restTemplate.getForObject(pokemonServiceUrl,String.class);
    }
}
