/*
 * Server : B2
 * �Ǹ�   : F74976120
 * �m�W   : ���ͭ� 
 * �sĶ   : gcc -o hw5 hw5.c -lm 
 * ����   : ./hw5 method_code array_size (EX: ./hw5 3 16) 
 * �\��   : �}�C�Ƨ� 
 * ���   : 2008/12/10 
 */

#include <assert.h>
#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include <time.h>

void merge(int [], int [], int [], int, int);
void mergesort_1(int [], int);
void mergesort_2(int [], int);
void mergesort_3(int [], int);
void mergesort_4(int [], int);
void wrt(int [], int);

int main(int argc, char *argv[]){
       
    //�˴��ǤJ�ѼƼƶq�O�_���T
    if(argc != 3){
        printf("Argument count error!\n");
        exit(1);
    } 
    
    int i, n = 0;
    
    //�N�ǤJ�Ѽơuarray_size�v�ର��� 
    for(i = 0; argv[2][i] >= '0' && argv[2][i] <= '9'; i++)
        n = 10 * n + (argv[2][i] - '0');

    //�˴��uarray_size�v�O�_�X�z 
    if(n == 0){
        printf("Array size error!\n");
        exit(1);
    }
    
    //�˴��umethod_code�v�O�_�X�z 
    if(argv[1][0] < '0' || argv[1][0] > '4' || argv[1][1] != '\0'){ 
        printf("Method code error!\n");
        exit(1);
    }
    
    int sz, key[n];
    
    //�üƲ��ͭȬ� -99 �� +99 ���}�C 
    srand(time(NULL));
    for(i = 0; i < n; i++){
        key[i] = rand() % 199 - 99;
    }
    
    //�p��}�C�j�p 
    sz = sizeof(key) / sizeof(int);
    
    //�C�L�Ƨǫe�}�C�ܿù� 
    printf("Before mergesort:\n");
    wrt(key, sz);
    
    //�̾ڡumethod_code�v�M�w�ϥΤ��ƧǤ�k�éI�s�� 
    switch(*argv[1]){
        case '1':
            mergesort_1(key, sz);
            break;
        case '2':
            mergesort_2(key, sz);
            break;
        case '3':
            mergesort_3(key, sz);
            break;
        case '4':
            mergesort_4(key, sz);
    }
    
    //�C�L�Ƨǫ�}�C�ܿù� 
    printf("After mergesort:\n");
    wrt(key, sz);

    return 0;
}

void merge(int keya[], int keyb[], int keyc[], int sza, int szb){

    int i = 0, j = 0, k = 0;
    
    //���AB��}�C�ӧO���̤p�ȡA�ñN���p�̩�JC�}�C 
    while(i < sza && j < szb)
        if(keya[i] < keyb[j]) keyc[k++] = keya[i++];
        else keyc[k++] = keyb[j++];

    //�N�Ѿl���ȩ�JC 
    while(i < sza) keyc[k++] = keya[i++];
    while(j < szb) keyc[k++] = keyb[j++];

    return;
}

void mergesort_1(int key[], int sz){

    int j, k, m, *w;
    
    //�˴��}�C�j�p�O�_��2������ 
    for(m = 1; m < sz; m *= 2);
    if(sz < m){
        printf("Array size error!\n");
        exit(1);
    }
    
    //���tW���Ŷ����˴� 
    w = calloc(sz, sizeof(int));
    assert(w != NULL);
    
    //�M�w�n�ǤJmerge�����סA�q1�}�l
    for(k = 1; k < sz; k *= 2){
          
        //�M�w�n�ǤJmerge���_�l��}�A�q0�}�l 
        for(j = 0; j < sz - k; j += 2 * k)
            merge(key + j, key + j + k, w + j, k, k);
            
        //�NW�����ȩ�^Key�� 
        for(j = 0; j < sz; j++) key[j] = w[j];
    }
    
    return;
}

void mergesort_2(int key[], int sz){

    int i, j, k , m = 0, *w;
    int q = sz, r[sz], d = 0;
    
    //�N��}�C�j�p��Ҭ�2������ 
    while(q != 0){
        r[d++] = q % 2;
        q = q / 2;
    }

    //���tW���Ŷ����˴� 
    w = calloc(sz, sizeof(int));
    assert(w != NULL);
    
    //�M�w����n�B�z������A�q0�}�l 
    for(i = 0; i < d; i++){
          
        //�Y�}�C�S�����Ψ즹�j�p�h�����B�z 
        if(r[i] == 1){
            
            //�M�w�n�ǤJmerge�����סA�q1�}�l
            for(k = 1; k < pow(2, i); k *= 2){
                  
                //�M�w�n�ǤJmerge���_�l��}�A�q0�}�l 
                for(j = 0; j < pow(2, i) - k; j += 2 * k)
                    merge(key + m + j, key + m + j + k, w + m + j, k, k);
                    
                //�NW�����ȩ�^Key��
                for(j = m; j < m + pow(2, i); j++) key[j] = w[j];
            }
            
            //�N��B�z�����}�C�P���e���}�C�X�֨ñƧ� 
            merge(key, key + m, w, m, pow(2, i));
            for(k = 0; k < m + pow(2, i); k++) key[k] = w[k];
            
            //�p��w�B�z���������� 
            m += pow(2, i);
        }
    }
    
    return;
}

void mergesort_3(int key[], int sz){
     
    int j, k, *w, d = 0;
    
    //���tW���Ŷ����˴� 
    w = calloc(sz, sizeof(int));
    assert(w != NULL);

    //�M�w�n�ǤJmerge�����סA�q1�}�l
    for(k = 1; k < sz; k *= 2){

        //�M�w�n�ǤJmerge���_�l��}�A�q0�}�l 
        for(j = 0; j < sz - k; j += 2 * k)
            merge(key + j, key + j + k, w + j, (sz - j >= k ? k : sz - j)
                         , (sz - j - k >= k ? k :sz - j - k));

        //�D2������ɳB�z�{�� 
        if(sz % 2 != 0){
            if(d == 0) w[j] = key[j];
            d = 1;
        }

        //�NW�����ȩ�^Key�� 
        for(j = 0; j < sz; j++) key[j] = w[j];
    }
}

void mergesort_4(int key[], int sz){
    
    int tmp, i, j, k, *w;
   
    //�}�C�j�p��1�h���i��B�z 
    if(sz == 1) return;
    
    //�}�C�j�p��2�h�����Ƨ� 
    if(sz == 2){
        if(key[0] > key[1]){
            tmp = key[0];
            key[0] = key[1];
            key[1] = tmp;
        }
        return;
    }
    
    //�p��N�}�C�����ⳡ�����ӧO���� 
    j = sz / 2;
    k = sz - j;
    
    //�N���Ϊ��ⳡ���A�ǤJ��Function 
    mergesort_4(key, j);
    mergesort_4(key + j, k);
    
    //���tW���Ŷ����˴� 
    w = calloc(sz, sizeof(int));
    assert(w != NULL);
    
    //�X�֨ñƧǰ}�C 
    merge(key, key + j, w, j, k);
    for(i = 0; i < sz; i++) key[i] = w[i];
    
    return;
}

void wrt(int key[], int sz){
    
    int i;
    
    //�̧ǱN�}�C�L�ܿù� 
    for(i = 0; i < sz; i++)
        printf("%4d%s", key[i], ((i < sz - 1) ? "" : "\n")); 
        
    return;
} 
