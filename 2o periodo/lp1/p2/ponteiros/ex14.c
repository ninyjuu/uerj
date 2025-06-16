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
    int n;
    scanf("%d", &n);
    int v[n];

    for (int i= 0; i<n; i++){
        scanf("%d", &v[i]);
    }

    int val;
    scanf("%d", &val);

    printf("%d", buscaBinaria(v,n,val));

    return 0;
}