package br.com.starlog.controller;

import br.com.starlog.model.CriptoMensagem;
import java.util.ArrayList;
import java.util.List;

/**
 * CAMADA CONTROLLER (O Maestro da Transmissão)
 * 
 * ATENÇÃO ESTUDANTE:
 * Implemente esta classe para orquestrar as requisições da View,
 * convertendo os tipos brutos e alimentando o Model!
 * 
 * REGRA DE ARQUITETURA:
 * O Controller manipula lógica e dados, NÃO componentes visuais (zero imports de javax.swing.*)!
 */
public class TransmissaoController {

    private final List<String> bufferTransmissoes = new ArrayList<>();
    private List<String> historicoDisparos = new ArrayList<>();

    /**
     * Orquestra a transmissão da mensagem.
     * 
     * @param remetenteRaw Remetente vindo do campo de texto da tela
     * @param msgRaw       Mensagem vinda do campo de texto da tela
     * @param chaveStr     Chave digitada como texto na tela
     * @return Pacote formatado no padrão: [REMETENTE] #CHECKSUM -> TEXTO_CIFRADO
     */

    public String processarTransmissao(String remetenteRaw, String msgRaw, String chaveString) throws NumberFormatException {
        // TODO: Etapa 3 - Orquestração no Controller
        // 1. Converter chaveStr para inteiro com Integer.parseInt(chaveStr.trim()).
        //    Se falhar (NumberFormatException ou NullPointerException), lance
        //    IllegalArgumentException("Chave deve ser um número inteiro válido.");

        int chaveConvertida;
        try {
            chaveConvertida = Integer.parseInt(chaveString.trim());
        } catch (NumberFormatException | NullPointerException e) {
            throw new IllegalArgumentException("Chave deve ser um número inteiro válido");
        }

        // 2. Instanciar CriptoMensagem passando remetente, mensagem e chave convertida.
        CriptoMensagem criptoMensagem = new CriptoMensagem(remetenteRaw, msgRaw, chaveConvertida);

        // 3. Obter o texto cifrado e o checksum do Model.
        String cifrado = criptoMensagem.cifrar();
        int checksum = criptoMensagem.calcularChecksum();

        // 4. Formatar o pacote: String.format("[%s] #%d -> %s", cripto.getRemetente(), checksum, textoCifrado);
        String pacoteFinal = String.format("[%s] #%d -> %s", remetenteRaw.trim().toUpperCase(), checksum, cifrado.toString());

        // 5. Adicionar o pacote à lista bufferTransmissoes.
        bufferTransmissoes.add(pacoteFinal);

        // 6. Persistência direta em memória acoplada na tela
        historicoDisparos.add(pacoteFinal);

        // 6. Retornar o pacote formatado.
        return pacoteFinal;
    }

    public int getTotalTransmissoes() {
        return bufferTransmissoes.size();
    }
}
