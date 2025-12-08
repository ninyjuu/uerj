import lp2g13.bib.*;
import java.util.Scanner;
import java.util.GregorianCalendar;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.InputMismatchException;
import java.util.Calendar;
import java.util.HashMap;
import java.io.File;

public class P3nX {

    private static Biblioteca bib;
    private static Scanner scanner = new Scanner(System.in);
    private static final String ARQ_USUARIOS = "u.dat";
    private static final String ARQ_LIVROS = "l.dat";

    public static void main(String[] args) {
        
        if (!new File(ARQ_USUARIOS).exists() || !new File(ARQ_LIVROS).exists()) {
            criarBancoDeDadosExemplo();
        }

        System.out.println("--- sistema biblioteca ---");
        
        dialogoInicial();
        
        int opcaoMenu = 0;
        while (opcaoMenu != 5) {
            try {
                System.out.println("\n--- menu principal ---");
                System.out.println("1. manutencao de arquivos");
                System.out.println("2. cadastro (usuario/livro)");
                System.out.println("3. emprestimo / devolucao");
                System.out.println("4. relatorios");
                System.out.println("5. sair");
                System.out.print("escolha uma opcao: ");

                if (scanner.hasNextInt()) {
                    opcaoMenu = scanner.nextInt();
                    scanner.nextLine(); 

                    switch (opcaoMenu) {
                        case 1: manutencaoArquivos(); break;
                        case 2: moduloCadastro(); break;
                        case 3: moduloEmprestimo(); break;
                        case 4: moduloRelatorio(); break;
                        case 5: 
                            salvaArquivosPadrao(ARQ_USUARIOS, ARQ_LIVROS);
                            System.out.println("programa encerrado.");
                            break;
                        default: System.out.println("opcao invalida. tente novamente.");
                    }
                } else {
                    scanner.nextLine();
                    System.out.println("entrada invalida. use apenas numeros.");
                }
            } catch (Exception e) {
                System.err.println("ocorreu um erro inesperado: " + e.getMessage());
            }
        }
    }

    public static void criarBancoDeDadosExemplo() {
        Biblioteca bdTemp = new Biblioteca();
        
        Usuario u1 = new Usuario("Ana", "Silva", new GregorianCalendar(1990, 0, 1), 11111111111L, "Rua A, 1");
        Usuario u2 = new Usuario("Bruno", "Lima", new GregorianCalendar(1985, 5, 5), 22222222222L, "Rua B, 2");
        bdTemp.cadastraUsuario(u1);
        bdTemp.cadastraUsuario(u2);
        bdTemp.cadastraUsuario(new Usuario("Carlos", "Nunes", new GregorianCalendar(1995, 8, 10), 33333333333L, "Rua C, 3"));
        bdTemp.cadastraUsuario(new Usuario("Diana", "Rocha", new GregorianCalendar(2000, 1, 20), 44444444444L, "Rua D, 4"));
        bdTemp.cadastraUsuario(new Usuario("Eduardo", "Gomes", new GregorianCalendar(1970, 0, 1), 55555555555L, "Rua E, 5"));
        
        Livro l1 = new Livro(101, "O Codigo Limpo", "Tecnico", 3, 0); 
        Livro l2 = new Livro(102, "Dom Quixote", "Classico", 1, 0); 
        bdTemp.cadastraLivro(l1); 
        bdTemp.cadastraLivro(l2);
        bdTemp.cadastraLivro(new Livro(103, "O Senhor dos Aneis", "Fantasia", 5, 0));
        bdTemp.cadastraLivro(new Livro(104, "Orgulho e Preconceito", "Romance", 2, 0));
        bdTemp.cadastraLivro(new Livro(105, "A Revolucao dos Bichos", "Ficcao", 4, 0));
        
        try {
            bdTemp.emprestaLivro(u1, l2); 
            
            bdTemp.emprestaLivro(u2, l1);
            bdTemp.devolveLivro(u2, l1); 
        } catch (Exception e) {
            System.err.println("erro ao criar transacoes de exemplo.");
        }

        System.out.println("criando banco de dados de entrega...");
        bdTemp.salvaArquivo(bdTemp.getCadastroUsuarios(), "u.dat");
        bdTemp.salvaArquivo(bdTemp.getCadastroLivros(), "l.dat");
        System.out.println("banco de dados u.dat e l.dat criados.");
    }
    

