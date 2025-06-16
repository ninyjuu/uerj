#include <stdio.h>

int somaVetor(int *vetor, int tamanho){
    int soma= 0;
    for (int i=0; i<tamanho; i++){
        soma+= vetor[i];
    }
    return soma;
}

int main(){
    int tam;
    scanf("%d", &tam);
    int v[tam];
    for (int i= 0; i<tam; i++){
        scanf("%d", &v[i]);
    }
    printf("%d", somaVetor(v, tam));
    return 0;
}