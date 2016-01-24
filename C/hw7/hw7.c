/*
 * Server : B2
 * �Ǹ�   : F74976120
 * �m�W   : ���ͭ�
 * �sĶ   : gcc -o hw7 hw7.c
 * ����   : ./hw7 method_code data_type value
            (method_code : 1 pointer / 2 union )
            (data_type   : int(i) / double(d) / float(f) )
            (Example     : ./hw7 1 double 5.64 )
 * �\��   : �L�X���w�ƭȤ��줸�ϼ�
 * ���   : 2008/01/06
 */

#include <stdio.h>
#include <stdlib.h>
#include <limits.h>

void method_1(char, char[]);    //�Q�Ρupointer�v�B�z�B�I�ƪ���k 
void method_2(char, char[]);    //�Q�Ρuunion�v�B�z�B�I�ƪ���k 
void bitprint(int);

//Union 
union fdi{
    float f;
    double d;
    int i[2];
};

int main(int argc, char *argv[]){

    //�˴��ǤJ�ѼƼƶq�O�_���T
    if(argc != 4){
        printf("Argument count error!\n");
        exit(1);
    }

    //�˴��umethod_code�v�O�_�X�z
    if(argv[1][0] < '1' || argv[1][0] > '2' || argv[1][1] != '\0'){
        printf("Method code error!\n");
        exit(1);
    }

    //�˴��udata_type_code�v�O�_�X�z
    if(argv[2][0] != 'i' && argv[2][0] != 'f' && argv[2][0] != 'd'){
        printf("Data type code error!\n");
        exit(1);
    }

    //�̾ڡumethod_code�v��ܤ�k�éI�s�� 
    switch(argv[1][0]){
        case '1':
            method_1(argv[2][0], argv[3]);
            break;
        case '2':
            method_2(argv[2][0], argv[3]);
    }

    getch();
    putchar('\n');
    return 0;
}


void method_1(char type, char value[]){

    int *i;
    double d;
    float f;

    //�̾ڡudata_type_code�v���O�B�z
    switch(type){
        case 'i':
            i = calloc(1, sizeof(int));       //���t�O����Ŷ�
            i[0] = atoi(value);               //�N�ǤJ�Ѽ��ର���
            bitprint(i[0]);                   //�I�s�ubitprint�v�L�X�줸�ϼ�
            break;
        case 'd':
            d = atof(value);                  //�N�ǤJ�Ѽ��ର�B�I��
            i = (int*)&d;                     //�Ni���Vd�Ҧb��}
            bitprint(i[1]);                   //�I�s�ubitprint�v�L�X�줸�ϼ�
            bitprint(i[0]);                   //�I�s�ubitprint�v�L�X�줸�ϼ�
            break;
        case 'f':
            f = atof(value);                  //�N�ǤJ�Ѽ��ର�B�I��
            i = (int*)&f;                     //�Ni���Vf�Ҧb��}
            bitprint(i[0]);                   //�I�s�ubitprint�v�L�X�줸�ϼ�
    }

    return;
}


void method_2(char type, char value[]){

    union fdi u;

    //�̾ڡudata_type_code�v���O�B�z
    switch(type){
        case 'i':
            u.i[0] = atoi(value);             //�N�ǤJ�Ѽ��ର���
            bitprint(u.i[0]);                 //�I�s�ubitprint�v�L�X�줸�ϼ�
            break;
        case 'd':
            u.d = atof(value);                //�N�ǤJ�Ѽ��ର�B�I��
            bitprint(u.i[1]);                 //�I�s�ubitprint�v�L�X�줸�ϼ�
            bitprint(u.i[0]);                 //�I�s�ubitprint�v�L�X�줸�ϼ�
            break;
        case 'f':
            u.f = atof(value);                //�N�ǤJ�Ѽ��ର�B�I��
            bitprint(u.i[0]);                 //�I�s�ubitprint�v�L�X�줸�ϼ�
    }

    return;
}


void bitprint(int value){

    int i;
    int n = sizeof(int) * CHAR_BIT;           //�p����� 

    //�L�X�줸�ϼ� 
    for(i = n - 1; i >= 0; i--){
        printf("%1d", (value >> i) & 0x00000001);
        if(i % CHAR_BIT == 0) putchar(' ');
    }

    return;
}
