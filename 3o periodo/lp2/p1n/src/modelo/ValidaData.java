package modelo;
import java.util.Scanner;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class ValidaData{
    public static void main(String[] args){
        String data= lerData();
        String[] partes = data.trim().split("\\s+");
        if (partes.length != 3){
            System.out.println("Data invalida");
            return;
        }

        int dia= Integer.parseInt(partes[0]);
        int ano= Integer.parseInt(partes[2]);
        int mes= converteMes(partes[1]);
        if (mes == -1){
            try{
                mes= Integer.parseInt(partes[1]);
            } catch (NumberFormatException e) {
                System.out.println("Data invalida");
                return;
            }
        }
        
        if (isDia(dia) && isMes(mes) && isAno(ano)){
            System.out.println("Data valida");
        } else{
            System.out.println("Data invalida");
        }
    }

    public static String lerData(){
        Scanner scanner= new Scanner (System.in);
        System.out.println("Data: ");
        String data= scanner.nextLine();
        scanner.close();
        return data;
    }
    
    public static boolean isDia (int dia){
        if (dia >= 1 && dia <= 31) return true;
        else return false;
    }
    
   public static int converteMes (String mes){
        mes= mes.toLowerCase();
        switch(mes){
            case "janeiro": return 1;
            case "fevereiro": return 2;
            case "março": return 3;
            case "abril": return 4;
            case "maio": return 5;
            case "junho": return 6;
            case "julho": return 7;
            case "agosto": return 8;
            case "setembro": return 9;
            case "outubro": return 10;
            case "novembro": return 11;
            case "dezembro": return 12;
            default: return -1;
        }
   }
   
    public static boolean isMes (int mes){
        if (mes >= 1 && mes <= 12) return true;
        else return false;
    }    
    
    public static boolean isAno (int ano){
        Calendar calendario= new GregorianCalendar();
        int anoAtual= calendario.get(Calendar.YEAR);
        int anoMinimo= anoAtual -120;
        if (ano >= anoMinimo && ano <= anoAtual) return true;
        else return false;
    }
}
