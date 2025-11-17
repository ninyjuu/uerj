import java.util.GregorianCalendar;

public abstract class PessoaIMC extends Pessoa{
    protected double peso;
    protected double altura;

    public PessoaIMC(String nome, String sobreNome, GregorianCalendar dataNasc, long numCPF, double peso, double altura){
        super(nome, sobreNome, dataNasc, numCPF);
        this.peso= peso;
        this.altura= altura;
    }

    public PessoaIMC(String nome, String sobreNome) {
        super(nome, sobreNome); 
        this.peso = 0.0;
        this.altura = 0.0;
    }

    public void setPeso(double peso) {
        if (peso >= 1.0 && peso <= 300.0) {
            this.peso = peso;
        } else {
            System.out.println("peso invalido");
        }
    }
    
    public double getPeso() { return peso; }
    
    public void setAltura(double altura) {
        if (altura >= 1.0 && altura <= 2.2) {
            this.altura = altura;
        } else {
            System.out.println("altura invalida");
        }
    }
    public double getAltura() { return altura; }

    public double calculaIMC(){
        if (this.altura <= 0) return 0.0;
        return this.peso/(this.altura*this.altura);
    }

    public abstract String resultIMC();

    public String toString(){
        String pessoaInfo = super.toString();
        double imc = calculaIMC();
        String analise = resultIMC();
        
        return String.format("%s\npeso: %.1f\naltura: %.2f\nIMC: %.2f (%s)",
            pessoaInfo,
            this.peso,
            this.altura,
            imc,
            analise
        );
    }

}
