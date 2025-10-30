package modelo;

import java.util.GregorianCalendar;

public class Mulher extends Pessoa {
    private String tipoCabelo;

    public Mulher(String nome, String sobreNome, GregorianCalendar dataNasc, long numCPF, float peso, float altura, String tipoCabelo) {
        super(nome, sobreNome, dataNasc, numCPF, peso, altura);
        this.tipoCabelo = tipoCabelo;
    }

    public Mulher(String nome, String sobreNome) {
        super(nome, sobreNome);
        this.tipoCabelo = "Não Informado";
    }

    public String getTipoCabelo() {
        return tipoCabelo;
    }

    public void setTipoCabelo(String tipoCabelo) {
        if (tipoCabelo != null && !tipoCabelo.trim().isEmpty()) {
            this.tipoCabelo = tipoCabelo;
        } else {
            System.out.println("tipo de cabelo invalido");
        }
    }

    public String toString() {
        return "Gênero: Feminino\n" + super.toString() + "\nTipo Cabelo: " + this.tipoCabelo;
    }
}