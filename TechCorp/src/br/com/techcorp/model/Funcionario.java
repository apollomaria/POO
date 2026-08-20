package br.com.techcorp.model;

public class Funcionario {
    private String matricula;
    private String nome;
    private String cargo;

    public Funcionario(String matricula, String nome, String cargo) {
        this.matricula = matricula;
        this.nome = nome;
        this.cargo = cargo;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }




    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((matricula == null) ? 0 : matricula.hashCode());
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
        Funcionario other = (Funcionario) obj;
        if (matricula == null) {
            if (other.matricula != null)
                return false;
        } else if (!matricula.equals(other.matricula))
            return false;
        return true;
    }




    @Override
    public String toString() {
        return "\nIMPRESSÃO DE FUNCIONÁRIO \nMatrícula: " + matricula + ", \nNome: " + nome + ", \nCargo: " + cargo;
    }




}
