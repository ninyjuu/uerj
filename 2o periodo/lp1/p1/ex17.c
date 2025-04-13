/*
Autor: Júlia Nicolao Bansemer.
Data: 13/04/2025.
Descrição: x elevado a y.
Entrada: Dois inteiros
Saída: O resultado
Restrições: Nenhuma
*/

#include <stdio.h>
int main() {
    int x,y;
    int pot = 1;
    printf("insira dois inteiros: ");
    scanf("%d %d", &x, &y);
    for (int i=0; i<y; i++){
        pot *= x;
    }
    printf("%d\n", pot);
return 0;
}