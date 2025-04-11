/*
Autor: <nome do aluno>
Data: <data de hoje>
Descrição: <o que o programa faz>
Entrada: <o que o programa espera receber como entrada>
Saída: <o que o programa retorna para o usuário>
Restrições: possíveis restrições de entrada
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