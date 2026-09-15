package br.com.FinTech2.model;

public class Transacao {
    private String idTransacao;
    private String tipo;
    private double valor;
    private double tarifa;
    
    public Transacao(String idTransacao, String tipo, double valor, double tarifa) {
        if (idTransacao == null || idTransacao.trim().isEmpty()) {
            throw new IllegalArgumentException("ID de transacao nao pode ser nulo ou vazio.");
        }
        
        this.idTransacao = idTransacao;
        this.tipo = tipo;
        this.valor = valor;
        this.tarifa = tarifa;
    }

    public String getIdTransacao() {
        return idTransacao;
    }

    public String getTipo() {
        return tipo;
    }

    public double getValor() {
        return valor;
    }

    public double getTarifa() {
        return tarifa;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public void setTarifa(double tarifa) {
        this.tarifa = tarifa;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((idTransacao == null) ? 0 : idTransacao.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Transacao other = (Transacao) obj;
        if (idTransacao == null) {
            if (other.idTransacao != null)
                return false;
        } else if (!idTransacao.equals(other.idTransacao))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Transacao [idTransacao=" + idTransacao + ", tipo=" + tipo + ", valor=R$" + valor + ", tarifa=R$" + tarifa
                + "]";
    }


}
