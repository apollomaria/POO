package br.com.meusistema.main;

// OLHE O IMPORT AQUI! O Sistema precisa avisar que vai usar 
// o Carro do outro "bairro". 
import br.com.meusistema.model.Carro;

public class Sistema {
    public static void main(String[] args) {
        System.out.println("Iniciando o sistema...");

        // Criando o objeto (Construindo o Carro 1)
        Carro meuCarro = new Carro();
        meuCarro.setModelo("Fusca");
        meuCarro.setCor("Azul");

        // Chamando o método (Comportamento)
        meuCarro.buzinar();

        // Desafio Rápido: Crie um "Carro 2", de outro modelo e cor, e faça ele buzinar
        // também!
        Carro outroCarro = new Carro();
        outroCarro.setModelo("Uno");
        outroCarro.setCor("Vermelho");
        outroCarro.buzinar();

        meuCarro.setVelocidade(-500); // Tentando hackear novamente

        // meuCarro.velocidade = -500;
        // Pense: Existe um carro que ande a "menos 500 km/h"? Não! Como deixamos a
        // variável `public` (pública), qualquer um pode inserir dados absurdos no nosso
        // sistema e quebrar a nossa lógica.
    }
}