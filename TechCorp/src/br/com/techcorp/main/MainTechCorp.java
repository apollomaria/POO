package br.com.techcorp.main;

import br.com.techcorp.model.ControleDeAcesso;
import br.com.techcorp.model.Funcionario;

public class MainTechCorp {
     public static void main(String[] args) {
     
          ControleDeAcesso controleDeAcesso = new ControleDeAcesso(null, null);

          Funcionario f1 = new Funcionario("T-001", "Alice", "Scrum Master");
          Funcionario f2 = new Funcionario("T-001", "Alice Duplicada", "Scrum Master");


          controleDeAcesso.registrarPassagem(f1);
          controleDeAcesso.registrarPassagem(f2);
          
          controleDeAcesso.concederAcessoSala(f1);
          controleDeAcesso.concederAcessoSala(f2);
     
     }
}
