/*
 * Server : B2
 * �Ǹ�   : F74976120
 * �m�W   : ���ͭ� 
 * �sĶ   : gcc -o hw2 hw2.c
 * ����   : ./hw2 hw2_input.txt hw2_output.txt (./hw2 hw2_input.txt) 
 * �\��   : ���k��� 
 * ���   : 2008/10/15 
 */

#include <stdio.h>
#include <stdlib.h>

int main(int argc, char *argv[])
{
    FILE *ipf, *opf;
    int n, i , j, spc, sp[80], nlc, nl[80], m, r, x, y;
    char c[81];
    
    //�˴��ǤJ�ѼƼƶq (2:�ȿ�X�ܿù�; 3:��X�ܿù����ɮ�)
    if(argc < 2 || argc > 3){
        printf("Argument count error!\n");
        exit(1);
    }
    
    ipf = fopen(argv[1], "r");
    if(argc == 3) opf = fopen(argv[2], "w");
    
    //�˴��ɮ׬O�_�s�b 
    if(ipf == NULL){
        printf("Open file error!\n");
        exit(1);
    }
    
    while((n = fread(c, sizeof(char), 81, ipf)) > 0){
        spc = nlc = 0;    //�p�ƥ��ܼ��k�s 
        
        //�p���ťզr���δ���r�����ƶq�Φ�m 
        for(i = 0; i < n; i++){
            switch(c[i]){
                case ' ':
                    sp[spc] = i;
                    spc++;
                    break;
                case '\n':
                    nl[nlc] = i;
                    nlc++;
            }
        }
        
        //�ɧ��{�� 
        if(getc(ipf) == EOF){
                     
            //�̧ǦC�L�r����ù����쵲�� 
            for(i = 0; i < n; i++){
                putchar(c[i]);
                if(argc == 3) putc(c[i], opf);
            }
        
        //�q���{�� 
        }else if(nlc > 0){
            m = nl[nlc-1] - 82;    //�p���ɮפ���m�ץ��q  
            
            //�̧ǦC�L�r����ù����촫�� 
            for(i = 0; i <= nl[0]; i++){
                putchar(c[i]);
                if(argc == 3) putc(c[i], opf);
            }
        
        //�@��{�� 
        }else{
        
            m = sp[spc-1] - 82;    //�p���ɮפ���m�ץ��q         
            r = 80 - sp[spc-1];    //�p��h�l���ťզr�� 
            x = r / spc;           //�p��C���j�̧C�W�[�e�� 
            y = r % spc;           //�p����B�~�W�[�e�פ��ƶq 
        
            //�̧ǦC�L�r����ù�����̫�@�Ӫťզr�� 
            for(i = 0; i < sp[spc-1]; i++){
                putchar(c[i]);
                if(argc == 3) putc(c[i], opf);
                
                //���t�h�l���ťզr�� 
                if(c[i] == ' '){
                    for(j = 0; j < x; j++){
                        putchar(' ');
                        if(argc == 3) putc(' ', opf);
                    }
                    if(y > 0){
                        putchar(' ');
                        if(argc == 3) putc(' ', opf);
                        y--;
                    }
                }
            }
        }
        putchar('\n');
        if(argc == 3) putc('\n', opf);
        
        //�ץ���m 
        if(getc(ipf) != EOF) fseek(ipf, m, SEEK_CUR);
    }
    
    fclose(ipf);
    if(argc == 3) fclose(opf); 
    return 0;
}
