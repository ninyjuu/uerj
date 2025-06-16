#include <stdio.h>

float mediaVetor (int *vetor, int tamanho){
    float soma= 0;
    for (int i=0; i<tamanho; i++){
        soma+= vetor[i];
    }
    return soma/tamanho;
}

int main(){
    int tam;
    scanf("%d", &tam);
    int v[tam];
    for (int i=0; i<tam; i++){
        scanf("%d", &v[i]);
    }
    printf("%f", mediaVetor(v,tam));
    return 0;
}