#include <stdio.h>
int sacar(int valor, int *notas100, int *notas50, int *notas20, int *notas10) {

    if (valor>=100) {
        *notas100= valor/100;
        valor= valor%100;
    }

    if (valor>=50) {
        *notas50= valor/50;
        valor= valor%50;
    }

    if (valor>=20) {
        *notas20= valor/20;
        valor= valor%20;
    }

    if (valor>=10) {
        *notas10= valor/10;
        valor= valor%10;
    }
    
    if (valor!=0) {
        printf("inválido (nao multiplo de 10)\n");
        return -1;
    }

    return valor;
}

int main() {
    int valor;
    int notas100= 0, notas50= 0, notas20= 0, notas10= 0;

    printf("digite o valor para saque multiplo de 10: ");
    scanf("%d", &valor);
    int resultado = sacar(valor, &notas100, &notas50, &notas20, &notas10);

    if (resultado == 0) {
        printf("Notas para o saque de R$%d:\n", valor);
        printf("%d notas de 100\n", notas100);
        printf("%d notas de 50\n", notas50);
        printf("%d notas de 20\n", notas20);
        printf("%d notas de 10\n", notas10);
    }

    return 0;
}
