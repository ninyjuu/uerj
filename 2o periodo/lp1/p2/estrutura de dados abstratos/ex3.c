#include <stdio.h>
int main(){
    struct veiculo{
        char placa;
        int ano, prioridade;
    };

    struct veiculo v1;

    puts("placa, ano, prioridade: ");
    scanf("%s %d %d", &v1.placa, &v1.ano, &v1.prioridade);
    if (v1.prioridade== 1) printf("v1 tem prioridade");
    else printf("v1 é cliente comum");

    struct veiculo v2;

    puts("placa, ano, prioridade: ");
    scanf("%s %d %d", &v2.placa, &v2.ano, &v2.prioridade);
    if (v2.prioridade== 1) printf("v2 tem prioridade");
    else printf("v2 é cliente comum");

    struct veiculo v3;

    puts("placa, ano, prioridade: ");
    scanf("%s %d %d", &v3.placa, &v3.ano, &v3.prioridade);
    if (v3.prioridade== 1) printf("v3 tem prioridade");
    else printf("v3 é cliente comum");

    struct veiculo v4;

    puts("placa, ano, prioridade: ");
    scanf("%s %d %d", &v4.placa, &v4.ano, &v4.prioridade);
    if (v4.prioridade== 1) printf("v4 tem prioridade");
    else printf("v4 é cliente comum");

    struct veiculo v5;

    puts("placa, ano, prioridade: ");
    scanf("%s %d %d", &v5.placa, &v5.ano, &v5.prioridade);
    if (v5.prioridade== 1) printf("v5 tem prioridade");
    else printf("v5 é cliente comum");

    return 0;

}