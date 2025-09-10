//1. Crie uma função chamada dobrarValor que receba um ponteiro
//para um inteiro e dobre o valor apontado. A função deve modificar
//o valor originaln da variável passada. 

#include <stdio.h>

void dobrarValor (int *p){
    *p= *p*2;
}

int main(){
    int n;
    scanf("%d", &n);
    dobrarValor(&n);
    printf("%d", n);
    return 0;
}