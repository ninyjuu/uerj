/*
Autor: Júlia Nicolao Bansemer.
Data: 13/04/2025.
Descrição: Imprime "*" em forma de pirâmide (do menor para maior).
Entrada: Um inteiro negativo.
Saída: O caractere "*" algumas vezes.
Restrições: Números menores que -10 e maiores que -1.
*/

#include <stdio.h>

int main() {
    int l;
    printf("insira um inteiro de -1 a -10: ");
    scanf("%d", &l);


    while (l < 0 && l >= -10) {
        int i = -1;
        while (i >= l) {
            printf("*");
            i--;
        }
        printf("\n");
        l++;
    }


    return 0;
}
