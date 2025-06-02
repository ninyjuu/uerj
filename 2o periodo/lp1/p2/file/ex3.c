#include <stdio.h>

int main(){
    FILE *pFile;
    char name [100];
    pFile= fopen ("myfile.txt","w");
    for (int n=0; n<3; n++){
        puts("entre com um nome: ");
        fgets(name, 99, stdin);
        fprintf(pFile, "nome %d [%s]\n", n+1, name);
    }
    fflush(pFile);
    fclose(pFile);
    return 0;
}