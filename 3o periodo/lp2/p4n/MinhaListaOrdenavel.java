package lp2g13.bib;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Comparator;

public class MinhaListaOrdenavel {

    public static final int NOME_AZ = 1;
    public static final int NOME_ZA = 2;
    public static final int PESO_DECRESCENTE = 3;
    public static final int ALTURA_DECRESCENTE = 4;
    public static final int IMC_DECRESCENTE = 5;
    public static final int GENERO_ORDEM = 6;
    
    private List<PessoaIMC> lista;

    public MinhaListaOrdenavel() {
        this.lista = new ArrayList<>();
    }

    public void add(PessoaIMC p) { this.lista.add(p); }
    public List<PessoaIMC> getLista() { return this.lista; }
    
    private final Comparator<PessoaIMC> nomeC = (p1, p2) -> p1.getNome().compareTo(p2.getNome());
    private final Comparator<PessoaIMC> pesoC = (p1, p2) -> Double.compare(p1.getPeso(), p2.getPeso());
    private final Comparator<PessoaIMC> alturaC = (p1, p2) -> Double.compare(p1.getAltura(), p2.getAltura());
    private final Comparator<PessoaIMC> imcC = (p1, p2) -> Double.compare(p1.calculaIMC(), p2.calculaIMC());
    private final Comparator<PessoaIMC> generoC = (p1, p2) -> {
        boolean p1_h = p1 instanceof Homem;
        boolean p2_h = p2 instanceof Homem;
        if (p1_h == p2_h) return 0;
        if (p1_h) return -1;
        return 1;
    };

    public List<PessoaIMC> ordena(int criterio) {
        
        Comparator<PessoaIMC> comparator;
        
        switch (criterio) {
            case NOME_AZ:
                comparator = nomeC;
                break;
            case NOME_ZA:
                comparator = nomeC.reversed();
                break;
            case PESO_DECRESCENTE:
                comparator = pesoC.reversed();
                break;
            case ALTURA_DECRESCENTE:
                comparator = alturaC.reversed();
                break;
            case IMC_DECRESCENTE:
                comparator = imcC.reversed();
                break;
            case GENERO_ORDEM:
                comparator = generoC;
                break;
            default:
                return this.lista;
        }

        Collections.sort(this.lista, comparator);

        return this.lista;
    }
}