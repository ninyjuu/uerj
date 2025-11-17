import java.util.Scanner;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.ArrayList;
import java.util.InputMismatchException;

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
                        exibirMenuOrdenacao();
                        
                        if (scanner.hasNextInt()) {
                            int criterio = scanner.nextInt();
                            scanner.nextLine();
                            
                            List<PessoaIMC> listaOrdenada = cadastro.ordena(criterio);
                            
                            exibirListaOrdenada(listaOrdenada);

                        } else {
                            System.out.println("opcao de ordenacao invalida! tente novamente.");
                            scanner.nextLine();
                        }
                    } else if (opcaoMenu == 2) {
                        System.out.println("fim");
                    } else {
                        System.out.println("opcao invalida");
                    }
                } else {
                    String input = scanner.nextLine().trim();
                    if (input.isEmpty()) {
                        System.out.println("fim");
                        opcaoMenu = 2;
                    } else {
                        System.out.println("opcao invalida");
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("ocorreu um erro critico durante a execução.");
        }
    }

    public static void popularLista(MinhaListaOrdenavel lista) {

        lista.add(new Homem("Joao", "Mendes", new GregorianCalendar(1990, 5, 10), 11111111111L, 85.5, 1.80, true)); 
        lista.add(new Homem("Carlos", "Lima", new GregorianCalendar(2000, 10, 25), 22222222222L, 65.0, 1.75, false)); 
        lista.add(new Homem("Bruno", "Almeida", new GregorianCalendar(1985, 1, 1), 33333333333L, 95.2, 1.78, true)); 
        lista.add(new Homem("Ricardo", "Alves", new GregorianCalendar(2005, 3, 15), 44444444444L, 55.0, 1.90, false)); 
        lista.add(new Homem("Alexandre", "Gomes", new GregorianCalendar(1972, 8, 5), 55555555555L, 78.0, 1.70, true)); 

        lista.add(new Mulher("Ana", "Pereira", new GregorianCalendar(1995, 7, 12), 66666666666L, 58.5, 1.65, "Liso")); 
        lista.add(new Mulher("Julia", "Rocha", new GregorianCalendar(1992, 11, 30), 77777777777L, 72.0, 1.72, "Cacheado")); 
        lista.add(new Mulher("Mariana", "Vieira", new GregorianCalendar(2003, 4, 20), 88888888888L, 50.0, 1.60, "Ondulado")); 
        lista.add(new Mulher("Luisa", "Campos", new GregorianCalendar(1980, 2, 8), 99999999999L, 45.0, 1.68, "Liso")); 
        lista.add(new Mulher("Beatriz", "Azevedo", new GregorianCalendar(1999, 9, 3), 10101010101L, 68.0, 1.75, "Cacheado")); 
    }

    public static void exibirMenuOrdenacao() {
        System.out.println("\nescolha seu modo de ordenacao");
        System.out.println("1. nome (A-Z)");
        System.out.println("2. nome (Z-A)");
        System.out.println("3. peso maior para menor");
        System.out.println("4. altura (maior para menor");
        System.out.println("5. IMC maior para menor)");
        System.out.println("6. gênero (homem primeiro)");
        System.out.print("digite sua opcao: ");
    }
    
    public static void exibirListaOrdenada(List<PessoaIMC> lista) {
        System.out.println("\nlista ordenada:");
        
        for (PessoaIMC p : lista) {
            System.out.println(p.toString());
        }
    }
}
