/* Autor: Júlia Nicolao Bansemer.
Data: 25/04/2025.
Descrição: Realiza conversões entre as bases numéricas decimal, binário e hexadecimal.
Entrada: Opção de conversão e um inteiro.
Saída: Resultado da conversão.
Restrições: Não dígitos de 0 a 9 ou letras.
*/

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
    int decimal= 0, base= 1;

    while (n>0){
        int digito= n%10;
        decimal+= digito*base;
        base*= 2;
        n/= 10;
    }

    return decimal;
}

int decimalParaHexa (int n){
    int hexadecimal= 0, fator= 1;

    while (n>0) {
        int digito= n%16;
        if (digito>=10) {
            printf("nao e possivel representar letras com int\n");
            return -1;
        }
        hexadecimal+= digito*fator;
        fator*= 10;
        n/= 16;
    }

    return hexadecimal;
}

int hexaParaDecimal (int n){
    int decimal= 0, base= 1;

    while (n>0){
        int digito= n%10;
        decimal+= digito*base;
        base*= 16;
        n/= 10;
    }

    return decimal;
}

int main() {
    int conv, num;

    printf("insira a conversao desejada:\n");
    printf("1. decimal p/ binario\n");
    printf("2. binario p/ decimal\n");
    printf("3. decimal p/ hexadecimal (so digitos 0-9)\n");
    printf("4. hexadecimal p/ decimal (so digitos 0-9)\n");
    scanf("%d", &conv);

    printf("insira o numero a ser convertido: ");
    scanf("%d", &num);

    switch (conv){
        case 1:
            printf("%d\n", decimalParaBinario(num));
            break;
        case 2:
            printf("%d\n", binarioParaDecimal(num));
            break;
        case 3:
            printf("%d\n", decimalParaHexa(num));
            break;
        case 4:
            printf("%d\n", hexaParaDecimal(num));
            break;
        default:
            printf("opcao invalida\n");
    }

    return 0;
}