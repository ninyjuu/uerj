#include <stdio.h>

void vetorResultado (int *v1, int *v2, int tamanho){
    for (int i=0; i<tamanho; i++){
        v1[i]= v1[i]+ v2[i];
    }
}

int main(){
    int n;
    scanf("%d", &n);
    int *v1= (int*) malloc (n*sizeof(int));
    int *v2= (int*) malloc (n*sizeof(int));
    for (int i=0; i<n; i++){
        scanf("%d", &v1[i]);
    }
    for (int i=0; i<n; i++){
        scanf("%d", &v2[i]);
    }

    vetorResultado(v1, v2, n);
    for (int i=0; i<n; i++){
        printf("%d", v1[i]);
    }

    free(v1);
    free(v2);

    return 0;
}