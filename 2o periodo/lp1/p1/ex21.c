#include <stdio.h>

int main() {
    int n, esquerda, direita, soma;

    for (n=0; n>999 && n<=9999; n++) {
        esquerda = n/100;
        direita = n%100;
        soma= esquerda+direita;

        if (soma*soma== n) {
            printf("%d:(%d + %d)^2= %d\n", n, esquerda, direita, n);
        }
    }

    return 0;
}
