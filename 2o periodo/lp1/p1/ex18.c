/*
Autor: Júlia Nicolao Bansemer.
Data: 13/04/2025.
Descrição: Imprime "*" em forma de pirâmide (do maior para menor).
Entrada: Um inteiro positivo.
Saída: O caractere "*" algumas vezes.
Restrições: Números menores que 0 e maiores que 10.
*/

#include <stdio.h>
int main() {
    int l;
    printf("insira um inteiro de 1 a 10: ");
    scanf("%d", &l);
    while (l > 0 && l <= 10) {
        int i = 0;
        while (i < l) {
            printf("*");
            i++;
    }
        printf("\n");
        l--;
}

return 0;
}