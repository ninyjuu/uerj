#include <stdio.h>

typedef struct {int dia, mes, ano;} tData;
tData leData(){
    tData data;
    puts("Digite dia, mes, ano: ");
    scanf("%d %d %d", &data.dia, &data.mes, &data.ano);
    return data;
}

int main(){
    tData d;
    d= leData();
    printf("%d/%d/%d", d.dia, d.mes, d.ano);
    return 0;
}