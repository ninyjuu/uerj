/*Autor: Júlia Nicolao Bansemer.
Data: 20/04/2025.
Descrição: Calcula a potência x^y.
Entrada: Dois inteiros, x diferente de 0 e y maior ou igual a 0.
Saída: O resultado da potência ou mensagem inválida.
Restrições: x igual a 0 e y menor que 0.
*/


#include <stdio.h>

int main() {
    int x, y;
    int resultado = 1;

    printf("digite o valor de x diferente de 0: ");
    scanf("%d", &x);
    printf("digite o valor de y maior ou igual a 0: ");
    scanf("%d", &y);

    if (x != 0 && y >= 0) {
        for (int i= 0; i<y; i++) {
            resultado *= x;
        }
        printf("%d\n", resultado);
    } else {
        printf("entrada inválida\n");
    }

    return 0;
}
