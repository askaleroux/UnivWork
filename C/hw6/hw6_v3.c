/*
 * Server : B2
 * �Ǹ�   : F74976120
 * �m�W   : ���ͭ� 
 * �sĶ   : gcc -o hw6 hw6.c
 * ����   : ./hw6 method_code array_size_1 array_size_2 (EX: ./hw5 c 5 4) 
 * �\��   : �x�}�ۭ� 
 * ���   : 2008/12/13 
 */

#include <stdio.h>
#include <stdlib.h>
#include <time.h>

void method_a(int m, int n, int [][n], int [][m]);
void method_b(int [], int [], int, int);
void method_c(int**, int**, int, int);

int main(int argc, char *argv[]){
    
    //TEST
    argc = 4;
    argv[1] = "c";
    argv[2] = "6";
    argv[3] = "4";
    
    //�˴��ǤJ�ѼƼƶq�O�_���T
    if(argc != 4){
        printf("Argument count error!\n");
        exit(1);
    } 
    
    //�˴��umethod_code�v�O�_�X�z 
    if(argv[1][0] < 'a' || argv[1][0] > 'c' || argv[1][1] != '\0'){
        printf("Method code error!\n");
        exit(1);
    }
    
    //�N�r���ର��� 
    int m = atoi(argv[2]), n = atoi(argv[3]);
    
    //�˴��uarray_size�v�O�_�X�z 
    if(m <= 0 || n <= 0){
        printf("Array size error!\n");
        exit(1);
    }
    
    //���]�üƪ� 
    srand(time(NULL));
    
    //�̡umethod_code�v��ܩҨϥΤ�k�éI�s�� 
    switch(argv[1][0]){
        case 'a': 
            {
            int a[m][n], b[n][m];
            method_a(m, n, a, b);
            }
            break;
        case 'b': ;
            {
            int a[m*n], b[n*m];
            method_b(a, b, m, n);
            }
            break;
        case 'c': 
            {
            int **a, **b;
            method_c(a, b, m, n);
            }
    }
    
    system("pause");
    return 0;
}

void method_a(int m, int n, int a[][n], int b[][m]){

    int c[m][m];
    int i, j, k;
    
    //����A�x�}�æL�X 
    printf("A:\n");
    for(i = 0; i < m; i++){
        for(j = 0; j < n; j++){
            a[i][j] = rand() % 19 - 9;
            printf("%5d", a[i][j]);
        }
        putchar('\n');
    }
    putchar('\n');
    
    //����B�x�}�æL�X 
    printf("B:\n");
    for(i = 0; i < n; i++){
        for(j = 0; j < m; j++){
            b[i][j] = rand() % 19 - 9;
            printf("%5d", b[i][j]);
        }
        putchar('\n');
    }
    putchar('\n');
    
    //�p��A�x�}*B�x�}�æL�X 
    printf("C:\n");
    for(i = 0; i < m; i++){  
        for(j = 0; j < m; j++){
            c[i][j] = 0;
            for(k = 0; k < n; k++)
                c[i][j] = c[i][j] + a[i][k] * b[k][j];
            printf("%5d", c[i][j]);
        }
        putchar('\n');
    }
    putchar('\n');
    
    return;
}

void method_b(int a[], int b[], int m, int n){

    int c[m*m];
    int i, j, k;

    //����A�x�}�æL�X 
    printf("A:\n");
    for(i = 0; i < m; i++){
        for(j = 0; j < n; j++){
            a[i*n+j] = rand() % 19 - 9;
            printf("%5d", a[i*n+j]);
        }
        putchar('\n');
    }
    putchar('\n');

    //����B�x�}�æL�X 
    printf("B:\n");
    for(i = 0; i < n; i++){
        for(j = 0; j < m; j++){
            b[i*m+j] = rand() % 19 - 9;
            printf("%5d", a[i*m+j]);
        }
        putchar('\n');
    }
    putchar('\n');

    //�p��A�x�}*B�x�}�æL�X 
    printf("C:\n");
    for(i = 0; i < m; i++){  
        for(j = 0; j < m; j++){
            c[i*m+j] = 0;
            for(k = 0; k < n; k++)
                c[i*m+j] = c[i*m+j] + a[i*n+k] * b[k*m+j];
            printf("%5d", c[i*m+j]);
        }
        putchar('\n');
    }
    putchar('\n');
    
    return;
}

void method_c(int **a, int **b, int m, int n){

    int **c;
    int i, j, k;

    //����A�x�}�æL�X
    printf("A:\n");
    a = calloc(m, sizeof(int));
    for(i = 0; i < m; i++){
        a[i] = calloc(n, sizeof(int));
        for(j = 0; j < n; j++){
            a[i][j] = rand() % 19 - 9;
            printf("%5d", a[i][j]);
        }
        putchar('\n');
    }
    putchar('\n');

    //����B�x�}�æL�X 
    printf("B:\n");
    b = calloc(n, sizeof(int));
    for(i = 0; i < n; i++){
        b[i] = calloc(m, sizeof(int));
        for(j = 0; j < m; j++){
            b[i][j] = rand() % 19 - 9;
            printf("%5d", b[i][j]);
        }
        putchar('\n');
    }
    putchar('\n');

    //�p��A�x�}*B�x�}�æL�X 
    printf("C:\n");
    c = calloc(m, sizeof(int));
    for(i = 0; i < m; i++){
        c[i] = calloc(m, sizeof(int));
        for(j = 0; j < m; j++){
            c[i][j] = 0;
            for(k = 0; k < n; k++)
                c[i][j] = c[i][j] + a[i][k] * b[k][j];
            printf("%5d", c[i][j]);
        }
        putchar('\n');
    }
    putchar('\n');
    
    return;
}
