package br.com.javacommerce.model;

import br.com.javacommerce.exception.TipoFreteInvalidoException;

public class CalculadoraFrete {

    public double processarFrete(double valorPedido, EstrategiaFrete estrategiaFrete) throws TipoFreteInvalidoException {

        if (estrategiaFrete == null) {
            throw new TipoFreteInvalidoException();
        }

        return estrategiaFrete.calcular(valorPedido);
    }

}
