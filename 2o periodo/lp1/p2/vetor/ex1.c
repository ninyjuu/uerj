#include <stdio.h>

float produtoInterno(float v[], float w[], int n){
    float resultado= 0.0;
    for(int i=0; i< n; i++){
        resultado+= v[i]*w[i];
    }
    return resultado;
}

int main(){
    int n;
    printf("dimensao: ");
    scanf("%d", &n);
    float v[10], w[10];
    printf("vetor v: ");
    for(int i= 0; i< n; i++){
        scanf("%f", &v[i]);
    }
    printf("vetor w: ");
    for(int i= 0; i< n; i++){
        scanf("%f", &w[i]);
    }
    printf("%.1f\n", produtoInterno(v, w, n));
    return 0;
}
