import java.util.Scanner;

class Temperatura{
    public float conversao (String valor){
        float temp= Float.parseFloat(valor);
        float f= (float) (temp*1.8) + 32;
        return f;
    }

    public static void main (String[] args){
        Temperatura conversor = new Temperatura();
        System.out.println("temperatura em celsius: ");
        Scanner scanner= new Scanner(System.in);
        String valor= scanner.nextLine();
        System.out.println(conversor.conversao(valor));
        scanner.close();
    }
}