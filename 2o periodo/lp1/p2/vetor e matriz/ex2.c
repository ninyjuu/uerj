#include <stdio.h>

void merge(int a[], int n, int b[], int m){
    int h[20], i=0, j=0, k=0;
    while(i< n && j< m){
        if(a[i]<= b[j]){
            h[k++]= a[i++];
        }else{
            h[k++]= b[j++];
        }
    }
    while(i< n){
        h[k++]= a[i++];
    }
    while(j< m){
        h[k++]= b[j++];
    }
    for(int x= 0; x<n+m; x++){
        printf("%d ", h[x]);
    }
    printf("\n");
}

int main(){
    int n, m;
    printf("tamanho de A e B: ");
    scanf("%d %d", &n, &m);
    int a[10], b[10];
    printf("vetor A: ");
    for(int i= 0; i< n; i++){
        scanf("%d", &a[i]);
    }
    printf("vetor B: ");
    for(int i= 0; i< m; i++){
        scanf("%d", &b[i]);
    }
    merge(a, n, b, m);
    return 0;
}
