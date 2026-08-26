// NÍVEL 3 ---------------------------------------------------------------------------------
// EXERCÍCIO 9
package br.com.nexustech.model;

import br.com.nexustech.exception.NivelInsuficienteException;

public class Masmorra {
    public void entrar(int nivelJogador) throws Exception {
        if (nivelJogador < 50) {
            throw new NivelInsuficienteException();
        }
    }
}
