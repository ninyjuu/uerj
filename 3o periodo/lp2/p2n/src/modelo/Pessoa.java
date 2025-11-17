import java.util.GregorianCalendar;
import java.util.Calendar;
import java.util.Scanner;

public class Pessoa {
    private String nome;
    private String sobreNome;
    private GregorianCalendar dataNasc;
    private long numCPF;
    private static int contador;

    public Pessoa(String nome, String sobreNome, GregorianCalendar dataNasc, long numCPF) {
        this.nome = nome;
        this.sobreNome = sobreNome;
        this.dataNasc = dataNasc;
        this.numCPF = numCPF;
        
        Pessoa.numPessoas(this);
    }

    public Pessoa(String nome, String sobreNome) {
        this(nome, sobreNome, null, 0L); 
    }

    public void setNome(String nome) {
        if (nome != null && nome.length() > 0) {
            this.nome = nome;
        } else {
            System.out.println("nome invalido");
        }
    }
    public String getNome() { return nome; }

    public void setSobreNome(String sobreNome) {
        if (sobreNome != null && sobreNome.length() > 0) {
            this.sobreNome = sobreNome;
        } else {
            System.out.println("sobrenome invalido");
        }
    }
    public String getSobreNome() { return sobreNome; }

    public void setDataNasc(String dataNascString) {
        try {
            String[] partes = dataNascString.trim().split("/");
            if (partes.length != 3) {
                 System.out.println("nascimento invalido: formato deve ser dd/mm/aaaa");
                 return;
            }
            
            int dia = Integer.parseInt(partes[0]);
            int mes = Integer.parseInt(partes[1]);
            int ano = Integer.parseInt(partes[2]);
            
            if (ValidaData.validarDataCompleta(dia, mes, ano)) {
                this.dataNasc = new GregorianCalendar(ano, mes - 1, dia);
            } else {
                System.out.println("nascimento invalido: data inconsistente.");
            }
        } catch (Exception e) {
            System.out.println("nascimento invalido: formato ou valor incorreto.");
        }
    }
    public GregorianCalendar getDataNasc() { return dataNasc; }

    public void setNumCPF(String numCPFString) {
        if (ValidaCPF.isCPF(numCPFString)) {
            this.numCPF = ValidaCPF.toLong(numCPFString);
        } else {
            System.out.println("cpf invalido");
        }
    }
    public long getNumCPF() { return numCPF; }

    public static void numPessoas(Pessoa pessoa) {
        if (pessoa != null) { 
            contador++;
        }
    }

    public static int getNumPessoas() { return contador; }

    public int calcularIdade(){
        if (this.dataNasc == null) return -1; 
        
        Calendar hoje = new GregorianCalendar();
        
        int anoAtual = hoje.get(Calendar.YEAR);
        int mesAtual = hoje.get(Calendar.MONTH);
        int diaAtual = hoje.get(Calendar.DAY_OF_MONTH);
        
        int anoNasc = this.dataNasc.get(Calendar.YEAR); 
        int mesNasc = this.dataNasc.get(Calendar.MONTH);
        int diaNasc = this.dataNasc.get(Calendar.DAY_OF_MONTH);
        
        int idade = anoAtual - anoNasc;

        if (mesNasc > mesAtual || (mesNasc == mesAtual && diaNasc > diaAtual)) {
            idade--; 
        }
        
        return idade;
    }

    public String toString(){
        String idadeStr = (this.dataNasc != null) ? String.valueOf(this.calcularIdade()) : "N/A";
        return String.format("nome: %s %s\nidade: %s\nCPF: %s",
            this.nome,
            this.sobreNome,
            idadeStr,
            ValidaCPF.imprimeCPF(String.valueOf(this.numCPF))
        );
    }
}
