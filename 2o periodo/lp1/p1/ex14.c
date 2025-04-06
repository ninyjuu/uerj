/*Autor: Júlia Nicolao Bansemer.
Data: 06/04/2025.
Descrição: Realiza uma operação escolhida pelo usuário.
Entrada: Dois racionais e um caractere.
Saída: O resultado.
Restrições: Nenhuma.
*/

#include <stdio.h>
int main() {
    float a, b;
    char operador;

    printf("Digite uma operacao aritmetica entre dois numeros a e b na forma \"a <operacao> b\":\n");
    scanf("%f %c %f", &a, &operador, &b);

    switch (operador) {
        case '+':
            printf("%.2f\n", a + b);
            break;
        case '-':
            printf("%.2f\n", a - b);
            break;
        case '*':
            printf("%.2f\n", a * b);
            break;
        case '/':
            printf("%.2f\n", a / b);
            break;
        default:
            puts("Operador nao definido.");
    }

    return 0;
}
