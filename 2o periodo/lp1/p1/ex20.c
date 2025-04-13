/*
Autor: Júlia Nicolao Bansemer.
Data: 13/04/2025.
Descrição: Roda 3 vezes (se for inserida uma letra) e exibe o caractere 12
vezes a frente da letra inserida (de forma circular).
Entrada: Um caractere.
Saída: O caractere 12x a frente.
Restrições: Qualquer coisa diferente de uma letra do alfabeto.
*/

#include <stdio.h>

int main() {
    char letra;
    int contador = 0;

    while (contador < 3) {
        printf("Digite uma letra: ");
        letra = getchar();

        if (!((letra >= 'A' && letra <= 'Z') || (letra >= 'a' && letra <= 'z'))) {
            printf("Caractere invalido\n");
            continue;
        }

        char cifra;
        if (letra >= 'A' && letra <= 'Z') {
            cifra = ((letra-'A'+ 12)% 26) + 'A';
        }
        else {
            cifra = ((letra-'a'+ 12)% 26) + 'a';
        }

        printf("A cifra de %c eh %c\n", letra, cifra);
        contador++;
    }

    return 0;
}
