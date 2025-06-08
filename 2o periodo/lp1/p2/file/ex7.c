#include <stdio.h>

struct Aluno {
    char nome[50];
    char matricula[20];
    float nota;
};

int compararPrefixo(char *linha, char *nome) {
    int i= 0;
    while(nome[i] != '\0' && linha[i] != '\0') {
        if(linha[i] != nome[i]) return 0;
        i++;
    }
    if(nome[i] == '\0') return 1;
    return 0;
}

int buscarAlunoPorNome(char *arquivo, struct Aluno *a) {
    FILE *f= fopen(arquivo, "r");
    char linha[100];
    int encontrou= 0;

    if(f == NULL) return 0;

    while(fgets(linha, sizeof(linha), f)) {
        if(compararPrefixo(linha, a->nome)) {
            encontrou= 1;
            break;
        }
    }

    fclose(f);
    return encontrou;
}

int main() {
    struct Aluno a;
    int i= 0;
    char c;

    printf("digite o nome para buscar:\n");

    while((c= getchar()) != '\n' && c != EOF && i < 49) {
        a.nome[i++]= c;
    }
    a.nome[i]= '\0';

    if(buscarAlunoPorNome("alunos.txt", &a)) {
        printf("aluno encontrado\n");
    } else {
        printf("aluno nao encontrado\n");
    }

    return 0;
}
