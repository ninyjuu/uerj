/* Autor: Júlia Nicolao Bansemer.
Data: 20/04/2025.
Descrição: Calcula o número harmônico.
Entrada: Um número inteiro.
Saída: O número harmônico.
Restrições: n deve ser maior que 0.
*/


#include <stdio.h>

int main() {
    int n;
    float h= 0.0;

    printf("digite um inteiro: ");
    scanf("%d", &n);

    for (int i= 1; i<=n; i++) {
        h+= 1.0f/i; 
    }

    printf("%.5f\n", h);
    return 0;
}
