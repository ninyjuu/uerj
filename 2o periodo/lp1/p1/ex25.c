/*Escreva uma função que verifique se um número é primo.
Depois, na main, leia dois números e
imprima todos os primos entre eles.*/

#include <stdio.h>

int primo (int a){
    printf("insira um numero: ");
    scanf("%d", &a);

    for (int i=2; i<a; i++){
        if (a%i==0){
            return 1;
        } else {
            return 0;
        }
    }
}

int main(){

    int b, c;
    printf("insira dois numeros: ");
    scanf("%d %d", &b, &c);
    for (int i=2; i<b; i++){
        if (b%i==0 && c%i==0){
            printf("%d\n", i);
        } 
    }    

    return 0;
}