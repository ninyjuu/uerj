package lp2g13.bib;

import java.util.GregorianCalendar;
import java.text.SimpleDateFormat;
import java.io.Serializable;

public class Emprest implements Serializable {
    
    private GregorianCalendar dataEmprest;
    private GregorianCalendar dataDevolucao;
    private int codLivro;

    public Emprest(GregorianCalendar dataEmprest, int codLivro) {
        this.dataEmprest = dataEmprest;
        this.codLivro = codLivro;
        this.dataDevolucao = null; 
    }

    public GregorianCalendar getDataEmprest() {
        return dataEmprest;
    }

    public int getCodLivro() {
        return codLivro;
    }
    
    public GregorianCalendar getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(GregorianCalendar dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public boolean isPendente() {
        return this.dataDevolucao == null;
    }

    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String dataEmprestFormatada = (dataEmprest != null) ? sdf.format(dataEmprest.getTime()) : "N/A";
        
        String statusDevolucao;
        if (dataDevolucao == null) {
            statusDevolucao = "Pendente";
        } else {
            statusDevolucao = sdf.format(dataDevolucao.getTime());
        }

        return String.format("Livro: %d | Empréstimo: %s | Devolução: %s",
            this.codLivro,
            dataEmprestFormatada,
            statusDevolucao
        );
    }
}