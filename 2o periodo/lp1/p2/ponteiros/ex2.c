#include <stdio.h>

int contarPares (int *vetor, int tamanho){
    int cont = 0;
    for (int i=0; i<tamanho; i++){
        if (vetor[i]%2==0) cont++;
    }
    return cont;
}

int main(){
    int tam;
    scanf("%d", &tam);
    int v[tam];
    for (int i=0; i<tam; i++){
        scanf("%d", &v[i]);
    }
    printf("%d", contarPares(v,tam));
    return 0;
}