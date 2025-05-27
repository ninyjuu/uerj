#include <stdio.h>

int main() {
    int m, n, i, j, num;
    int cont= 0;
    scanf("%d %d", &m, &n);
    int mat[m][n];

    for(i= 0; i< m; i++)
        for(j= 0; j< n; j++)
            scanf("%d", &mat[i][j]);

    scanf("%d", &num);

    for(i= 0; i< m; i++)
        for(j= 0; j< n; j++)
            if(mat[i][j]== num)
                cont++;

    printf("%d\n", cont);

    return 0;
}
