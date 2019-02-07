package br.com.podce.adm.jpa.domain;

public enum TipoCadastroEnum {

    U("U", "Usuário normal"),
    P("P", "Prestador de Serviço"),
    UP("UP","Usuario completo");

    private final String tipo;
    private final String texto;

    private TipoCadastroEnum( String tipo, String texto) {
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