    private static void dialogoInicial() {
        System.out.println("\nvoce deseja iniciar a biblioteca:");
        System.out.println("1. com cadastro zerado");
        System.out.println("2. carregando cadastros dos arquivos padrao (u.dat e l.dat)");
        System.out.print("escolha: ");

        int escolha = -1;
        while (escolha != 1 && escolha != 2) {
            if (scanner.hasNextInt()) {
                escolha = scanner.nextInt();
                scanner.nextLine();
            } else {
                scanner.nextLine();
            }
            if (escolha == 1) {
                bib = new Biblioteca();
                System.out.println("biblioteca iniciada com cadastros zerados.");
            } else if (escolha == 2) {
                bib = new Biblioteca(ARQ_USUARIOS, ARQ_LIVROS);
            } else {
                System.out.print("escolha invalida. digite 1 ou 2: ");
            }
        }
    }

    private static void manutencaoArquivos() {
        int op = 0;
        while (op != 4) {
            System.out.println("\n--- manutencao de arquivos ---");
            System.out.println("1. salvar cadastro de usuarios");
            System.out.println("2. salvar acervo de livros");
            System.out.println("3. carregar cadastro de arquivo");
            System.out.println("4. voltar");
            System.out.print("escolha: ");

            if (scanner.hasNextInt()) {
                op = scanner.nextInt();
                scanner.nextLine();
                
                String nomeArq;

                switch (op) {
                    case 1:
                        System.out.print("nome do arquivo para salvar usuarios: ");
                        nomeArq = scanner.nextLine();
                        bib.salvaArquivo(bib.getCadastroUsuarios(), nomeArq);
                        break;
                    case 2:
                        System.out.print("nome do arquivo para salvar livros: ");
                        nomeArq = scanner.nextLine();
                        bib.salvaArquivo(bib.getCadastroLivros(), nomeArq);
                        break;
                    case 3:
                        System.out.print("nome do arquivo para carregar: ");
                        nomeArq = scanner.nextLine();
                        System.out.print("tipo do arquivo (usuario/livro): ");
                        String tipo = scanner.nextLine().toLowerCase();
                        bib.leArquivo(nomeArq, tipo);
                        break;
                    case 4:
                        break;
                    default:
                        System.out.println("opcao invalida.");
                }
            } else {
                scanner.nextLine();
                op = 0;
            }
        }
    }
    
    private static void salvaArquivosPadrao(String arqUsu, String arqLiv) {
        bib.salvaArquivo(bib.getCadastroUsuarios(), arqUsu);
        bib.salvaArquivo(bib.getCadastroLivros(), arqLiv);
    }

    private static void moduloCadastro() {
        int op = 0;
        while (op != 4) {
            System.out.println("\n--- cadastro ---");
            System.out.println("1. cadastrar novo usuario");
            System.out.println("2. cadastrar novo livro");
            System.out.println("3. salvar cadastros em arquivo");
            System.out.println("4. voltar");
            System.out.print("escolha: ");

            if (scanner.hasNextInt()) {
                op = scanner.nextInt();
                scanner.nextLine();

                switch (op) {
                    case 1: cadastraUsuarioDialogo(); break;
                    case 2: cadastraLivroDialogo(); break;
                    case 3: salvarCadastroSubMenu(); break;
                    case 4: break;
                    default: System.out.println("opcao invalida.");
                }
            } else {
                scanner.nextLine();
                op = 0;
            }
        }
    }

