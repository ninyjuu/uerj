/* Autor: Júlia Nicolao Bansemer.
Data: 25/04/2025.
Descrição: Verifica se um número inteiro é palíndromo.
Entrada: Um número inteiro.
Saída: Informa se o número é ou não um palíndromo.
Restrições: Nenhuma.
*/

#include <stdio.h>

int inverso(int numero) {
    int invertido= 0;

    int original= numero;
    if (numero<0)
        numero= -numero;

    while (numero!=0) {
        int digito= numero%10;
        invertido= invertido*10+ digito;
        numero= numero/10;
    }

    if (original<0)
        return -invertido;
    else
        return invertido;
}


int palindromo(int numero) {
    if (numero== inverso(numero)){
        return 0;
    } else {
        return 1;
    }
}

int main() {
    int num;
    printf("digite um numero: ");
    scanf("%d", &num);
    if (palindromo(num)) printf("eh palindromo");
    else printf ("nao eh palindromo");

    return 0;
}
