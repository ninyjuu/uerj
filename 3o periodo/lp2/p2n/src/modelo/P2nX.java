import java.util.Scanner;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Collections;

public class P2nX {

    public static void main(String[] args) {
        
        MinhaListaOrdenavel cadastro = new MinhaListaOrdenavel();
        popularLista(cadastro);

        try (Scanner scanner = new Scanner(System.in)) {
            int opcaoMenu = 0;
            
            while (opcaoMenu != 2) {
                
                System.out.println("1. imprimir lista e ordenar");
                System.out.println("2. sair");
                System.out.print("digite sua opcao: ");
                
                if (scanner.hasNextInt()) {
                    opcaoMenu = scanner.nextInt();
                    scanner.nextLine();
                    
                    if (opcaoMenu == 1) {
                        
                        int criterio = -1;
                        while (criterio < 1 || criterio > 6) { 
                            exibirMenuOrdenacao(); 
                            
                            if (scanner.hasNextInt()) {
                                criterio = scanner.nextInt();
                                scanner.nextLine();
                                
                                if (criterio < 1 || criterio > 6) {
                                    System.out.println("opcao de ordenacao fora do limite. tente novamente.");
                                }
                            } else {
                                System.out.println("entrada invalida. use apenas numeros.");
                                scanner.nextLine();
                                criterio = -1;
                            }
                        }
                        
                        List<PessoaIMC> listaOrdenada = cadastro.ordena(criterio);
                        exibirListaOrdenada(listaOrdenada);

                    } else if (opcaoMenu == 2) {
                        System.out.println("programa encerrado.");
                    } else {
                        System.out.println("opcao invalida\n");
                    }
                } else {
                    String input = scanner.nextLine().trim();
                    if (input.isEmpty()) {
                        System.out.println("programa encerrado.");
                        opcaoMenu = 2;
                    } else {
                        System.out.println("opcao invalida\n");
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("ocorreu um erro critico durante a execucao.");
        }
    }
    
    public static void popularLista(MinhaListaOrdenavel lista) {
        lista.add(new Homem("joao", "santos", new GregorianCalendar(1990, 5, 10), 11111111111L, 85.5, 1.80, true)); 
        lista.add(new Homem("carlos", "lima", new GregorianCalendar(2000, 10, 25), 22222222222L, 65.0, 1.75, false)); 
        lista.add(new Homem("bruno", "ferreira", new GregorianCalendar(1985, 1, 1), 33333333333L, 95.2, 1.78, true)); 
        lista.add(new Homem("ricardo", "alves", new GregorianCalendar(2005, 3, 15), 44444444444L, 55.0, 1.90, false)); 
        lista.add(new Homem("alexandre", "gomes", new GregorianCalendar(1972, 8, 5), 55555555555L, 78.0, 1.70, true)); 

        lista.add(new Mulher("ana", "pereira", new GregorianCalendar(1995, 7, 12), 66666666666L, 58.5, 1.65, "liso")); 
        lista.add(new Mulher("julia", "rocha", new GregorianCalendar(1992, 11, 30), 77777777777L, 72.0, 1.72, "cacheado")); 
        lista.add(new Mulher("mariana", "vieira", new GregorianCalendar(2003, 4, 20), 88888888888L, 50.0, 1.60, "ondulado")); 
        lista.add(new Mulher("luisa", "campos", new GregorianCalendar(1980, 2, 8), 99999999999L, 45.0, 1.68, "liso")); 
        lista.add(new Mulher("beatriz", "azevedo", new GregorianCalendar(1999, 9, 3), 10101010101L, 68.0, 1.75, "cacheado")); 
    }

    public static void exibirMenuOrdenacao() {
        System.out.println("\nescolha seu modo de ordenacao:");
        System.out.println("1. nome (a-z)");
        System.out.println("2. nome (z-a)");
        System.out.println("3. peso (maior para menor)");
        System.out.println("4. altura (maior para menor)");
        System.out.println("5. imc (maior para menor)");
        System.out.println("6. gênero (homem primeiro)");
        System.out.print("digite sua opcao: ");
    }
    
    public static void exibirListaOrdenada(List<PessoaIMC> lista) {
        System.out.println("\nlista ordenada:");
        
        for (PessoaIMC p : lista) {
            System.out.println("---------------------------------");
            System.out.println(p.toString());
        }
        System.out.println("---------------------------------");
    }
}