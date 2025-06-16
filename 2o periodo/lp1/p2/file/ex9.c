#include <stdio.h>

int main(){
    FILE *file;
    file= fopen("texto.txt", "r");
    fprintf(file, "oiiiii");
    fclose(file);
    return 0;
}