    private static void cadastraUsuarioDialogo() {
        try {
            System.out.println("\n--- novo usuario ---");
            System.out.print("nome: ");
            String nome = scanner.nextLine();
            System.out.print("sobrenome: ");
            String sobrenome = scanner.nextLine();
            
            String cpfStr = "";
            while (true) {
                System.out.print("cpf (apenas numeros): ");
                cpfStr = scanner.nextLine().trim(); 
                if (ValidaCPF.isCPF(cpfStr)) {
                    break;
                }
                System.err.println("erro: cpf invalido ou formato incorreto. tente novamente.");
            }
            long cpf = ValidaCPF.toLong(cpfStr); 
            
            System.out.print("data de nascimento (dd/mm/aaaa): ");
            String dataStr = scanner.nextLine();
            
            String[] partes = dataStr.split("/");
            if (partes.length != 3) {
                 System.err.println("erro: formato da data invalido. use dd/mm/aaaa.");
                 return;
            }
            
            int dia = Integer.parseInt(partes[0]);
            int mes = Integer.parseInt(partes[1]);
            int ano = Integer.parseInt(partes[2]);
            
            if (!ValidaData.validarDataCompleta(dia, mes, ano)) {
                 System.err.println("erro: data de nascimento inconsistente (calendario).");
                 return;
            }
            
            GregorianCalendar dataNasc = new GregorianCalendar(ano, mes - 1, dia);
            
            System.out.print("endereco: ");
            String endereco = scanner.nextLine();

            Usuario novoUsuario = new Usuario(nome, sobrenome, dataNasc, cpf, endereco);
            bib.cadastraUsuario(novoUsuario);
            System.out.println("usuario cadastrado: " + novoUsuario.getNome() + " " + novoUsuario.getSobreNome());
        } catch (InputMismatchException e) {
             System.err.println("erro: entrada numerica invalida.");
             scanner.nextLine();
        } catch (Exception e) {
             System.err.println("erro ao cadastrar usuario: " + e.getMessage());
        }
    }

    private static void cadastraLivroDialogo() {
        try {
            System.out.println("\n--- novo livro ---");
            System.out.print("codigo do livro (1-999): ");
            int cod = scanner.nextInt();
            scanner.nextLine();
            System.out.print("titulo: ");
            String titulo = scanner.nextLine();
            System.out.print("categoria: ");
            String categoria = scanner.nextLine();
            System.out.print("quantidade total de copias: ");
            int qtd = scanner.nextInt();
            scanner.nextLine();

            Livro novoLivro = new Livro(cod, titulo, categoria, qtd, 0);
            bib.cadastraLivro(novoLivro);
            System.out.println("livro cadastrado: " + novoLivro.getTitulo());
        } catch (InputMismatchException e) {
             System.err.println("erro: entrada numerica invalida.");
             scanner.nextLine();
        } catch (Exception e) {
             System.err.println("erro ao cadastrar livro: " + e.getMessage());
        }
    }

    private static void salvarCadastroSubMenu() {
        int op = 0;
        while (op != 3) {
            System.out.println("\n--- salvar cadastro ---");
            System.out.println("1. salvar cadastro de usuarios");
            System.out.println("2. salvar acervo de livros");
            System.out.println("3. voltar");
            System.out.print("escolha: ");

            if (scanner.hasNextInt()) {
                op = scanner.nextInt();
                scanner.nextLine();
                
                String nomeArq;
                
                switch (op) {
                    case 1:
                        System.out.print("nome do arquivo para salvar usuarios: ");
                        nomeArq = scanner.nextLine();
                        bib.salvaArquivo(bib.getCadastroUsuarios(), nomeArq);
                        break;
                    case 2:
                        System.out.print("nome do arquivo para salvar livros: ");
                        nomeArq = scanner.nextLine();
                        bib.salvaArquivo(bib.getCadastroLivros(), nomeArq);
                        break;
                    case 3:
                        break;
                    default:
                        System.out.println("opcao invalida.");
                }
            } else {
                scanner.nextLine();
                op = 0;
            }
        }
    }
    
    private static void moduloEmprestimo() {
        int op = 0;
        while (op != 4) {
            System.out.println("\n--- emprestimo ---");
            System.out.println("1. exibir acervo de livros");
            System.out.println("2. fazer emprestimo");
            System.out.println("3. fazer devolucao");
            System.out.println("4. voltar");
            System.out.print("escolha: ");

            if (scanner.hasNextInt()) {
                op = scanner.nextInt();
                scanner.nextLine();

                switch (op) {
                    case 1: System.out.println("\n--- acervo completo ---\n" + bib.imprimeLivros()); break;
                    case 2: transacaoEmprestimo(); break;
                    case 3: transacaoDevolucao(); break;
                    case 4: break;
                    default: System.out.println("opcao invalida.");
                }
            } else {
                scanner.nextLine();
                op = 0;
            }
        }
    }

