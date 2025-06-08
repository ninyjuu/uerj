#include <stdio.h>
#include <stdlib.h>

struct Aluno {
    char nome[50];
    char matricula[20];
    float nota;
};

void cadastrarAluno(struct Aluno *a) {
    int i= 0;
    char c;

    printf("digite nome:\n");
    while((c= getchar()) != '\n' && c != EOF && i < 49) {
        a->nome[i++]= c;
    }
    a->nome[i]= '\0';

    printf("digite matricula:\n");
    i= 0;
    while((c= getchar()) != '\n' && c != EOF && i < 19) {
        a->matricula[i++]= c;
    }
    a->matricula[i]= '\0';

    printf("digite nota:\n");
    scanf("%f", &a->nota);
    getchar();
}

void gravarAlunos(char *arquivo, struct Aluno *alunos, int n) {
    FILE *f= fopen(arquivo, "w");
    for(int i= 0; i < n; i++) {
        fprintf(f, "%s %s %.2f\n", alunos[i].nome, alunos[i].matricula, alunos[i].nota);
    }
    fclose(f);
}

void exibirAlunos(struct Aluno *alunos, int n) {
    for(int i= 0; i < n; i++) {
        printf("nome: %s, matricula: %s, nota: %.2f\n", alunos[i].nome, alunos[i].matricula, alunos[i].nota);
    }
}

int main() {
    struct Aluno *alunos;
    int n= 0;
    char c;

    alunos= (struct Aluno*) malloc(100 * sizeof(struct Aluno));

    if(alunos == NULL) {
        printf("erro ao alocar memoria\n");
        return 1;
    }

    while(n < 100) {
        printf("cadastrar aluno? (s/n)\n");
        c= getchar();
        getchar();
        if(c != 's') break;

        cadastrarAluno(&alunos[n]);
        n++;
    }

    gravarAlunos("alunos.txt", alunos, n);

    printf("alunos cadastrados:\n");
    exibirAlunos(alunos, n);

    free(alunos);
    return 0;
}
