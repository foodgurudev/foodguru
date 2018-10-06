package br.com.ufrpe.foodguru.estabelecimento.dominio;

public class Mesa {
    private String numeroMesa;
    private String codigoMesa;

    public Mesa(String numeroMesa, String codigoMesa) {
        this.numeroMesa = numeroMesa;
        this.codigoMesa = codigoMesa;
    }

    public String getNumeroMesa() {
        return numeroMesa;
    }

    public void setNumeroMesa(String numeroMesa) {
        this.numeroMesa = numeroMesa;
    }

    public String getCodigoMesa() {
        return codigoMesa;
    }

    public void setCodigoMesa(String codigoMesa) {
        this.codigoMesa = codigoMesa;
    }

}
