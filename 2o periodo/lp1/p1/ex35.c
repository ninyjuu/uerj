#include <stdio.h>
#include <math.h>

int decimalParaBinario (int n){
    int binario= 0, fator= 1;

    while (n>0) {
        binario+= (n%2)*fator;
        fator*= 10;
        n/= 2;
    }

    return binario;
}

int binarioParaDecimal (int n){
    int decimal;

    while (n>0){
        decimal+= pow(2, n);
    }
    
    return decimal;
}

int decimalParaHexa (int n){
        int hexadecimal= 0, fator= 1;

    while (n>0) {
        hexadecimal+= (n%16)*fator;
        fator*= 10;
        n/= 16;
    }

    return hexadecimal;
}

int HexaParaDecimal (int n){
    int decimal;
    
    while (n>0){
        decimal+= pow(16, n);
    }
    
    return decimal;
}

int main() {
    int n;
    printf("insira a conversao desejada: ");
    printf("1. decimal p/ binario");
    printf("1. binario p/ decimal");
    printf("1. decimal p/ hexadecimal");
    printf("1. hexadecimal p/ decimal");
    scanf("%d", &n);

    switch n{
        case 1:
            


    
    }
    }
    
    printf("%d\n", decimalParaBinario(n));
}