package lp2g13.bib;

import java.util.GregorianCalendar;
import java.io.Serializable;

public class Homem extends PessoaIMC {
    private boolean reservista;

    public Homem(String nome, String sobreNome, GregorianCalendar dataNasc, long numCPF, double peso, double altura, boolean reservista) {
        super(nome, sobreNome, dataNasc, numCPF, peso, altura);
        this.reservista = reservista;
    }

    public Homem(String nome, String sobreNome) {
        super(nome, sobreNome);
        this.reservista = false; 
    }

    public String resultIMC() {
        double imc = calculaIMC();
        if (imc < 20.7) return "abaixo do peso ideal"; 
        else if (imc <= 26.4) return "peso ideal";
        else return "acima do peso ideal";
    }

    public boolean isReservista() {
        return reservista;
    }

    public void setReservista(boolean reservista) {
        this.reservista = reservista;
    }

    public String toString() {
        return "Gênero: Masculino\n" + super.toString() + String.format("\nReservista: %s", (this.reservista ? "Sim" : "Não"));
    }
}