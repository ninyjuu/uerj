package lp2g13.bib;

import java.util.GregorianCalendar;
import java.io.Serializable;

public class Mulher extends PessoaIMC {
    private String tipoCabelo;

    public Mulher(String nome, String sobreNome, GregorianCalendar dataNasc, long numCPF, double peso, double altura, String tipoCabelo) {
        super(nome, sobreNome, dataNasc, numCPF, peso, altura);
        this.tipoCabelo = tipoCabelo;
    }

    public Mulher(String nome, String sobreNome) {
        super(nome, sobreNome);
        this.tipoCabelo = "não informado";
    }

    public String resultIMC() {
        double imc = calculaIMC();
        if (imc < 19.0) return "abaixo do peso ideal";
        else if (imc <= 25.8) return "peso ideal";
        else return "acima do peso ideal";
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
        return "gênero: feminino\n" + super.toString() + "\ntipo cabelo: " + this.tipoCabelo;
    }
}