package br.com.StreamingJava.main;

import br.com.StreamingJava.model.Credencial;
import br.com.StreamingJava.model.Sede;

public class MainSeguranca {
    public static void main(String[] args) {
        Sede sede = new Sede();
        Credencial c1 = new Credencial("ABC");

        sede.registrarPassagemCatraca(c1);
        sede.registrarPassagemCatraca(c1);

        sede.autorizarEntradaCofre(c1);
        sede.autorizarEntradaCofre(c1);

        sede.estacionarVeiculo("XXXX", 0);
        sede.estacionarVeiculo("YYYY", 1);
        sede.estacionarVeiculo("ZZZZ", 2);
        // sede.estacionarVeiculo("AAAA", 3);
        // Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: Index 3 out of bounds for length 3
        // at br.com.StreamingJava.model.Sede.estacionarVeiculo(Sede.java:14)
        // at br.com.StreamingJava.main.MainSeguranca.main(MainSeguranca.java:20)
    }
}
