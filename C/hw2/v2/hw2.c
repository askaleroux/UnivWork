/*********************************************
* Server�N��: B1
* �Ǹ�: F74972281
* �m�W: ������
* �sĶ�覡: gcc -o hw2_1 hw2_1.c
* ����覡: ./hw2_1
* �{���\��: ���k���,�@��K�Q�r 
* ��s���: 2008.10.20
*********************************************/
#include <stdio.h>
#include <stdlib.h>
int main(void)
{
    int i,j,k,a[81], e=0,m,d;
    
    
    FILE *ifp,*ofp;
    char ch[81];
    
    ifp = fopen("input.txt","r");  //Ū���ɮ� 
    ofp = fopen("output.txt","w");//��X�ɮ� 
    while(e==0){                    
 
  j=0; 
  m=-1;
  
  for(i=0;i<81;++i){//�qifpŪ���r���s��ch[i] 
   ch[i] = getc(ifp);
   if(ch[i]==' '){//��Ū��"�Ů�"�s��a[j] 
    a[j]=i;
    j++;   
   }else if(ch[i]=='\n'){//��Ū��"�_��"�s��m 
    m=i;
   }else if(ch[i]==EOF){//�ˬd�O�_��Ū���ɧ� 
    e=1;
   }
  }
  
  if(m==-1){//Ū��̫�@��"�ť�" 
   k=81-a[j-1];
   d=a[j-1];
   for(i=0;i<a[j-1];++i){
    putc(ch[i],ofp);//��X�r�� 
    if(ch[i]==' ' && k>0){//�����󦨥߮�,��X�@��"�ť�" 
     putc(' ' ,ofp);
     k--;
    } 
   }
  }else if(m>=0){
   d=m;
   for(i=0;i<m;++i){//��Ū�����_��,����_�� 
    putc(ch[i],ofp);
   }
  }
  putc('\n',ofp);//��X�@���_�� 
  
  if(e==0)fseek(ifp,-(80-d),SEEK_CUR);//�^�_�쥼��X���a�� 
 }
 fclose(ofp);   //������X�ɮ� 
 fclose(ifp);   //����Ū���ɮ� 
 return 0;
}
