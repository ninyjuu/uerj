#include <stdio.h>
#include <stdlib.h>

typedef struct no {
    int valor;
    struct no *e;
    struct no *d;
} no;

no *criaNo(int valor) {
    no *novo = malloc(sizeof(no));
    novo->valor = valor;
    novo->e = NULL;
    novo->d = NULL;
    return novo;
}

no *criaArv(no *raiz, int valor) {
    if (raiz == NULL) return criaNo(valor);
    if (valor < raiz->valor) raiz->e = criaArv(raiz->e, valor);
    else if (valor > raiz->valor) raiz->d = criaArv(raiz->d, valor);
    return raiz;
}

no *busca(no *raiz, int valor) {
    if (raiz == NULL || valor == raiz->valor) return raiz;
    if (valor < raiz->valor) return busca(raiz->e, valor);
    if (valor > raiz->valor) return busca(raiz->d, valor);
}

void imprime(no *raiz) {
    if (raiz != NULL) {
        imprime(raiz->e);
        printf("%d ", raiz->valor);
        imprime(raiz->d);
    }
}

no *removeNo(no *raiz, int valor) {
    if (raiz == NULL) return raiz;
    if (valor < raiz->valor) raiz->e = removeNo(raiz->e, valor);
    else if (valor > raiz->valor) raiz->d = removeNo(raiz->d, valor);
    else {
        if (raiz->d == NULL && raiz->e == NULL) {
            free(raiz);
            return NULL;
        } else if (raiz->e == NULL) {
            no *temp = raiz->d;
            free(raiz);
            return temp;
        } else if (raiz->d == NULL) {
            no *temp = raiz->e;
            free(raiz);
            return temp;
        } else {
            no *temp = raiz->d;
            while (temp->e != NULL) temp = temp->e;
            raiz->valor = temp->valor;
            raiz->d = removeNo(raiz->d, temp->valor);
        }
    }
    return raiz;
}

void libera(no *raiz) {
    if (raiz != NULL) {
        libera(raiz->e);
        libera(raiz->d);
        free(raiz);
    }
}

int main() {
    no *arvore = NULL;
    arvore = criaArv(arvore, 2);
    arvore = criaArv(arvore, 5);
    arvore = criaArv(arvore, 1);
    imprime(arvore);
    printf("\n");
    int buscado = 3;
    if (busca(arvore, buscado) == NULL) printf("nao encontrado\n");
    else printf("encontrado\n");
    libera(arvore);
    return 0;
}
