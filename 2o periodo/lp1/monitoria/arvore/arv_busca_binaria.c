#include <stdio.h>
#include <stdlib.h>

typedef struct no{
    int valor;
    struct no *e;
    struct no *d;
} no;

no *criarNo (int valor){
    no *novo= malloc(sizeof(no));
    novo-> valor= valor;
    novo-> e= NULL;
    novo-> d= NULL;
    return novo;
}

no *addNo (no *raiz, int valor){
    no *novo= criarNo(valor);
    if (raiz == NULL) return novo;
    if (valor < raiz->valor) raiz-> e= addNo(raiz-> e, valor);
    else if (valor > raiz-> valor) raiz-> d= addNo (raiz-> d, valor);
    return raiz;
}

no *buscarNo(no *raiz, int valor){
    if (raiz== NULL || valor == raiz-> valor) return raiz;
    if (valor < raiz-> valor) return buscarNo(raiz-> e, valor);
    return buscarNo(raiz-> d, valor);
}

void imprimirOrdem(no *raiz){
    if (raiz != NULL){
        imprimirOrdem(raiz-> e);
        printf("%d", raiz-> valor);
        imprimirOrdem(raiz-> d);
    }
}

int main() {
    no *raiz = NULL;

    raiz = inserirNo(raiz, 50);
    inserirNo(raiz, 30);
    inserirNo(raiz, 20);
    inserirNo(raiz, 40);
    inserirNo(raiz, 70);
    inserirNo(raiz, 60);
    inserirNo(raiz, 80);

    imprimirEmOrdem(raiz);
    printf("\n");

    int valorBuscado = 40;
    no *resultado = buscarNo(raiz, valorBuscado);
    if (resultado != NULL) {
        printf("Valor %d encontrado na arvore.\n", valorBuscado);
    } else {
        printf("Valor %d nao encontrado.\n", valorBuscado);
    }
    
    return 0;
}