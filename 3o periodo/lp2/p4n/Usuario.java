package lp2g13.bib;

import java.util.GregorianCalendar;
import java.util.ArrayList;
import java.io.Serializable;

public class Usuario extends Pessoa implements Serializable {
    
    private String endereco;
    private ArrayList<Emprest> hist; 
    private int numLivrosEmprestados; 

    public Usuario(String nome, String sobreNome, GregorianCalendar dataNasc, long numCPF, String endereco) {
        super(nome, sobreNome, dataNasc, numCPF); 
        this.endereco = endereco;
        this.hist = new ArrayList<>();
        this.numLivrosEmprestados = 0;
    }

    public String getEndereco() { return endereco; }
    public void setEndereco(String endereco) { this.endereco = endereco; }
    public ArrayList<Emprest> getHist() { return hist; }
    public int getNumLivrosEmprestados() { return numLivrosEmprestados; }

    public void addLivroHist(GregorianCalendar dataLocacao, int codLivro) {
        Emprest novoEmprestimo = new Emprest(dataLocacao, codLivro);
        this.hist.add(novoEmprestimo);
        this.numLivrosEmprestados++;
        System.out.println("empréstimo registrado para o livro: " + codLivro);
    }
    
    public void decrementaLivrosAtivos() {
        if (numLivrosEmprestados > 0) {
            this.numLivrosEmprestados--;
        }
    }

    public String toString() {
        String infoPessoa = super.toString();
        
        return String.format("%s\nendereço: %s\nlivros ativos: %d\nhistórico de empréstimos: %d registro(s)",
            infoPessoa,
            this.endereco,
            this.numLivrosEmprestados,
            this.hist.size()
        );
    }
}