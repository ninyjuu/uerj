import modelo.Pessoa;
import java.util.GregorianCalendar;

public class App {
    public static void main(String[] args) throws Exception {
        Pessoa pessoa = new Pessoa("Celso", "Daniel",new GregorianCalendar(3,3,2025),0,0f,0f);
        pessoa.setNome("Julia");
        System.out.printf("%s\n", pessoa.getNome());
    }
}
