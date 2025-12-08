package lp2g13.bib;

import java.util.GregorianCalendar;
import java.text.SimpleDateFormat;
import java.io.Serializable;

public class EmprestPara implements Serializable {
    
    private GregorianCalendar dataLocacao;
    private GregorianCalendar dataDevolucao; 
    private long cpfUsuario;

    public EmprestPara(GregorianCalendar dataLocacao, GregorianCalendar dataDevolucao, long cpfUsuario) {
        this.dataLocacao = dataLocacao;
        this.dataDevolucao = dataDevolucao; 
        this.cpfUsuario = cpfUsuario;
    }
    
    public GregorianCalendar getDataLocacao() { return dataLocacao; }
    public GregorianCalendar getDataDevolucao() { return dataDevolucao; }
    public long getCpfUsuario() { return cpfUsuario; }
    
    public void setDataDevolucao(GregorianCalendar dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String dataLocFormatada = (dataLocacao != null) ? sdf.format(dataLocacao.getTime()) : "N/A";
        
        String statusDevolucao;
        if (dataDevolucao == null) {
            statusDevolucao = "pendente";
        } else {
            statusDevolucao = sdf.format(dataDevolucao.getTime());
        }

        return String.format("usuário CPF: %d | locação: %s | devolução: %s",
            this.cpfUsuario,
            dataLocFormatada,
            statusDevolucao
        );
    }
}