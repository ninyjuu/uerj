#include <stdio.h>

int main(){
    int a,b,c,max,min;
    float media, soma;
    printf("digite 3 inteiros: \n");
    scanf("%d %d %d", &a, &b, &c);

    max= a>b && a>c? a: b>c? b:c;
    min= a<b && a<c? a: b<c? b:c;
    soma= a+b+c;
    media= soma/3;

    printf("o maior é %d, o menor é %d, a média é %.1f\n", max, min, media);

    return 0;
}