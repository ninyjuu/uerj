// import modelo.Temperatura;
// import java.util.Scanner;

// public class App {
//     public static void main(String[] args) {
//         // CORRIGIDO: Assinatura do main
        
//         System.out.print("Temperatura em Celsius: "); 
//         Scanner scanner = new Scanner(System.in);
//         String valor = scanner.nextLine();
        
//         // 1. CRIAÇÃO DA INSTÂNCIA (CORREÇÃO do erro static/não-static)
//         Temperatura conversor = new Temperatura(); 
        
//         // 2. CHAMADA CORRETA: Chama o método através da instância
//         // É necessário try-catch para proteger o Float.parseFloat(valor)
//         try {
//             float resultadoF = conversor.conversao(valor);
//             System.out.println("Temperatura em Fahrenheit: " + resultadoF);
//         } catch (NumberFormatException e) {
//             System.out.println("Erro: Entrada inválida. Por favor, digite apenas números.");
//         } finally {
//             scanner.close(); // Garante que o Scanner seja fechado
//         }
//     }
// }
