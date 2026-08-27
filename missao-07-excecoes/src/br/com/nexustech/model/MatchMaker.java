// NÍVEL BOSS ---------------------------------------------------------------------------------
// EXERCÍCIO 13

package br.com.nexustech.model;

import br.com.nexustech.exception.BanidoException;

public class MatchMaker {
    public void encontrarSala(ModoJogo modo, boolean jogadorBanido) throws BanidoException {
        if (jogadorBanido) {
            throw new BanidoException();
        }
        
        modo.buscarPartida();
    }

}
