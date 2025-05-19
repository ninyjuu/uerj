#include <stdio.h>
struct estudante{
    int idade, matricula, periodo;
    float coeficiente;
};
int main(){
    struct estudante aluno, copia;
    scanf("%d %d %f %d", &aluno.idade, &aluno.matricula, &aluno.coeficiente, &aluno.periodo);
    copia= aluno;
    printf("i=%d m=%d c=%0.2f p=%d\n", copia.idade, copia.matricula, copia.coeficiente, copia.periodo);
    return 0;
}