#include <stdio.h>

int buscaBinaria(int *vet, int tam, int chave){
    int inicio= 0, fim= tam-1;
    while (inicio<= fim){
        int meio= (inicio+fim)/2;
        if (vet[meio]== chave) return meio;
        else if (vet[meio]< chave) inicio= meio+1;
        else fim= meio-1;
    }
    return -1;
}

int main(){
    int n, opcao;
    printf("digite 1 para inserir vetor manualmente ou 2 para ler do arquivo:\n");
    scanf("%d", &opcao);

    FILE *arq;
    int *v;

    if (opcao== 1){
        scanf("%d", &n);
        v= (int*) malloc(n * sizeof(int));
        for (int i= 0; i<n; i++){
            scanf("%d", &v[i]);
        }

        arq= fopen("vetor.txt", "w");
        fprintf(arq, "%d\n", n); 
        for (int i= 0; i<n; i++){
            fprintf(arq, "%d ", v[i]);
        }
        fclose(arq);
    }

    else if (opcao== 2){
        arq= fopen("vetor.txt", "r");
        if (arq== NULL){
            printf("Erro ao abrir o arquivo.\n");
            return 1;
        }
        fscanf(arq, "%d", &n);
        v= (int*) malloc(n * sizeof(int));
        for (int i= 0; i<n; i++){
            fscanf(arq, "%d", &v[i]);
        }
        fclose(arq);
    }

    else {
        printf("opcao invalida\n");
        return 1;
    }

    int val;
    scanf("%d", &val);
    printf("%d\n", buscaBinaria(v,n,val));

    free(v);
    return 0;
}
