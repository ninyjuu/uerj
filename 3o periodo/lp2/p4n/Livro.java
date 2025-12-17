package lp2g13.bib;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.io.Serializable;

public class Livro implements Serializable {
    
    private int codLivro;
    private String titulo;
    private String categoria;
    private int quantidade;
    private int emprestados;
    private ArrayList<EmprestPara> hist;

    public Livro(int codLivro, String titulo, String categoria, int quantidade, int emprestados) {
        this.codLivro = codLivro;
        this.titulo = titulo;
        this.categoria = categoria;
        this.quantidade = quantidade;
        this.emprestados = emprestados;
        this.hist = new ArrayList<>();
    }

    public void empresta() throws CopiaNaoDisponivelEx {
        if (this.emprestados >= this.quantidade) {
            throw new CopiaNaoDisponivelEx("todas as copias do livro estao emprestadas.");
        }
        this.emprestados++;
    }

    public void devolve() throws NenhumaCopiaEmprestadaEx {
        if (this.emprestados <= 0) {
            throw new NenhumaCopiaEmprestadaEx("nenhuma copia deste livro esta emprestada.");
        }
        this.emprestados--;
    }
    
    public void addUsuarioHist(GregorianCalendar dataLocacao, GregorianCalendar dataDevolucao, long cpfUsuario) {
        EmprestPara registro = new EmprestPara(dataLocacao, dataDevolucao, cpfUsuario);
        this.hist.add(registro);
    }
    
    public int getCodLivro() { return codLivro; }
    public String getTitulo() { return titulo; }
    public String getCategoria() { return categoria; }
    public int getQuantidade() { return quantidade; }
    public int getEmprestados() { return emprestados; }
    public ArrayList<EmprestPara> getHist() { return hist; }
    
    public String toString() {
        return String.format("codigo: %d\ntitulo: %s\ncategoria: %s\ncopias totais: %d\nemprestadas: %d\ndisponiveis: %d",
            this.codLivro,
            this.titulo,
            this.categoria,
            this.quantidade,
            this.emprestados,
            this.quantidade - this.emprestados
        );
    }
}