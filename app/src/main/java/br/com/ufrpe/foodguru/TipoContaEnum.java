package br.com.ufrpe.foodguru;

public enum TipoContaEnum {
    ESTABELECIMENTO("estabelecimento"), CLIENTE("cliente");
    private String tipo;

    TipoContaEnum(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }
}
