import java.util.Scanner;

public class CPF {
    public static void main(String[] args){
        String cpf = lerCPF();
        if (isCPF(cpf)) {
            System.out.println("CPF valido");
        } else {
            System.out.println("CPF invalido, tente novamente");
        }
    }

    public static String lerCPF(){
        Scanner scanner= new Scanner(System.in);
        System.out.println("Digite o CPF: ");
        String cpfDigitado= scanner.nextLine();
        scanner.close();
        return cpfDigitado.replaceAll("\\D", "");
    }

    public static boolean isCPF(String cpf){
        if (cpf.equals("00000000000") || cpf.equals("11111111111") ||
        cpf.equals("22222222222") || cpf.equals("33333333333") ||
        cpf.equals("44444444444") || cpf.equals("55555555555") ||
        cpf.equals("66666666666") || cpf.equals("77777777777") ||
        cpf.equals("88888888888") || cpf.equals("99999999999") ||
        (cpf.length() != 11))
        return(false);

        try{
            int peso= 10;
            int sm= 0;
            int num, r, dig10, dig11;

            for (int i=0; i<9; i++) {
                num= cpf.charAt(i)- '0';
                sm= sm+ (num*peso);
                peso= peso-1;
            }

            r= sm % 11;
            if (r==0 || r==1){
                dig10= '0';
            } else dig10= (char)((11-r)+'0');

            sm=0;
            peso= 11;
            for (int i=0; i<10; i++) {
                num= cpf.charAt(i)- '0';
                sm= sm+ (num*peso);
                peso= peso-1;
            }

            r= sm % 11;
            if (r==0 || r==1){
                dig11= '0';
            } else dig11= (char)((11-r)+'0');

            if ((dig10 == cpf.charAt(9)) && (dig11 == cpf.charAt(10)))
                 return(true);
            else return(false);

        } catch (Exception erro) {
            return(false);
        }
    }

    public static String imprimeCPF(String cpf) {
        return(cpf.substring(0,3)+ "." + cpf.substring(3,6)+ "." +
        cpf.substring(6,9)+ "-" + cpf.substring(9,11));
    }
}
