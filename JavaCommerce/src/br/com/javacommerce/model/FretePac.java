package br.com.javacommerce.model;

public class FretePac implements EstrategiaFrete{

    @Override
    public double calcular(double valorPedido) {
        return valorPedido * 0.05;
    }

}
