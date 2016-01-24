#include <iostream>
#include <conio.h>
#include <time.h>
using namespace std;

//�}�C�j�p�W��
#define MAX_SIZE 100

int main(){

	int n, x, i, j, c = 0;
	int **a, *b;

	//���m�üƪ�
	srand((unsigned)time(NULL));

	//����
	cout << "Please enter the size of the matrix (1~" << MAX_SIZE << "): ";
	cin >> n;

	//���b
	while(n < 1 || n > MAX_SIZE){
		cout << "Out of range, please enter the size of the matrix (1~" << MAX_SIZE << "): ";
		cin >> n;
	}

	//����
	cout << "Please choose the type of the matrix (0:Upper / 1:Lower): ";
	cin >> x;

	//���b
	while(x < 0 || x > 1){
		cout << "Out of range, please choose the type of the matrix (0:Upper / 1:Lower): ";
		cin >> x;
	}

	system("cls");
	cout << n << " x " << n << (x == 0 ? " Upper" : " Lower") << " Triangular Matrix\n";

	//�t�m�G���}�C
	a = new int *[n];
	for(i = 0; i < n; i++) a[i] = new int [n];

	//��J�ƭ�
	for(i = 0; i < n; i++){
		for(j = 0; j < n; j++){
			a[i][j] = ((x == 0 && i > j) || (x == 1 && i < j)) ? 0 : (rand() % 8 + 1);
			cout << "  " << a[i][j];
		}
		cout << "\n";
	}

	cout << "\n\nBefore:\n";

	for(i = 0; i < n; i++)
		for(j = 0; j < n; j++)
			cout << "A[" << i << "][" << j << "]=\t" << a[i][j] << "\n";

	cout << "\n\nAfter:\n";

	//�t�m�@���}�C
	b = new int [(1 + n) * n / 2];

	//�ഫ
	for(i = 0; i < n; i++)
		for(j = (x == 0 ? i : 0); j < (x == 0 ? n : i + 1); j++){
			b[c] = a[i][j];
			cout << "B[" << c << "]=\t\t" << b[c++] << "\n";
		}

	_getch();
	return 0;
}