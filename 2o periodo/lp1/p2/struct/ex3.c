#include <stdio.h>

struct Veiculo{
    char placa[8];
    int ano;
    int prioridade ;
};

int main(){
    
    int qtd;
    printf("quantos veiculos? ");
    scanf("%d", &qtd);
    struct Veiculo veiculos[qtd];
    
    for (int i=0; i<qtd; i++){
        printf("placa veiculo %d: \n", i+1);
        scanf("%s", veiculos[i].placa);
        printf("ano veiculo %d: \n", i+1);
        scanf("%d", &veiculos[i].ano);
        printf("prioridade veiculo %d: \n", i+1);
        scanf("%d", &veiculos[i].prioridade);
        
        if (veiculos[i].prioridade == 1) printf("cliente agendado\n");
        else if (veiculos[i].prioridade == 0) printf("cliente comum\n");
    
    }
    return 0;
}

