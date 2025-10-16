package modelo;
import java.util.Scanner;
import java.util.GregorianCalendar;
import java.util.Calendar;

public class Pessoa {
    private String nome;
    private String sobreNome;
    private GregorianCalendar dataNasc;
    private long numCPF;
    private float peso;
    private float altura;
    private static int contador;

    public Pessoa(String nome, String sobreNome, GregorianCalendar dataNasc, long numCPF, float peso, float altura) {
        this.nome = nome;
        this.sobreNome = sobreNome;
        this.dataNasc = dataNasc;
        this.numCPF = numCPF;
        this.peso = peso;
        this.altura = altura;
    }

    public void lerDados() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("nome: ");
        setNome(scanner.nextLine());
        System.out.println("sobrenome: ");
        setSobreNome(scanner.nextLine());
        System.out.println("nascimento (dd/mm/aaaa): ");
        setDataNasc(scanner.nextLine());
        System.out.println("CPF: ");
        setNumCPF(scanner.nextLine());
        System.out.println("peso: ");
        setPeso(Float.parseFloat(scanner.nextLine()));
        System.out.println("altura: ");
        setAltura(Float.parseFloat(scanner.nextLine()));
        scanner.close();
        Pessoa.numPessoas(this);
    }

    public void setNome(String nome) {
        if (nome.length() > 0) {
            this.nome = nome;
        } else {
            System.out.println("nome invalido");
        }
    }

    public String getNome() {
        return nome;
    }

    public void setSobreNome(String sobreNome) {
        if (sobreNome.length() > 0) {
            this.sobreNome = sobreNome;
        } else {
            System.out.println("sobrenome invalido");
        }
    }

    public String getSobreNome() {
        return sobreNome;
    }

    public void setDataNasc(String dataNasc) {
        String[] partes = dataNasc.trim().split("/");
        int dia = Integer.parseInt(partes[0]);
        int mes = Integer.parseInt(partes[1]) - 1;
        int ano = Integer.parseInt(partes[2]);
        if (dia >= 1 && dia <= 31 && mes >= 0 && mes <= 11 && ano >= 1900 && ano <= 2025) {
            this.dataNasc = new GregorianCalendar(ano, mes, dia);
        } else {
            System.out.println("nascimento invalido");
        }
    }

    public GregorianCalendar getDataNasc() {
        return dataNasc;
    }

    public void setNumCPF(String numCPF) {
        try {
            long cpf = Long.parseLong(numCPF);
            if (numCPF.length() == 11) {
                this.numCPF = cpf;
            } else {
                System.out.println("cpf invalido");
            }
        } catch (NumberFormatException e) {
            System.out.println("cpf invalido");
        }
    }

    public long getNumCPF() {
        return numCPF;
    }

    public void setPeso(float peso) {
        if (peso >= 1.0 && peso <= 300.0) {
            this.peso = peso;
        } else {
            System.out.println("peso invalido");
        }
    }

    public float getPeso() {
        return peso;
    }

    public void setAltura(float altura) {
        if (altura >= 1.0 && altura <= 2.2) {
            this.altura = altura;
        } else {
            System.out.println("altura invalida");
        }
    }

    public float getAltura() {
        return altura;
    }

    public static void numPessoas(Pessoa pessoa) {
        if (pessoa.nome != null && pessoa.sobreNome != null && pessoa.dataNasc != null
        && pessoa.numCPF != 0 && pessoa.peso != 0 && pessoa.altura != 0) {
            contador++;
        }
    }

    public static int getNumPessoas() {
        return contador;
    }

    public int calcularIdade(){
        int idade;
        Calendar hoje= new GregorianCalendar();
        Calendar nascimento= this.dataNasc;
        int mesAtual= hoje.get(Calendar.MONTH);
        int anoAtual= hoje.get(Calendar.YEAR);
        int mesNasc= nascimento.get(Calendar.MONTH);
        int anoNasc= nascimento.get(Calendar.MONTH);
        if (mesNasc > mesAtual){
            idade= anoAtual- anoNasc;
        } else{
            idade= anoAtual- anoNasc- 1;
        }
        return idade;
    }

    public String toString(){
        return "Nome: " + this.nome + this.sobreNome + "\nIdade: " + this.calcularIdade()+
        "\nCPF: " + this.numCPF + "\nPeso: " + this.peso + "\nAltura: " + this.altura;
    }
}
 
