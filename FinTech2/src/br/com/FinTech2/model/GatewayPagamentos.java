package br.com.FinTech2.model;

import java.util.HashMap;
import java.util.Map;

public class GatewayPagamentos {
    private final Map<String, CarteiraDigital> carteiras;

    public GatewayPagamentos() {
        this.carteiras = new HashMap<>();
    }

    
    public void cadastrarCarteira(CarteiraDigital carteira) {
        this.carteiras.put(carteira.getCodigoCarteira(), carteira);
        System.out.println("Carteira " + carteiras.get(carteira.getCodigoCarteira()) + " cadastrada com sucesso!");
    }

    public CarteiraDigital buscarCarteira(String codigoCarteira) {
        return this.carteiras.get(codigoCarteira);
    }

}
