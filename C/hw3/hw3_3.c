/*
 * Server : B2
 * �Ǹ�   : F74976120
 * �m�W   : ���ͭ� 
 * �sĶ   : gcc -o hw3_3 hw3_3.c
 * ����   : ./hw3_3 
 * �\��   : �p��۵M���e (Chapter 4 Exercise 39) 
 * ���   : 2008/10/27 
 */

#include <stdio.h> 
#include <stdlib.h>

int main(void){

    int n, i;
    double X0, X1, t;
 
    //�p��e���� 
    for(X1 = 1, n = 1; X0 != X1; n++){
        
        X0 = X1;
        
        //�p�� n! ���� 
        for(i = n, t = 1; i > 0; i--){
            t *= i;
        }
        
        X1 += 1.0 / t;
    
        //�L�X�ثe���Ƥέ�
        printf("%d\n%.16lf\n\n", n, X1);
    }

    return 0;
}
