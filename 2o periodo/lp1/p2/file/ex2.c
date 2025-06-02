#include <stdio.h>
int main(){
    char string [256];
    printf("insira seu endereco completo: ");
    fgets(string, 255, stdin);
    puts("seu endereco eh:");
    puts(string);
    return 0;
}