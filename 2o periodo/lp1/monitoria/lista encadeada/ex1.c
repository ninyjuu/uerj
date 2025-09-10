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

    cabeca= (No*) malloc(sizeof(No));
    segundo= (No*) malloc(sizeof(No));
    terceiro= (No*) malloc(sizeof(No));

    cabeca-> valor= 1;
    segundo-> valor= 2;
    terceiro-> valor= 3;

    cabeca-> prox= segundo;
    segundo-> prox= terceiro;
    terceiro-> prox= NULL;

    No *atual= cabeca;
    while (atual != NULL){
        printf("%d", atual-> valor);
        atual= atual-> prox;
    }

    return 0;
}