#include <stdio.h>

int contarOcorrencias(int *vetor, int tamanho, int x){
    int cont= 0;
    for (int i= 0; i<tamanho; i++){
        if (vetor[i]==x) cont+=1;
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
    int a;
    scanf("%d", &a);
    printf("%d", contarOcorrencias(v,tam,a));
    return 0;
}
