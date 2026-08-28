package br.com.javacommerce.model;

public class FreteMotoboy implements EstrategiaFrete {

    @Override
    public double calcular(double valorPedido) {
        return 15;
    }

    @Override
    public String toString() {
        return "FreteMotoboy []";
    }

    
}
