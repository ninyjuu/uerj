#include <stdio.h>

int main(){
    char str [80];
    float f;
    FILE *pFile;
    pFile= fopen ("myfile.txt","w+");
    fprintf(pFile, "%f %s", 3.1416, "PI");
    fflush(pFile);
    rewind(pFile);
    fscanf(pFile, "%f", &f);
    fscanf(pFile, "%s", str);
    fclose(pFile);
    printf("conteudo lido: %f and %s \n", f, str);
    return 0;
}