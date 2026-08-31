package br.com.StreamingJava.model;

public class Credencial {
    private String codigoHex;

    public Credencial(String codigoHex) {
        this.codigoHex = codigoHex;
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((codigoHex == null) ? 0 : codigoHex.hashCode());
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
        Credencial other = (Credencial) obj;
        if (codigoHex == null) {
            if (other.codigoHex != null)
                return false;
        } else if (!codigoHex.equals(other.codigoHex))
            return false;
        return true;
    }

    public String getCodigoHex() {
        return codigoHex;
    }

    public void setCodigoHex(String codigoHex) {
        this.codigoHex = codigoHex;
    }

    @Override
    public String toString() {
        return "[" + codigoHex + "]";
    }

    
}
