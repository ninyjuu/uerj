

public class ValidaCPF {

    public static boolean isCPF(String cpf) {
        if (cpf == null) return false;
        
        String cpfLimpo = cpf.replaceAll("\\D", ""); 

        if (cpfLimpo.length() != 11 || 
            cpfLimpo.equals("00000000000") || cpfLimpo.equals("11111111111") ||
            cpfLimpo.equals("22222222222") || cpfLimpo.equals("33333333333") ||
            cpfLimpo.equals("44444444444") || cpfLimpo.equals("55555555555") ||
            cpfLimpo.equals("66666666666") || cpfLimpo.equals("77777777777") ||
            cpfLimpo.equals("88888888888") || cpfLimpo.equals("99999999999"))
            return false;

        char dig10, dig11;
        int sm, r, num, peso;

        try {
            sm = 0;
            peso = 10;
            for (int i = 0; i < 9; i++) {
                num = cpfLimpo.charAt(i) - '0';
                sm = sm + (num * peso);
                peso--;
            }

            r = sm % 11;
            if (r == 0 || r == 1) dig10 = '0';
            else dig10 = (char)((11 - r) + '0');

            sm = 0;
            peso = 11;
            for (int i = 0; i < 10; i++) {
                num = cpfLimpo.charAt(i) - '0';
                sm = sm + (num * peso);
                peso--;
            }

            r = sm % 11;
            if (r == 0 || r == 1) dig11 = '0';
            else dig11 = (char)((11 - r) + '0');

            return (dig10 == cpfLimpo.charAt(9)) && (dig11 == cpfLimpo.charAt(10));

        } catch (Exception erro) {
            return false;
        }
    }

    public static String imprimeCPF(String cpf) {
        String cpfLimpo = cpf.replaceAll("\\D", "");
        if (cpfLimpo.length() != 11) {
            return "CPF Inválido/Incompleto";
        }
        return String.format("%s.%s.%s-%s", 
            cpfLimpo.substring(0, 3), 
            cpfLimpo.substring(3, 6), 
            cpfLimpo.substring(6, 9), 
            cpfLimpo.substring(9, 11));
    }

    public static long toLong(String cpf) {
        String cpfLimpo = cpf.replaceAll("\\D", "");
        
        try {
             return Long.parseLong(cpfLimpo);
        } catch (NumberFormatException e) {
             return 0L; 
        }
    }
}