/*
 * Server : B2
 * �Ǹ�   : F74976120
 * �m�W   : ���ͭ� 
 * �sĶ   : gcc -o hw3_2 hw3_2.c -lm 
 * ����   : ./hw3_2 
 * �\��   : �p��۵M���e (Chapter 4 Exercise 38) 
 * ���   : 2008/10/27 
 */

#include <stdio.h> 
#include <stdlib.h>
#include <math.h>

int main(void){

    int n;
    double X0, X1;

    //�p��e���� 
    for(X1 = 1, n = 1; X0 != X1; n++){
        
        X0 = X1;
        X1 = pow(1.0 + 1.0 / n, n);
    
        //�L�X�ثe���Ƥέ�(�|�y������t�פj�T���C) 
        //printf("n = %d\ne = %.16lf\n\n", n, X1);
    }
    
    //�L�X�`�@�����Ƥγ̫ᤧe��
    printf("n\t= %d\ne\t= %.16lf\n\n", n, X1);

    return 0;
}
