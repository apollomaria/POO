package br.com.NexusCloud.main;

import br.com.NexusCloud.exception.CapacidadeExcedidaException;
import br.com.NexusCloud.model.Cliente;
import br.com.NexusCloud.model.CloudManager;
import br.com.NexusCloud.model.Container;
import br.com.NexusCloud.model.Servidor;

public class MainCloud {
    public static void main(String[] args) {
     
        CloudManager cloudManager = new CloudManager();
        Cliente c1 = new Cliente("111.222.333-44", "Wayne Enterprises");
        Servidor s1 = new Servidor("192.168.0.1", 5.5, 16);

        cloudManager.registrarCliente(c1);
        cloudManager.provisionarServidor(c1, s1);

        Container con1 = new Container("C-01", 10);
        Container con2 = new Container("C-02", 8);

        // s1.alocarContainer(con1);

        try {
            s1.ligar();
            s1.alocarContainer(con1);
            s1.alocarContainer(con2);
        } catch (CapacidadeExcedidaException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Valor da Fatura do Cliente: R$" + cloudManager.calcularFaturaAtiva(c1));
    }
}
