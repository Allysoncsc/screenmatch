package br.com.alura.screenmatch.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Deserializar {
    ObjectMapper mapper = new ObjectMapper();


    public <T> T deserializarJson(String json, Class<T> classe){
        try{
            return mapper.readValue(json,classe);
        }catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
