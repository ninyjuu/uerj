#include <stdio.h>

int main(){
    float nota;
    printf("insira a nota: ");
    scanf("%f", &nota);
    if (nota<0 || nota>10){
        printf("essa nota nao eh valida");
    }
    else{
        if (nota >=9 && nota<= 9.5){
            nota= 9.5;
        }
    }
    printf("a nota é %f", nota);


}