#include <stdio.h>

int main(){
    int temp[5][5];
    for (int i=0; i<5; i++){
        for (int j=0; j<5; j++){
            printf("elemento %dx%d: ", i+1, j+1);
            scanf("%d", &temp[i][j]);
        }
    }
        for (int i=0; i<5; i++){
            for (int j=0; j<5; j++){
                printf("%d", temp[i][j]);
            }
            printf("\n");
        }

    int maior= temp[0][0];
    int menor= temp[0][0];
    int media, mediaPrincipal, soma= 0, somaPrincipal= 0;
    for (int i=0; i<5; i++){
        for (int j=0; j<5; j++){
            if (temp[i][j]>maior) maior= temp[i][j];
            if (temp[i][j]<menor) menor= temp[i][j];
            soma+= temp[i][j];
            if (i==j){
                somaPrincipal+= temp[i][j];
            }
        }
    }

    media= soma/25;
    mediaPrincipal= somaPrincipal/5;

    printf("%d %d %d %d", maior, menor, media, mediaPrincipal);

    return 0;
}
