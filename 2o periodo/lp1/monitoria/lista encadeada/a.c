#include <stdio.h>
#include <stdlib.h>

typedef struct No{
    int valor;
    struct No *prox;
} No;

int main(){
    No *cabeca= NULL;
    No *segundo= NULL;
    No *terceiro= NULL;

    cabeca= malloc(sizeof(No));
    segundo= malloc(sizeof(No));
    terceiro= malloc(sizeof(No));

    cabeca-> valor= 1;
    segundo-> valor= 2;
    terceiro-> valor= 3;

    cabeca-> prox= segundo;
    segundo-> prox= terceiro;
    terceiro-> prox= cabeca;

    No *atual= cabeca;
    do{
        printf("%d", atual-> valor);
        atual= atual-> prox;
    }

    while (atual != cabeca);

    return 0;
}