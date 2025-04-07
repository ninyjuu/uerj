#include <stdio.h>
int main(){
    int numero, maior;
    scanf("%d", &numero);
    maior= numero;

    for (;numero>0;){
        if (numero>maior)
            maior= numero;
        printf("forneca um numero: ");
    scanf("%d", &numero);
    }

    printf("maior numero/ %d\n", maior);
 
    return 0;
}