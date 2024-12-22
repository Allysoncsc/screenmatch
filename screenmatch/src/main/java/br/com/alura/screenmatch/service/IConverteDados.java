package br.com.alura.screenmatch.service;

public interface IConverteDados {
    //vai retornar algum tipo generico, recebe um tipo generico que será devolvido depois
    <T> T obterDados(String json, Class<T> classe);
}
