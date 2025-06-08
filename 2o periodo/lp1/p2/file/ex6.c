#include <stdio.h>

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

void gravarAluno(char *arquivo, struct Aluno *a) {
    FILE *f= fopen(arquivo, "a");
    fprintf(f, "%s %s %.2f\n", a->nome, a->matricula, a->nota);
    fclose(f);
}

int main() {
    struct Aluno a;

    cadastrarAluno(&a);
    gravarAluno("alunos.txt", &a);

    printf("aluno cadastrado e gravado\n");

    return 0;
}
