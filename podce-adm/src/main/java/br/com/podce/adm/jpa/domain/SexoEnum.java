package br.com.podce.adm.jpa.domain;

import java.util.ArrayList;
import java.util.List;

public enum SexoEnum {

    M("M", "Masculino"),
    F("F", "Feminino");

    private final String tipo;
    private final String texto;

    private SexoEnum( String tipo, String texto) {
        this.tipo = tipo;
        this.texto = texto;
    }

    public String getTipo() {
        return tipo;
    }

    public String getTexto() {
        return texto;
    }
}
