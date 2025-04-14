/*Faça uma função que receba um número e imprima sua tabuada de 1 a 10.
Na função main,
pergunte ao usuário qual tabuada ele deseja visualizar. */

#include <stdio.h>

int main(){
    int n, tab;
    printf("insira um numero: ");
    scanf("%d", &n);
    for (int i=0; i<11; i++){
        tab= i*n;
        printf("%d\n", tab);
    }
    return 0;
}