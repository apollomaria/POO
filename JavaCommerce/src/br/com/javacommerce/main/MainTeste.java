package br.com.javacommerce.main;

import br.com.javacommerce.exception.TipoFreteInvalidoException;
import br.com.javacommerce.model.CalculadoraFrete;
import br.com.javacommerce.model.FreteMotoboy;
import br.com.javacommerce.model.FretePac;
import br.com.javacommerce.model.FreteSedex;

public class MainTeste {
    public static void main(String[] args) throws Exception {
        
        CalculadoraFrete calculadoraFrete = new CalculadoraFrete();

        try {
            System.out.println(calculadoraFrete.processarFrete(100, new FreteMotoboy()));
            System.out.println(calculadoraFrete.processarFrete(100, new FretePac()));
            System.out.println(calculadoraFrete.processarFrete(100, new FreteSedex()));
            System.out.println(calculadoraFrete.processarFrete(100, null));
        } catch (TipoFreteInvalidoException e) {
            System.out.println(e.getMessage());
        }

    }
}
