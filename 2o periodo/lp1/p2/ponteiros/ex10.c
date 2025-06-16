#include <stdio.h>

int procuraValor(int *vetor, int tamanho, int x){
    for (int i=0; i<tamanho; i++){
        if (vetor[i]==x) return i+1;
    }
    return -1;
}

int main(){
    int tam;
    scanf("%d", &tam);
    int v[tam];
    for (int i=0; i<tam; i++){
        scanf("%d", &v[i]);
    }
    int val;
    scanf("%d", &val);
    printf("%d", procuraValor(v,tam,val));
    return 0;
}