    private static void transacaoEmprestimo() {
        try {
            System.out.print("cpf do usuario: ");
            long cpf = scanner.nextLong();
            System.out.print("codigo do livro: ");
            int cod = scanner.nextInt();
            scanner.nextLine();

            Usuario u = bib.getUsuario(cpf); 
            Livro l = bib.getLivro(cod);     

            bib.emprestaLivro(u, l);
            
            System.out.println("\n--- recibo de emprestimo ---");
            System.out.println("usuario:");
            System.out.println(u.toString());
            System.out.println("\nlivro:");
            System.out.println(l.toString());

        } catch (UsuarioNaoCadastradoEx | LivroNaoCadastradoEx | CopiaNaoDisponivelEx e) {
            System.err.println("erro na transacao: " + e.getMessage());
        } catch (InputMismatchException e) {
            scanner.nextLine();
            System.err.println("erro: entrada de dados invalida (esperado numero).");
        }
    }

    private static void transacaoDevolucao() {
        try {
            System.out.print("cpf do usuario: ");
            long cpf = scanner.nextLong();
            System.out.print("codigo do livro a devolver: ");
            int cod = scanner.nextInt();
            scanner.nextLine();

            Usuario u = bib.getUsuario(cpf);
            Livro l = bib.getLivro(cod);

            bib.devolveLivro(u, l);
            
            System.out.println("\n--- recibo de devolucao ---");
            System.out.println("usuario:");
            System.out.println(u.toString());
            System.out.println("\nlivro:");
            System.out.println(l.toString());
            
        } catch (UsuarioNaoCadastradoEx | LivroNaoCadastradoEx | NenhumaCopiaEmprestadaEx e) {
            System.err.println("erro na transacao: " + e.getMessage());
        } catch (InputMismatchException e) {
            scanner.nextLine();
            System.err.println("erro: entrada de dados invalida (esperado numero).");
        }
    }

    private static void moduloRelatorio() {
        int op = 0;
        while (op != 5) {
            System.out.println("\n--- relatorios ---");
            System.out.println("1. listar acervo de livros (ordenado)");
            System.out.println("2. listar cadastro de usuarios (ordenado)");
            System.out.println("3. detalhes de um livro (incluindo historico)");
            System.out.println("4. detalhes de um usuario (incluindo historico)");
            System.out.println("5. voltar");
            System.out.print("escolha: ");

            if (scanner.hasNextInt()) {
                op = scanner.nextInt();
                scanner.nextLine();
                
                try {
                    switch (op) {
                        case 1: System.out.println("\n--- acervo ordenado ---\n" + bib.imprimeLivros()); break;
                        case 2: System.out.println("\n--- usuarios ordenados ---\n" + bib.imprimeUsuarios()); break;
                        case 3: 
                            System.out.print("codigo do livro: ");
                            int codL = scanner.nextInt();
                            scanner.nextLine();
                            Livro l = bib.getLivro(codL); 
                            System.out.println("\n--- detalhes do livro ---\n" + l.toString());
                            System.out.println("\n--- historico de emprestimos (livro) ---");
                            l.getHist().forEach(System.out::println);
                            break;
                        case 4: 
                            System.out.print("cpf do usuario: ");
                            long cpfU = scanner.nextLong();
                            scanner.nextLine();
                            Usuario u = bib.getUsuario(cpfU);
                            System.out.println("\n--- detalhes do usuario ---\n" + u.toString());
                            System.out.println("\n--- historico de emprestimos (usuario) ---");
                            u.getHist().forEach(System.out::println);
                            break;
                        case 5: break;
                        default: System.out.println("opcao invalida.");
                    }
                } catch (UsuarioNaoCadastradoEx | LivroNaoCadastradoEx e) {
                    System.err.println("erro no relatorio: " + e.getMessage());
                } catch (InputMismatchException e) {
                    scanner.nextLine();
                    System.err.println("erro: entrada de dados invalida.");
                }
            } else {
                scanner.nextLine();
                op = 0;
            }
        }
    }
}