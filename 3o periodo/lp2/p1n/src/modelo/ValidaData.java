package modelo;

import java.util.Scanner;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class ValidaData {
    
    public static void main(String[] args) {
        String dataInput = lerData();
        String[] partes = dataInput.trim().split("\\s+");

        if (partes.length != 3) {
            System.out.println("Data invalida");
            return;
        }
        
        String mesString = partes[1];
        int dia;
        int ano;
        int mesNumero;

        try {
            dia = Integer.parseInt(partes[0]);
            ano = Integer.parseInt(partes[2]);

            mesNumero = converteMes(mesString);
            
            if (mesNumero == -1) {
                mesNumero = Integer.parseInt(mesString);
            }
            
            if (isDia(dia) && isMes(mesNumero) && isAno(ano) && validarRegrasCalendario(dia, mesNumero, ano)) {
                System.out.println("Data valida");
            } else {
                System.out.println("Data invalida");
            }

        } catch (NumberFormatException e) {
            System.out.println("Data invalida");
        }
    }

    
    public static String lerData() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Data: ");
        String data = scanner.nextLine();
        scanner.close();
        return data;
    }

    public static boolean isDia(int dia) {
        return dia >= 1 && dia <= 31;
    }

    public static int converteMes(String mesString) {
        String mesLower = mesString.trim().toLowerCase();
        
        switch(mesLower) {
            case "janeiro": case "jan": return 1;
            case "fevereiro": case "fev": return 2;
            case "marco": case "mar": return 3;
            case "abril": case "abr": return 4;
            case "maio": case "mai": return 5;
            case "junho": case "jun": return 6;
            case "julho": case "jul": return 7;
            case "agosto": case "ago": return 8;
            case "setembro": case "set": return 9;
            case "outubro": case "out": return 10;
            case "novembro": case "nov": return 11;
            case "dezembro": case "dez": return 12;
            default: return -1;
        }
    }

    public static boolean isMes(int mes) {
        return mes >= 1 && mes <= 12;
    } 

    public static boolean isAno(int ano) {
        Calendar calendario = new GregorianCalendar();
        int anoCorrente = calendario.get(Calendar.YEAR);
        int anoMinimo = anoCorrente - 120;
        return ano >= anoMinimo && ano <= anoCorrente;
    }

    public static boolean validarRegrasCalendario(int dia, int mes, int ano) {
        if (mes == 4 || mes == 6 || mes == 9 || mes == 11) {
            if (dia > 30) return false;
        } else if (mes == 2) {
            boolean bissexto = (ano % 4 == 0 && ano % 100 != 0) || (ano % 400 == 0);
            if (bissexto) {
                if (dia > 29) return false;
            } else {
                if (dia > 28) return false;
            }
        }
        return true;
    }
}