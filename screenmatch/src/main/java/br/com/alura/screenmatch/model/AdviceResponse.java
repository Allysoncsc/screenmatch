package br.com.alura.screenmatch.model;


import com.fasterxml.jackson.annotation.JsonProperty;

public class AdviceResponse {
    @JsonProperty("slip")
    private Slip slip;

    // getters e setters
    public Slip getSlip() {
        return slip;
    }

    public void setSlip(Slip slip) {
        this.slip = slip;
    }
}


