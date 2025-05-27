#include <stdio.h>

void ordenar(int v[], int n){
    int min, temp;
    for(int i= 0; i< n-1; i++){
        min= i;
        for(int j= i+1; j< n; j++){
            if(v[j]< v[min]){
                min= j;
            }
        }
        temp= v[i];
        v[i]= v[min];
        v[min]= temp;
    }
    for(int i=0; i<n; i++){
        printf("%d ", v[i]);
    }
    printf("\n");
}

int main(){
    int n;
    printf("tamanho do vetor: ");
    scanf("%d", &n);
    int v[20];
    printf("valores do vetor: ");
    for(int i= 0; i< n; i++){
        scanf("%d", &v[i]);
    }
    ordenar(v, n);
    return 0;
}
