package br.com.ZeroTrust.main;

import br.com.ZeroTrust.model.Credencial;
import br.com.ZeroTrust.model.Departamento;
import br.com.ZeroTrust.model.Funcionario;
import br.com.ZeroTrust.model.SistemaSeguranca;
import br.com.ZeroTrust.model.Veiculo;

public class MainTeste {
    public static void main(String[] args) throws Exception {
        Departamento adm = new Departamento("ADM", "Administração", 1);
        Funcionario fun1 = new Funcionario("123", "Apollo", adm);
        Veiculo veiculo = new Veiculo("ABC", "Uno", fun1);

        SistemaSeguranca sistemaSeguranca = new SistemaSeguranca(2);

        Credencial c1 = new Credencial("FFF-999", fun1);
        Credencial clone = new Credencial("FFF-999", fun1);

        sistemaSeguranca.registrarCatraca(fun1);
        sistemaSeguranca.registrarCatraca(fun1);
        
        sistemaSeguranca.acessarCofre(c1);
        sistemaSeguranca.acessarCofre(clone);

        sistemaSeguranca.estacionarVeiculo(veiculo, 0);
        // sistemaSeguranca.estacionarVeiculo(veiculo, 5);
        // Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: Index 5 out of bounds for length 2
    }
}
