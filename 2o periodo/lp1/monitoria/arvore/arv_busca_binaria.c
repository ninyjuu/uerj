#include <stdio.h>
#include <stdlib.h>

typedef struct no{
  int valor;
  struct no *e;
  struct no *d;
} no;

no *criaNo (int valor){
  no *novo= malloc(sizeof(no));
  novo-> valor= valor;
  novo-> e= NULL;
  novo-> d= NULL;
  return novo;
}

no *criaArv (no *raiz, int valor){
  no *novo= criaNo(valor);
  if (raiz== NULL) return novo;
  if (valor < raiz-> valor) criaArv(raiz-> e, valor);
  else if (valor > raiz-> valor) criaArv(raiz-> d, valor);
  return raiz;
}

no *busca(no *raiz, int valor){
  if (raiz == NULL || valor == raiz-> valor) return raiz;
  if (valor < raiz-> valor) return busca(raiz-> e, valor);
  if (valor > raiz-> valor) return busca(raiz-> d, valor);
}

void imprime (no *raiz){
  if (raiz != NULL){
    imprime(raiz-> e);
    printf("%d", raiz-> valor);
    imprime(raiz-> d);
  }
}

no *remove(no *raiz, int valor) {
    if (raiz == NULL) return raiz;
    if (valor < raiz->valor) raiz->e = remove(raiz->e, valor);
    else if (valor > raiz->valor) raiz->d = remove(raiz->d, valor);
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
            raiz->d = remove(raiz->d, temp->valor);
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
