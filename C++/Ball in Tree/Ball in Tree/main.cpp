#include <iostream>
#include <cmath>

using namespace std;

int main(void){

	char i[12];
	int d, b, n, c;
	int *t, *p;

	do{
		system("cls");

		//���o�𤧲`�פΨ��b
		cout << "Enter the depth of the tree: ";
		cin >> i;
		d = atoi(i);
		while(d < 1 || d > 30){
			cout << "Error! The depth shoud be a integer bigger than '0' and smaller then '30'\nEnter the depth of the tree: ";
			cin >> i;
			d = atoi(i);
		}

		n = (int) pow(2.0, d - 1);

		//���o�y���s���Ψ��b
		cout << "Enter the number of the ball: ";
		cin >> i;
		b = atoi(i);
		while(b < 1){
			cout << "Error! The number shoud be a integer bigger than '0'!\nEnter the number of the ball: ";
			cin >> i;
			b = atoi(i);
		}
		if(b > n) b %= n;

		//���t�}�C�Ŷ�
		p = new int[d - 1];
		t = new int[n];
		for(d = 1; d < n; d++) t[d] = 0;

		//�p��y�����I�M���|
		for(; b > 0; b--) for(c = 1, d = 0; c < n; p[d++] = c, t[c] = !t[c], c = c * 2 + !t[c]);

		//�L�X���G
		cout << "\nThe ball finally fell in node(" << c << ")\nThe path of the ball: ";
		for(n = 0; n < d; n++) cout << p[n] << " -> ";
		cout << c << "\n\n";

		//����Ŷ�
		delete t;
		delete p;

		//�P�_�O�_�~��
		cout << "Enter '1' if you want to run the program again: ";
		cin >> i;
		c = atoi(i);

	}while(c == 1);

	return 0;
}