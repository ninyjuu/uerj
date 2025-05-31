#include <stdio.h>

int contarPares(int *vetor, int tamanho) {
    int cont= 0;
    for (int i=0; i< tamanho; i++) {
        if (*(vetor+i)%2==0) {
            cont++;
        }
    }
    return cont;
}

int main() {
    int v[5];

    for (int i=0; i<5; i++) {
        printf("Digite o número %d: ", i+1);
        scanf("%d", &v[i]);
    }
    printf("%d\n", contarPares(v, 5));
    return 0;
}
