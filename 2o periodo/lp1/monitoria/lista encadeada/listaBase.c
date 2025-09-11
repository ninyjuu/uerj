#include <stdio.h>
#include <stdlib.h>

typedef struct no{
    int valor;
    struct no *prox;
} no;

no *criarNo (int valor){
    no *novo= malloc(sizeof(no));
    novo-> valor= valor;
    novo-> prox= NULL;
    return novo;
}

no *addNo (no *cabeca, int valor){
    no *novo= criarNo(valor);
    if (cabeca==NULL) return novo;
    no *atual= cabeca;
    while (atual->prox != NULL) atual= atual-> prox;
    atual-> prox= novo;
    return cabeca;
}

void imprimirLista(no *cabeca){
    no *atual= cabeca;
    while (atual != NULL){
        printf("%d\n", atual-> valor);
        atual= atual-> prox;
    }
}

int main(){
    no *minhaLista= NULL;
    minhaLista= addNo(minhaLista, 10);
    minhaLista= addNo(minhaLista, 20);
    minhaLista= addNo(minhaLista, 30);
    minhaLista= addNo(minhaLista, 40);
    imprimirLista(minhaLista);
    return 0;
}