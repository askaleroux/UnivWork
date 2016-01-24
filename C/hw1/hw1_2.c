/*
 * Server : B2
 * �Ǹ�   : F74976120
 * �m�W   : ���ͭ� 
 * �sĶ   : gcc -o hw1_2 hw1_2.c
 * ����   : ./hw1_2 
 * �\��   : �ϥ� putchar() �N�r��C�L�ܿù� (Chapter 1 Exercise 25) 
 * ���   : 2008/10/07 
 */

#include <stdio.h>
#include <string.h>

#define MAXSTRING 100

void prn_string(char *); 

int main(void)
{
    char s1[MAXSTRING], s2[MAXSTRING];
    
    //�r��s�J�r���}�C�éI�s prn_string() �C�L�� 
    strcpy(s1, "Mary, Mary, quite contrary, \n");
    strcpy(s2, "how does your garden grow?\n");
    prn_string(s1);
    prn_string(s2);
    
    //�X�֨�r���}�C�éI�s prn_string() �C�L�� 
    strcat(s1, s2);
    prn_string(s1);
    
    return 0;
}

//�N�ǤJ���r���}�C�C�L�ܿù�
void prn_string(char *s)
{
    int i;
    
    //�N�ǤJ���r���}�C�q�Y�}�l�C�L�ܿù�����r����'\0'���� 
    for(i = 0; s[i] != '\0'; i++) {
        putchar(s[i]);
    }
    
    return;
}
