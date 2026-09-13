package br.com.fintech.model;

import java.util.HashMap;
import java.util.Map;

public class GatewayPagamentos {
    private Map<String, CarteiraDigital> carteiras = new HashMap<>();

    public GatewayPagamentos() {
    }

    public void cadastrarCarteira(CarteiraDigital carteira) {
        this.carteiras.put(carteira.getCodigoCarteira(), carteira);
        System.out.println("Carteira cadastrada!");
    }

    public String buscarCarteira(String codigoCarteira) {
        return "Carteira recuperada do Gateway: " + codigoCarteira;
    }
}
