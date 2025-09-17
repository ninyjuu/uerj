import java.time.LocalDate;

public class Pessoa {
    String nome;
    String sobrenome;
    LocalDate data;
    float peso;
    float altura;
    String genero;

    public Pessoa(String nome, String sobrenome, LocalDate data, float peso, float altura, String genero) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.data = data;
        this.peso = peso;
        this.altura = altura;
        this.genero = genero;
    }

    public void mostrar() {
        System.out.println("Nome: " + this.nome + " " + this.sobrenome);
        System.out.println("Data de Nascimento: " + this.data);
        System.out.println("Peso: " + this.peso + " kg");
        System.out.println("Altura: " + this.altura + " m");
        System.out.println("Gênero: " + this.genero);
    }

    public static void main(String[] args) {
        Pessoa novaPessoa = new Pessoa("Ana", "Silva", LocalDate.of(1995, 8, 20), 65.5f, 1.70f, "Feminino");
        novaPessoa.mostrar();
    }
}
