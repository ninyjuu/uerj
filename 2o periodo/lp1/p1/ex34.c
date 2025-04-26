/* Autor: Júlia Nicolao Bansemer.
Data: 25/04/2025.
Descrição: Calcula a quantidade de LEDs necessários para exibir um número em um display.
Entrada: Um inteiro.
Saída: Quantidade de LEDs necessários para exibir o número.
Restrições: Nenhuma.
*/

#include <stdio.h>

int ledsAlgarismo(int a) {
    if (a==0) return 6;
    if (a==1) return 2;
    if (a==2) return 5;
    if (a==3) return 5;
    if (a==4) return 4;
    if (a==5) return 5;
    if (a==6) return 6;
    if (a==7) return 3;
    if (a==8) return 7;
    if (a==9) return 6;
    return 0;
}

int totalLEDS(int n) {
    int total= 0;


    if (n == 0){
        return ledsAlgarismo(0);
    }

    while (n>0) {
        int algarismo= n%10;
        total+= ledsAlgarismo(algarismo);
        n/= 10;
    }

    return total;
}

int main() {
    int numero;
    printf("digite um numero: ");
    scanf("%d", &numero);

    int leds = totalLEDS(numero);
    printf("total de leds para o numero %d: %d\n", numero, leds);

    return 0;
}
