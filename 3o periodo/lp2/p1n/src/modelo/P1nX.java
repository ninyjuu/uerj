import java.util.Scanner;
import java.util.GregorianCalendar;
import java.util.Calendar;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P1nX {

    private static Pessoa[] cadastroPessoas; 
    
    public static void main(String[] args) {
        
        if (args.length != 9) {
            exibirHelpESair(args.length);
            return;
        }

        Pessoa primeiraPessoa = criarPessoaPorArgs(args);
        
        if (primeiraPessoa != null) {
            exibirPessoaIndividual(primeiraPessoa);
            
            leituraInterativa(primeiraPessoa); 
        } 
    }

    private static void exibirPessoaIndividual(Pessoa p) {
        String genero = (p instanceof Homem) ? "Masculino" : "Feminino";
        
        System.out.println("nome: " + p.getNome());
        System.out.println("sobrenome: " + p.getSobreNome());
        System.out.println("idade: " + p.calcularIdade());
        System.out.println("gênero: " + genero);
        System.out.println("cpf: " + ValidaCPF.imprimeCPF(String.valueOf(p.getNumCPF())));
        System.out.println("peso: " + String.format("%.1f", p.getPeso()).replace(',', '.'));
        System.out.println("altura: " + String.format("%.2f", p.getAltura()).replace(',', '.'));
    }

    public static void exibirHelpESair(int argsCount) {
        System.out.println("erro: número incorreto de parâmetros (" + argsCount + " recebidos, 9 esperados).");
        System.out.println("sintaxe correta: java P1nX <genero> <nome> <sobre> <dia> <mes> <ano> <CPF> <peso> <altura>");
        System.out.println("  gênero: h para homem, m para mulher.");
        System.out.println("  mes: número (1 a 12) ou por extenso (ex: outubro).");
    }

    public static Pessoa criarPessoaPorArgs(String[] args) {
        
        String genero = args[0];
        String nome = args[1];
        String sobreNome = args[2];
        String mesStr = args[4];
        String cpfStr = args[6];
        String pesoStr = args[7];
        String alturaStr = args[8];
        
        if (!genero.equalsIgnoreCase("H") && !genero.equalsIgnoreCase("M")) {
            System.out.println("erro: gênero inválido. use h ou m.");
            return null;
        }
        
        if (nome.length() < 2 || nome.matches(".*\\d.*") || sobreNome.length() < 2 || sobreNome.matches(".*\\d.*")) {
             System.out.println("erro: nome e sobrenome inválidos.");
             return null;
        }

        if (!ValidaCPF.isCPF(cpfStr)) {
            System.out.println("erro: cpf inválido.");
            return null;
        }
        
        try {
            int dia = Integer.parseInt(args[3]);
            int ano = Integer.parseInt(args[5]);
            float peso = Float.parseFloat(pesoStr);
            float altura = Float.parseFloat(alturaStr);
            
            int mesNumero = ValidaData.converteMes(mesStr);
            if (mesNumero == -1) {
                mesNumero = Integer.parseInt(mesStr);
            }
            
            if (!ValidaData.validarDataCompleta(dia, mesNumero, ano)) {
                System.out.println("erro: data de nascimento inválida.");
                return null;
            }
            
            if (peso < 1.0f || peso > 300.0f || altura < 1.0f || altura > 2.2f) {
                 System.out.println("erro: peso ou altura fora do limite.");
                 return null;
            }
            
            GregorianCalendar dataNasc = new GregorianCalendar(ano, mesNumero - 1, dia);
            long numCPF = ValidaCPF.toLong(cpfStr);
            
            if (genero.equalsIgnoreCase("H")) {
                return new Homem(nome, sobreNome, dataNasc, numCPF, peso, altura, false); 
            } else {
                return new Mulher(nome, sobreNome, dataNasc, numCPF, peso, altura, "não informado");
            }

        } catch (NumberFormatException e) {
            System.out.println("erro: parâmetros numéricos inválidos.");
            return null;
        } catch (Exception e) {
             System.out.println("erro geral.");
             return null;
        }
    }
    
    public static void leituraInterativa(Pessoa primeiraPessoa) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        int numElementos = -1;
        while (numElementos <= 0) {
            System.out.print("quantas pessoas a mais deseja inserir? (min. 1): ");
            try {
                String input = reader.readLine().trim();
                if (input.isEmpty()) continue;
                numElementos = Integer.parseInt(input);
                if (numElementos <= 0) {
                    System.out.println("erro: o número deve ser maior que zero. tente novamente.");
                }
            } catch (Exception e) {
                System.out.println("erro: entrada inválida. por favor, digite um número.");
            }
        }
        
        cadastroPessoas = new Pessoa[numElementos + 1];
        cadastroPessoas[0] = primeiraPessoa;
        int elementosAdicionados = 1;

        while (elementosAdicionados < cadastroPessoas.length) {
            
            Pessoa novaPessoa = lerDadosPessoa(reader, elementosAdicionados + 1);

            if (novaPessoa == null) {
                if (elementosAdicionados == 0) {
                    System.out.println("aviso: nenhuma pessoa adicionada. encerrando leitura.");
                } else {
                    System.out.println("leitura interrompida.");
                }
                break;
            }

            cadastroPessoas[elementosAdicionados] = novaPessoa;
            elementosAdicionados++;
        }
        
        exibirEContarElementos(elementosAdicionados);
    }
    
    public static Pessoa lerDadosPessoa(BufferedReader reader, int indice) {
        
        String genero = "", nome = "", sobreNome = "", cpfStr = "", dataStr = "";
        float peso = 0.0f;
        float altura = 0.0f;
        
        try {
            while (true) {
                System.out.print("insira o nome: ");
                nome = reader.readLine().trim();
                if (!nome.matches(".*\\d.*") && nome.length() >= 2) break;
                System.out.println("erro: nome inválido.");
            }
            
            while (true) {
                System.out.print("insira o sobrenome: ");
                sobreNome = reader.readLine().trim();
                if (!sobreNome.matches(".*\\d.*") && sobreNome.length() >= 2) break;
                System.out.println("erro: sobrenome inválido.");
            }

            while (true) {
                System.out.print("cpf: ");
                cpfStr = reader.readLine().trim();
                if (ValidaCPF.isCPF(cpfStr)) break;
                System.out.println("erro: cpf inválido. tente novamente.");
            }
            
            while (true) {
                System.out.print("data de nascimento: ");
                dataStr = reader.readLine().trim();
                
                try {
                    String[] dataPartes = dataStr.contains("/") ? dataStr.split("/") : dataStr.split(" ");
                    if (dataPartes.length != 3) throw new Exception();

                    int dia = Integer.parseInt(dataPartes[0]);
                    int ano = Integer.parseInt(dataPartes[2]);
                    String mesString = dataPartes[1];
                    int mesNumero = ValidaData.converteMes(mesString);
                    
                    if (mesNumero == -1) {
                        mesNumero = Integer.parseInt(mesString);
                    }

                    if (ValidaData.validarDataCompleta(dia, mesNumero, ano)) break;

                } catch (Exception e) {
                }
                System.out.println("erro: data inválida. tente novamente.");
            }

            while (true) {
                System.out.print("peso: ");
                String pesoStr = reader.readLine().trim(); 
                try {
                    float tempPeso = Float.parseFloat(pesoStr);
                    if (tempPeso >= 1.0f && tempPeso <= 300.0f) {
                        peso = tempPeso;
                        break;
                    }
                } catch (NumberFormatException e) {}
                System.out.println("erro: peso fora dos limites.");
            }
            
            while (true) {
                System.out.print("altura: ");
                String alturaStr = reader.readLine().trim(); 
                try {
                    float tempAltura = Float.parseFloat(alturaStr);
                    if (tempAltura >= 1.0f && tempAltura <= 2.2f) {
                        altura = tempAltura;
                        break;
                    }
                } catch (NumberFormatException e) {}
                System.out.println("erro: altura fora dos limites.");
            }

            while (true) {
                System.out.print("esta pessoa é do gênero feminino ou masculino (f ou m)? ");
                genero = reader.readLine().trim();
                if (genero.equalsIgnoreCase("M") || genero.equalsIgnoreCase("F")) break;
                System.out.println("erro: gênero inválido.");
            }
            
            long numCPF = ValidaCPF.toLong(cpfStr);
            
            String[] dataPartes = dataStr.contains("/") ? dataStr.split("/") : dataStr.split(" ");
            int dia = Integer.parseInt(dataPartes[0]);
            String mesString = dataPartes[1];
            int ano = Integer.parseInt(dataPartes[2]);
            
            int mesNumero = ValidaData.converteMes(mesString);
            if (mesNumero == -1) {
                mesNumero = Integer.parseInt(mesString);
            }
            
            GregorianCalendar dataNasc = new GregorianCalendar(ano, mesNumero - 1, dia);

            if (genero.equalsIgnoreCase("M")) {
                return new Homem(nome, sobreNome, dataNasc, numCPF, peso, altura, false); 
            } else {
                return new Mulher(nome, sobreNome, dataNasc, numCPF, peso, altura, "não informado");
            }

        } catch (Exception e) {
            return null;
        }
    }
    
    private static String formatarSaidaPessoa(Pessoa p) {
        StringBuilder sb = new StringBuilder();
        
        String genero = (p instanceof Homem) ? "Masculino" : "Feminino";
        
        sb.append("nome: ").append(p.getNome()).append("\n");
        sb.append("sobrenome: ").append(p.getSobreNome()).append("\n");
        sb.append("idade: ").append(p.calcularIdade()).append("\n");
        sb.append("gênero: ").append(genero).append("\n");
        sb.append("cpf: ").append(ValidaCPF.imprimeCPF(String.valueOf(p.getNumCPF()))).append("\n");
        sb.append("peso: ").append(String.format("%.1f", p.getPeso()).replace(',', '.')).append("\n");
        sb.append("altura: ").append(String.format("%.2f", p.getAltura()).replace(',', '.'));

        return sb.toString();
    }
    
    public static void exibirEContarElementos(int totalElementosValidos) {
        System.out.println("-----------------------------------------------------------");
        System.out.println("informações inseridas:");

        for (int i = 0; i < totalElementosValidos; i++) {
            Pessoa p = cadastroPessoas[i];
            
            if (i > 0) {
                System.out.println();
            }
            
            System.out.println(formatarSaidaPessoa(p));
        }

        System.out.println("\nprograma encerrado.");
    }
}