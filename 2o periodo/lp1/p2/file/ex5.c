#include <stdio.h>

void escreverNovoArquivo(char *arquivo, char *texto) {
    FILE *f= fopen(arquivo, "w");
    fprintf(f, "%s", texto);
    fclose(f);
}

void escreverFinalArquivo(char *arquivo, char *texto) {
    FILE *f= fopen(arquivo, "a");
    fprintf(f, "%s", texto);
    fclose(f);
}

void lerArquivo(char *arquivo) {
    FILE *f= fopen(arquivo, "r");
    char linha[256];

    while(fgets(linha, sizeof(linha), f) != NULL) {
        printf("%s", linha);
    }
    fclose(f);
}

void imprimirTexto(char *texto) {
    printf("%s", texto);
}

int main() {
    char *nome= "arquivo.txt";

    escreverNovoArquivo(nome, "linha 1\n");
    escreverFinalArquivo(nome, "linha 2\n");

    printf("conteudo do arquivo:\n");
    lerArquivo(nome);

    imprimirTexto("texto impresso direto\n");

    return 0;
}
