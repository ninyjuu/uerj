#include <stdlib.h>

int *somaVetores(int *vetor1, int *vetor2, int tamanho) {
    int *vetorResultado;
    int indice;

    vetorResultado= malloc(tamanho*sizeof(int));
    if(vetorResultado == NULL) return NULL;
    else {
        for(indice= 0; indice<tamanho; indice++) {
            vetorResultado[indice]= vetor1[indice] + vetor2[indice];
        }
        return vetorResultado;
    }
}
