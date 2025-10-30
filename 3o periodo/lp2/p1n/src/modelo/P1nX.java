package app;

import modelo.Pessoa;
import modelo.Homem;
import modelo.Mulher;
import modelo.ValidaCPF;
import modelo.ValidaData;

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
            System.out.println("--- PRIMEIRO CADASTRO (Linha de Comando) ---");
            System.out.println(primeiraPessoa.toString());
            
            leituraInterativa(); 
        } 
    }

    public static void exibirHelpESair(int argsCount) {
        System.out.println("ERRO: Número incorreto de parâmetros (" + argsCount + " recebidos, 9 esperados).");
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("Sintaxe correta: java P1nX <genero> <nome> <sobre> <dia> <mes> <ano> <CPF> <peso> <altura>");
        System.out.println("  Gênero: H para Homem, M para Mulher.");
        System.out.println("  Mes: Número (1 a 12) ou por extenso (ex: Outubro).");
        System.out.println("--------------------------------------------------------------------------------");
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
            System.out.println("ERRO: Gênero inválido. Use H ou M.");
            return null;
        }
        
        if (nome.length() < 2 || nome.matches(".*\\d.*") || sobreNome.length() < 2 || sobreNome.matches(".*\\d.*")) {
             System.out.println("ERRO: Nome e Sobrenome não podem ser numéricos ou muito curtos.");
             return null;
        }

        if (!ValidaCPF.isCPF(cpfStr)) {
            System.out.println("ERRO: CPF inválido ou inconsistente.");
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
                System.out.println("ERRO: Data de Nascimento inválida (fora do limite ou regra de calendário).");
                return null;
            }
            
            if (peso < 1.0f || peso > 300.0f || altura < 1.0f || altura > 2.2f) {
                 System.out.println("ERRO: Peso ou Altura fora dos limites válidos.");
                 return null;
            }
            
            GregorianCalendar dataNasc = new GregorianCalendar(ano, mesNumero - 1, dia);
            long numCPF = ValidaCPF.toLong(cpfStr);
            
            if (genero.equalsIgnoreCase("H")) {
                return new Homem(nome, sobreNome, dataNasc, numCPF, peso, altura, false); 
            } else {
                return new Mulher(nome, sobreNome, dataNasc, numCPF, peso, altura, "Não Informado");
            }

        } catch (NumberFormatException e) {
            System.out.println("ERRO: Um dos parâmetros numéricos (dia, ano, peso, altura) não é válido.");
            return null;
        } catch (Exception e) {
             System.out.println("ERRO GERAL: Ocorreu um erro ao processar os dados.");
             return null;
        }
    }
    
    public static void leituraInterativa() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("\n--- PARTE 2: INÍCIO DA LEITURA INTERATIVA ---");

        int numElementos = -1;
        while (numElementos <= 0) {
            System.out.print("Quantos elementos adicionais você quer criar? (Mínimo 1): ");
            try {
                String input = reader.readLine().trim();
                if (input.isEmpty()) continue;
                numElementos = Integer.parseInt(input);
                if (numElementos <= 0) {
                    System.out.println("ERRO: O número deve ser maior que zero. Tente novamente.");
                }
            } catch (Exception e) {
                System.out.println("ERRO: Entrada inválida. Por favor, digite um número.");
            }
        }
        
        cadastroPessoas = new Pessoa[numElementos];
        int elementosAdicionados = 0;
        
        System.out.println("--- INICIANDO LEITURA DOS " + numElementos + " ELEMENTOS ---");

        while (elementosAdicionados < numElementos) {
            
            Pessoa novaPessoa = lerDadosPessoa(reader, elementosAdicionados + 1);

            if (novaPessoa == null) {
                if (elementosAdicionados == 0) {
                    System.out.println("AVISO: Nenhuma pessoa adicionada. Encerrando leitura.");
                } else {
                    System.out.println("Leitura interrompida pelo usuário.");
                }
                break;
            }

            cadastroPessoas[elementosAdicionados] = novaPessoa;
            elementosAdicionados++;
            System.out.println("Objeto #" + elementosAdicionados + " criado e armazenado.");
        }
        
        exibirEContarElementos(elementosAdicionados);
    }
    
    public static Pessoa lerDadosPessoa(BufferedReader reader, int indice) {
        
        String genero = "", nome = "", sobreNome = "", cpfStr = "", dataStr = "", pesoStr = "", alturaStr = "";
        float peso = 0.0f;
        float altura = 0.0f;
        
        try {
            while (true) {
                System.out.print("\nCadastro #" + indice + " - Gênero (H/M, ENTER para parar): ");
                genero = reader.readLine().trim();
                if (genero.isEmpty()) return null;
                if (genero.equalsIgnoreCase("H") || genero.equalsIgnoreCase("M")) break;
                System.out.println("ERRO: Gênero inválido. Use H ou M.");
            }
            
            while (true) {
                System.out.print("Nome: ");
                nome = reader.readLine().trim();
                if (!nome.matches(".*\\d.*") && nome.length() >= 2) break;
                System.out.println("ERRO: Nome inválido.");
            }
            
            while (true) {
                System.out.print("Sobrenome: ");
                sobreNome = reader.readLine().trim();
                if (!sobreNome.matches(".*\\d.*") && sobreNome.length() >= 2) break;
                System.out.println("ERRO: Sobrenome inválido.");
            }

            while (true) {
                System.out.print("CPF (11 dígitos): ");
                cpfStr = reader.readLine().trim();
                if (ValidaCPF.isCPF(cpfStr)) break;
                System.out.println("ERRO: CPF inválido ou inconsistente. Tente novamente.");
            }
            
            while (true) {
                System.out.print("Data de Nascimento (dd/mm/aaaa): ");
                dataStr = reader.readLine().trim();
                
                try {
                    String[] dataPartes = dataStr.split("/");
                    if (dataPartes.length != 3) throw new Exception();

                    int dia = Integer.parseInt(dataPartes[0]);
                    int mes = Integer.parseInt(dataPartes[1]);
                    int ano = Integer.parseInt(dataPartes[2]);

                    if (ValidaData.validarDataCompleta(dia, mes, ano)) break;

                } catch (Exception e) {
                }
                System.out.println("ERRO: Data inválida (formato dd/mm/aaaa ou calendário). Tente novamente.");
            }

            while (true) {
                System.out.print("Peso (Ex: 75.5): ");
                pesoStr = reader.readLine().trim();
                try {
                    peso = Float.parseFloat(pesoStr);
                    if (peso >= 1.0f && peso <= 300.0f) break;
                } catch (NumberFormatException e) {}
                System.out.println("ERRO: Peso fora dos limites válidos (1.0 - 300.0).");
            }
            
            while (true) {
                System.out.print("Altura (Ex: 1.75): ");
                alturaStr = reader.readLine().trim();
                try {
                    altura = Float.parseFloat(alturaStr);
                    if (altura >= 1.0f && altura <= 2.2f) break;
                } catch (NumberFormatException e) {}
                System.out.println("ERRO: Altura fora dos limites válidos (1.0 - 2.2).");
            }
            
            long numCPF = ValidaCPF.toLong(cpfStr);
            
            String[] dataPartes = dataStr.split("/");
            int dia = Integer.parseInt(dataPartes[0]);
            int mes = Integer.parseInt(dataPartes[1]);
            int ano = Integer.parseInt(dataPartes[2]);
            GregorianCalendar dataNasc = new GregorianCalendar(ano, mes - 1, dia);

            if (genero.equalsIgnoreCase("H")) {
                return new Homem(nome, sobreNome, dataNasc, numCPF, peso, altura, false); 
            } else {
                return new Mulher(nome, sobreNome, dataNasc, numCPF, peso, altura, "Não Informado");
            }

        } catch (Exception e) {
            System.out.println("ERRO: Falha crítica na entrada de dados. Reiniciando a leitura.");
            return null;
        }
    }
    
    public static void exibirEContarElementos(int totalElementosValidos) {
        if (totalElementosValidos == 0) return;

        System.out.println("\n--- EXIBIÇÃO DE TODOS OS REGISTROS ---");
        int contHomem = 0;
        int contMulher = 0;

        for (int i = 0; i < totalElementosValidos; i++) {
            Pessoa p = cadastroPessoas[i];
            
            System.out.println("\nRegistro #" + (i + 1));
            System.out.println(p.toString());
            
            if (p instanceof Homem) {
                contHomem++;
            } else if (p instanceof Mulher) {
                contMulher++;
            }
        }

        System.out.println("\n--- ESTATÍSTICAS FINAIS ---");
        System.out.println("Total de objetos criados (Pessoa.getNumPessoas()): " + Pessoa.getNumPessoas());
        System.out.println("Total de objetos exibidos no array: " + totalElementosValidos);
        System.out.println("Homens (instancia de Homem): " + contHomem);
        System.out.println("Mulheres (instancia de Mulher): " + contMulher);
    }
}