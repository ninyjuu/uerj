//2. Crie uma função contarPares que receba um ponteiro para
//um vetor de inteiros e o tamanho do vetor, e retorne
//quantos elementos são pares.

#include <stdio.h>

int contarPares (int *v, int tam){
    int cont = 0;
    for (int i=0; i<tam; i++){
        if (v[i]%2==0) cont++;
    }
    return cont;
}

int main(){
    int tamanho;
    scanf("%d", &tamanho);
    int vet[tamanho];
    for (int i=0; i<tamanho; i++){
        scanf("%d", &vet[i]);
    }
    int pares= contarPares(vet, tamanho);
    printf("%d", pares);

    return 0;
}
    