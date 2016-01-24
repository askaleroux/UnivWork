/*
 * Server : B2
 * �Ǹ�   : F74976120
 * �m�W   : ���ͭ� 
 * �sĶ   : gcc -o hw1_1 hw1_1.c
 * ����   : ./hw1_1 (./hw1_1 < data)
 * �\��   : �p�⥭���� (Chapter 1 Exercise 15) 
 * ���   : 2008/10/07 
 */
 
/*
 * �{�������z:
 *  
 * avg_ori=�쥭�� ; avg_new=�s����
 * sum_ori=���`�M ; sum_new=�s�`�M
 * 
 * avg_new = avg_ori + (x - avg_ori) / i
 *         = (avg_ori * i + (x - avg_ori)) / i
 *         = (avg_ori * (i - 1) + x) / i
 *         = (sum_ori + x) / i
 *         = sum_new / i
 *
 * avg = avg + (x - avg) / i = sum / i = navg 
 * 
 */ 

#include <stdio.h>

int main(void)
{
    int i;
    double x,avg = 0.0, navg, sum = 0.0;
    
    //�C�L���Y�ܿù� 
    printf("%5s%17s%17s%17s\n%5s%17s%17s%17s\n\n", "Count", "Item", "Average", 
        "Naive avg", "-----", "----", "-------", "---------");
    
    //�N��J�ȭp���`�M�Υ����æC�L�ܿù������J�Ȥ��O�Ʀr 
    for (i = 1; scanf("%lf", &x) == 1; i++) {
        avg += (x - avg) / i;
        sum += x;
        navg = sum / i;
        printf("%5d%17e%17e%17e\n", i, x, avg, navg);
    }
    
    return 0;
}
