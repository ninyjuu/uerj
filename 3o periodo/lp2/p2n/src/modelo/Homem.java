import java.util.GregorianCalendar;

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

    public String resultIMC(){
        float imc = calculaIMC();
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
        return "gênero: masculino\n" + super.toString() + String.format("\nreservista: %s", (this.reservista ? "sim" : "não"));
    }
}
