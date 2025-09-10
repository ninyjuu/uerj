#include <stdio.h>

int main(){
    int tamanho;
    printf("insira o tamanho: ");
    scanf("%d", &tamanho);
    int sequencia[tamanho];

    for (int i=0; i<tamanho; i++){
        scanf("%d", &sequencia[i]);

    int inversoes= 0;
    for (int i=0; i<tamanho-1; i++){
        for (int j=i+1; j<tamanho; j++){
            if (sequencia[i]>sequencia[j]) inversoes++;
        }
    }
    printf("%d inversoes.\n", inversoes);
    if (inversoes%2==0) printf("marcelo ganhou");
    else printf("carlos ganhou");

    return 0;
    }

}