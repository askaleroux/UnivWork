/*
 * Server : B2
 * �Ǹ�   : F74976120
 * �m�W   : ���ͭ� 
 * �sĶ   : gcc -o hw4 hw4.c
 * ����   : ./hw4 hw4_input.txt hw4_output.txt (./hw4 hw4_input.txt) 
 * �\��   : ���k��� 
 * ���   : 2008/11/12 
 */

#include <stdio.h>
#include <stdlib.h>

void Argument_Check(int);
void File_Open(char *[]);
int File_Input(void);
void File_Process(int);
void File_Output(void);
void File_Close(void);

int output_to_file;
char line_input[81], line_output[81];
FILE *input_file, *output_file;

int main(int argc, char *argv[]){

    int n = 81;

    Argument_Check(argc);
    File_Open(argv);
    
    while(n == 81){
            
        n = File_Input();
        File_Process(n);
        File_Output();
        
    }
    
    File_Close();
    printf("\n\n");
    return 0;
}

void Argument_Check(int argc){
    
    //�˴��ǤJ�ѼƼƶq (2:�ȿ�X�ܿù�; 3:��X�ܿù����ɮ�)
    if(argc == 2){
        output_to_file = 0;
    }else if(argc == 3){
        output_to_file = 1;
    }else{
        printf("Argument count error!\n");
        exit(1);
    }

    return;
    
}

void File_Open(char *argv[]){
    
    //�}���ɮ�   
    input_file = fopen(argv[1], "r");
    if(output_to_file == 1) output_file = fopen(argv[2], "w");
    
    //�˴��ɮ׬O�_�s�b 
    if(input_file == NULL){
        printf("Open file error!\n");
        exit(1);
    }

    return;

}

int File_Input(void){
    
    //���ձq�ɮ�Ū��81�r���æ^�Ǧ��\Ū���r���� 
    return fread(line_input, sizeof(char), 81, input_file);

}

void File_Process(int n){
     
    int space_count, space, newline_count, newline;
    int i, j, k, seek, space_remain, space_least, space_plus;

    space_count = newline_count = 0;                    //�p�ƥ��ܼ��k�s 
        
    //�p���ťզr���δ���r�����ƶq�Φ�m 
    for(i = 0; i < n; i++){
        switch(line_input[i]){
            case ' ':
                space = i;
                space_count++;
                break;
            case '\n':
                newline = i;
                newline_count++;
        }
    }

    //�ɧ��{�� 
    if(n < 81){
                     
        //�̧ǦC�L�r����ù����쵲�� 
        for(i = 0; i < n; i++){
            line_output[i] = line_input[i];
        }
        line_output[i] = '\0';

    //�q���{�� 
    }else if(newline_count > 0){

        seek = newline - 80;                          //�p���ɮפ���m�ץ��q  
            
        //�̧ǦC�L�r����ù����촫�� 
        for(i = 0; i <= newline; i++){
            line_output[i] = line_input[i];
        }
        line_output[i] = '\0';
        
    //�@��{�� 
    }else{
        
        seek = space - 80;                            //�p���ɮפ���m�ץ��q         
        space_remain = 80 - space;                    //�p��h�l���ťզr�� 
        space_least = space_remain / space_count;     //�p��C���j�̧C�W�[�e�� 
        space_plus = space_remain % space_count;      //�p����B�~�W�[�e�פ��ƶq 
        
        //�̧ǦC�L�r����ù�����̫�@�Ӫťզr�� 
        for(i = 0, k = 0; i < space; i++){
            line_output[k++] = line_input[i];
                
            //���t�h�l���ťզr�� 
            if(line_input[i] == ' '){
                for(j = 0; j < space_least; j++){
                    line_output[k++] = ' ';
                }
                if(space_plus > 0){
                    line_output[k++] = ' ';
                    space_plus--;
                }
            }
        }
        line_output[k] = '\n';
    }
        
    //�ץ���m 
    fseek(input_file, seek, SEEK_CUR);
    
    return;

}

void File_Output(void){

    //�N�B�z���������X 
    printf("%s", line_output);
    if(output_to_file == 1) fprintf(output_file, "%s", line_output);

    return;
    
}

void File_Close(void){

    //�����ɮ� 
    fclose(input_file);
    if(output_to_file == 1) fclose(output_file);
    
    return;

}
