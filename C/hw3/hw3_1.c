/*
 * Server : B2
 * �Ǹ�   : F74976120
 * �m�W   : ���ͭ� 
 * �sĶ   : gcc -o hw3_1 hw3_1.c
 * ����   : ./hw3_1 
 * �\��   : �p���J��a������� (Chapter 4 Exercise 36) 
 * ���   : 2008/10/27 
 */

#include <stdio.h> 
#include <stdlib.h>

int main(void){

    int a, i, f;
    double X0, X1 = 1;
    
    //�n�D��Ja�ȡA��a�Ȥp��0�ɭn�D���s��J 
    do{

        printf("Enter the number a : ");
        scanf("%d", &a);
    
    }while(a < 0);

    //�p��a������� 
    for(X1 = 1, i = 1; X0 != X1; i++){
        
        X0 = X1;
        X1 = 0.5 * (X1 + a / X1);
    
        //�L�X�ثe���ơB�Ȥλ~�t 
        printf("\ni\t= %d\nX1\t= %.16lf\nd\t= %.16lf\n", i, X1, a - X1 * X1);
    }

    return 0;
}
