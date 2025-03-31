/*
Autor: Júlia Nicolao Bansemer.
Data: 30/03/2025.
Descrição: Escrever um programa que receba um númer inteiro N de 3 dígitos
e informe se esse número satisfaz a relação N= centenas³+ dezenas³+unidades³.
Entrada: Um inteiro.
Saída: Se satisfaz ou não.
Restrições: Números que não têm 3 dígitos.
*/

#include <stdio.h>
#include <math.h>
int main() {
    int n, c, d, u;

    printf("Digite um número inteiro de 3 dígitos: ");
    scanf("%d", &n);

    if (n < 100 || n > 999) {
        printf("Erro!\n");
        return 1;
    }

    c = n / 100;
    d = (n % 100) / 10;
    u = n % 10;

    if (n == pow(c, 3) + pow(d, 3) + pow(u, 3)) {
        printf("O número %d satisfaz a relação.\n", n);
    } else {
        printf("O número %d não satisfaz a relação.\n", n);
    }

    return 0;
}
