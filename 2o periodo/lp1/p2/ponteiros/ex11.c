#include <stdio.h>

void copiarVetor(int *vetorO, int *vetorD, int tamanho){
    for (int i=0; i<tamanho; i++){
        vetorD[i]= vetorO[i];
    }
}

int main(){
    int tam;
    scanf("%d", &tam);

    int origem[tam];
    int destino[tam];

    for (int i=0; i<tam; i++) {
        scanf("%d", &origem[i]);
    }
    
    copiarVetor(origem,destino,tam);

    for (int i=0; i<tam; i++){
        printf("%d", destino[i]);
    }

    return 0;
}