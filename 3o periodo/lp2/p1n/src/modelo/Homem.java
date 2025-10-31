
import java.util.GregorianCalendar;

public class Homem extends Pessoa {
    private boolean reservista;

    public Homem(String nome, String sobreNome, GregorianCalendar dataNasc, long numCPF, float peso, float altura, boolean reservista) {
        super(nome, sobreNome, dataNasc, numCPF, peso, altura);
        this.reservista = reservista;
    }

    public Homem(String nome, String sobreNome) {
        super(nome, sobreNome);
        this.reservista = false; 
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