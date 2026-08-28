package br.com.javacommerce.model;

public class FreteSedex implements EstrategiaFrete{

    @Override
    public double calcular(double valorPedido) {
        return valorPedido * 0.1;
    }

}
