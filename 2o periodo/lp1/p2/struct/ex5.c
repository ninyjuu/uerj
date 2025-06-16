#include <stdio.h>

typedef struct{
    char nome [50];
    int idade;
    float nota;
} Aluno;

void AtualizarNota (Aluno *aluno, float novaNota){
    aluno->nota= novaNota;
}

int main(){
    Aluno a;

    scanf("%s", a.nome);
    scanf("%d", &a.idade);
    scanf("%f", &a.nota);

    float nota;
    scanf("%f", &nota);

    AtualizarNota(&a, nota);

    printf("%s", a.nome);
    printf("%d", a.idade);
    printf("%f", a.nota);

    return 0;

}