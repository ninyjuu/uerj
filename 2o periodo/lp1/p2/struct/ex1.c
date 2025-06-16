#include <stdio.h>
int main(){
    struct data{
        int dia;
        int mes;
        int ano;
    };

    struct data d;

    puts("Digite dia, mes e ano: ");
    scanf("%d %d %d", &d.dia, &d.mes, &d.ano);
    printf("%d/%d/%d\n", d.dia, d.mes, d.ano);
    return 0;
}