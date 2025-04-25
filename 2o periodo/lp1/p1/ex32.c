#include <stdio.h>

int inverso(int numero) {
    int invertido= 0;

    int original= numero;
    if (numero<0)
        numero= -numero;

    while (numero!=0) {
        int digito= numero%10;
        invertido= invertido*10+ digito;
        numero= numero/10;
    }

    if (original<0)
        return -invertido;
    else
        return invertido;
}


char* palindromo(int numero) {
    if (numero== inverso(numero)){
        return "eh palindromo";
    } else {
        return "nao eh palindromo";
    }
}

int main() {
    int num;
    printf("digite um numero: ");
    scanf("%d", &num);
    printf("%s\n", palindromo(num));

    return 0;
}
