/* Autor: Júlia Nicolao Bansemer.
Data: 20/04/2025.
Descrição: Calcula as médias dos números pares e ímpares lidos.
Entrada: Um inteiro que indica quantos números serão lidos, e os números.
Saída: A média dos pares e a dos ímpares.
Restrições: Um número negativo.
*/


#include <stdio.h>

int main() {
    int n, num;
    int soma_pares= 0, soma_impares= 0;
    int qtd_pares= 0, qtd_impares= 0;
    float media_pares= 0, media_impares= 0;

    printf("quantos numeros serao lidos? ");
    scanf("%d", &n);

    for (int i= 0; i<n; i++) {
        printf("numero %d: ", i+1);
        scanf("%d", &num);

        if (num<0) {
            printf("numero negativo\n");
            break;
        }

        if (num%2== 0) {
            soma_pares+= num;
            qtd_pares++;
        } else {
            soma_impares+= num;
            qtd_impares++;
        }
    }

    if (qtd_pares>0) {
        media_pares= (float)soma_pares/qtd_pares;
        printf("media dos pares e %.2f\n", media_pares);
    } else {
        printf("nenhum par\n");
    }

    if (qtd_impares>0) {
        media_impares= (float)soma_impares/qtd_impares;
        printf("media dos impares e %.2f\n", media_impares);
    } else {
        printf("nenhum impar\n");
    }

    return 0;
}