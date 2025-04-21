/* Autor: Júlia Nicolao Bansemer.
Data: 20/04/2025.
Descrição: Calcula o número harmônico, interrompendo a leitura após 3 números negativos.
Entrada: Um inteiro n, e n números inteiros.
Saída: A soma dos inversos dos números lidos.
Restrições: O programa interrompe a leitura após a leitura de 3 números negativos.
*/


#include <stdio.h>

int main() {
    int n, num, negativos = 0;
    float h= 0.0;

    scanf("%d", &n);

    for (int i= 1; i<=n; i++) {
        scanf("%d", &num);
        if (num<0) {
            negativos++;
            if (negativos== 3) {
                break;
            }
            continue;
        }
        h+= 1.0/num;
    }

    printf("%.5f\n", h);
    return 0;
}
