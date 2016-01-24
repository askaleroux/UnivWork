#include <iostream>
#include <fstream>
#include <conio.h>
#include <math.h>
using namespace std;

#define MAX_SIZE 50

typedef struct entryNode{
	int row;
	int col;
	int value;
} NNODE;

typedef struct matrixNode{
	struct matrixNode *down;
	struct matrixNode *right;
	int tag;
	union{
		struct matrixNode *next;
		NNODE entry;
	} u;
} MNODE;

MNODE *head[MAX_SIZE];

//Ū���x�}
MNODE* mread(char *fileName){

	int numTerms = 0, numHeads = 0;
	int row, col, value;
	int i, m, tmp;
	MNODE *temp, *last, *node;

	//�}���ɮ�
	fstream fileInput;
	fileInput.open(fileName, ios::in|ios::binary);

	//�ɮ׿��~�ﵦ
	if(!fileInput || fileInput.eof()) return NULL;
	else{
		//���t�_�l�I�Ŷ�
		node = new MNODE;
		node -> tag = 1;

		//Ū���ɮצ��ɮ׵���
		for(row = col = 0; !fileInput.eof(); col++){

			//�S���Ӧ檺Head�h��l�Ƥ�
			if(!head[col]){
				numHeads++;
				temp = new MNODE;
				head[col] = temp;
				head[col] -> tag = 0;
				head[col] -> right = temp;
				head[col] -> u.next = temp;
			}

			//��l��last
			if(col == 0 && row == 0) last = head[0];

			//�C���q�ɮ�Ū��1�r������/t,/n,EOF
			for(tmp = fileInput.get(), i = value = 0, m = 1; tmp != 9 && tmp != 13 && tmp != -1; tmp = fileInput.get(), i++){
				
				//Ū��/r�ɪ�Y�N����
				if(tmp == 10){

					//�A�hŪ��1/t,/r,/n�H�~���r��
					for(tmp = fileInput.get(); tmp == 9 || tmp == 10 || tmp == 13; tmp = fileInput.get());

					//�Y��EOF��U�欰�Ŧ� ���}�j��
					if(tmp == -1){
						col--;
						break;
					}else{

						//���C�B�z
						last -> right = head[row];
						last = head[++row];
						col = 0;

						//�S���ӦC��Head�h��l�Ƥ�
						if(!head[row]){
							numHeads++;
							temp = new MNODE;
							head[row] = temp;
							head[row] -> tag = 0;
							head[row] -> right = temp;
							head[row] -> u.next = temp;
						}
					}
				}

				//Ū��t�����B�z
				if(tmp == 45) i = m = -1;

				//Ū��Ʀr�h�p��X��
				else value = tmp - 48 + value * (int)pow(10.0, i);
			}

			//�p�G�ȫD�s�h�s�W�`�I
			if(value){
				numTerms++;
				temp = new MNODE;
				temp -> tag = 1;
				temp -> u.entry.col = col;
				temp -> u.entry.row = row;
				temp -> u.entry.value = value * m;
				last -> right = temp;
				last = temp;
				head[col] -> u.next -> down = temp;
				head[col] -> u.next = temp;
			}
		}

		//�����̫�@�C���s��
		last -> right = head[row];

		//�s�J�}�C�����e�ΫD�s�ȼƶq
		node -> u.entry.row = row + 1;
		node -> u.entry.col = col;
		node -> u.entry.value = numTerms;

		//�s��Head
		for(i = 0; i < col; i++) head[i] -> u.next -> down = head[i];
		for(i = 0; i < numHeads - 1; i++) head[i] -> u.next = head[i + 1];
		head[numHeads - 1] -> u.next = node;
		node -> right = head[0];

		//���mHead
		for(i = 0; i < numHeads; i++) head[i] = NULL;
	}

	//�����ɮ�
	fileInput.close();

	return node;
}

//�L�X�x�}
void mwrite(MNODE *node){

	MNODE *temp, *head;
	int i;

	//��X�}�C���e�ΫD�s�ȭӼ�
	cout << '(' << node -> u.entry.row << ", " << node -> u.entry.col << ", " << node -> u.entry.value << ")\n";

	//�̧ǿ�X�`�I
	for(head = node -> right, i = 0; i < node -> u.entry.row; i++, head = head -> u.next)
		for(temp = head -> right; temp != head; temp = temp -> right) cout << '(' << temp -> u.entry.row << ", " << temp -> u.entry.col << ", " << temp -> u.entry.value << ")\n";

	return;
}

//��X�x�}
void moutput(MNODE *node, char *fileName){

	MNODE *temp, *head;
	int i, j, col = 0;
	fstream fileOutput;

	fileOutput.open(fileName, ios::out|ios::binary);
	head = node -> right;

	for(i = 0; i < node -> u.entry.row; i++, head = head -> u.next, col = 0){
		if(i != 0) fileOutput << "\r\n";
		for(temp = head -> right; temp != head; temp = temp -> right){
			for(j = col; j < temp -> u.entry.col; j++) fileOutput << (j > 0 ? "\t" : "") << '0';
			fileOutput << (temp -> u.entry.col > 0 ? "\t" : "") << temp -> u.entry.value;
			col = temp -> u.entry.col + 1;
		}
		for(j = col; j < node -> u.entry.col; j++) fileOutput << (col > 0 ? "\t" : "") << '0';
	}

	fileOutput.close();
	return;
}

//��m�x�}
MNODE* mtrans(MNODE *nodei){

	MNODE *node, *temp, *last, *tempi, *headi;
	int i, numHeads;

	//�x�}���s�b�ﵦ
	if(!nodei) return NULL;
	else{

		//�p��Head�ƶq
		numHeads = (nodei -> u.entry.row > nodei -> u.entry.col) ? nodei -> u.entry.row : nodei -> u.entry.col;

		//��l��Node
		node = new MNODE;
		node -> tag = 1;
		node -> u.entry.row = nodei -> u.entry.col;
		node -> u.entry.col = nodei -> u.entry.row;
		node -> u.entry.value = nodei -> u.entry.value;

		//��l��Head
		for(i = 0; i < numHeads; i++){
			temp = new MNODE;
			head[i] = temp;
			head[i] -> tag = 0;
			head[i] -> right = temp;
			head[i] -> u.next = temp;
		}

		//�̧ǳB�z�C�C
		for(i = 0, headi = nodei -> right; i < node -> u.entry.row; i++){
			last = head[i];

			//�̧�Ū���ӷ���i�椧�ȩ�J��i�C��
			for(tempi = headi -> down; tempi != headi; tempi = tempi -> down){
				temp = new MNODE;
				temp -> tag = 1;
				temp -> u.entry.col = tempi -> u.entry.row;
				temp -> u.entry.row = tempi -> u.entry.col;
				temp -> u.entry.value = tempi -> u.entry.value;
				head[tempi -> u.entry.row] -> u.next -> down = temp;
				head[tempi -> u.entry.row] -> u.next = temp;
				last -> right = temp;
				last = temp;
			}
			headi = headi -> u.next;
			last -> right = head[i];
		}

		//�s��Head
		for(i = 0; i < nodei -> u.entry.row; i++) head[i] -> u.next -> down = head[i];
		for(i = 0; i < numHeads -1; i++) head[i] -> u.next = head[i + 1];
		head[numHeads - 1] -> u.next = node;
		node -> right = head[0];
		for(i = 0; i < numHeads; i++) head[i] = NULL;
	}

	return node;
}

//�x�}�ۥ[
MNODE* madd(MNODE *nodea, MNODE *nodeb){

	MNODE *nodec, *heada, *headb, *tempa, *tempb, *temp, *last;
	int i, numTerms = 0, numHeads;

	//�x�}���s�b�Τj�p���۵��ﵦ
	if(nodea -> u.entry.row != nodeb -> u.entry.row || nodea -> u.entry.col != nodeb -> u.entry.col || !nodea) return NULL;
	else{
		numHeads = (nodea -> u.entry.row > nodea -> u.entry.col) ? nodea -> u.entry.row : nodea -> u.entry.col;
		nodec = new MNODE;
		nodec -> tag = 1;
		nodec -> u.entry.row = nodea -> u.entry.row;
		nodec -> u.entry.col = nodea -> u.entry.col;

		for(i = 0; i < numHeads; i++){
			temp = new MNODE;
			head[i] = temp;
			head[i] -> tag = 0;
			head[i] -> right = temp;
			head[i] -> u.next = temp;
		}

		heada = nodea -> right;
		headb = nodeb -> right;

		//�̧ǳB�z�C�C
		for(i = 0; i < nodea -> u.entry.row; i++){
			last = head[i];

			//���OŪ���ӦC��
			for(tempa = heada -> right, tempb = headb -> right; tempa != heada || tempb != headb; numTerms++){

				//��x�}��C�۵��h�ۥ[��s�J
				if(tempa -> u.entry.col == tempb -> u.entry.col){
					if(tempa -> u.entry.value + tempb -> u.entry.value){
						temp = new MNODE;
						temp -> tag = 1;
						temp -> u.entry.col = tempa -> u.entry.col;
						temp -> u.entry.row = tempa -> u.entry.row;
						temp -> u.entry.value = tempa -> u.entry.value + tempb -> u.entry.value;
						head[tempa -> u.entry.col] -> u.next -> down = temp;
						head[tempa -> u.entry.col] -> u.next = temp;
						last -> right = temp;
						last = temp;
					}
					tempa = tempa -> right;
					tempb = tempb -> right;

				//���۵��h��W�s�J����p��
				}else if(tempb == headb || (tempa -> u.entry.col < tempb -> u.entry.col && tempa != heada)){
					temp = new MNODE;
					temp -> tag = 1;
					temp -> u.entry.col = tempa -> u.entry.col;
					temp -> u.entry.row = tempa -> u.entry.row;
					temp -> u.entry.value = tempa -> u.entry.value;
					head[tempa -> u.entry.col] -> u.next -> down = temp;
					head[tempa -> u.entry.col] -> u.next = temp;
					tempa = tempa -> right;
					last -> right = temp;
					last = temp;
				}else{
					temp = new MNODE;
					temp -> tag = 1;
					temp -> u.entry.col = tempb -> u.entry.col;
					temp -> u.entry.row = tempb -> u.entry.row;
					temp -> u.entry.value = tempb -> u.entry.value;
					head[tempb -> u.entry.col] -> u.next -> down = temp;
					head[tempb -> u.entry.col] -> u.next = temp;
					tempb = tempb -> right;
					last -> right = temp;
					last = temp;
				}
			}
			heada = heada -> u.next;
			headb = headb -> u.next;
			last -> right = head[i];
		}
		for(i = 0; i < nodea -> u.entry.col; i++) head[i] -> u.next -> down = head[i];
		for(i = 0; i < numHeads -1; i++) head[i] -> u.next = head[i + 1];
		head[numHeads - 1] -> u.next = nodec;
		nodec -> right = head[0];
		nodec -> u.entry.value = numTerms;
		for(i = 0; i < numHeads; i++) head[i] = NULL;
	}

	return nodec;
}

//�ۭ�
MNODE* mmult(MNODE *nodea, MNODE *nodeb){

	MNODE *nodec, *heada, *headb, *tempa, *tempb, *temp, *last;
	int i, j, numTerms = 0, numHeads, value = 0;

	//�L�k�ۭ��ﵦ
	if(nodea -> u.entry.col != nodeb -> u.entry.row || !nodea || !nodeb) return NULL;
	else{
		numHeads = (nodea -> u.entry.row > nodeb -> u.entry.col) ? nodea -> u.entry.row : nodeb -> u.entry.col;
		nodec = new MNODE;
		nodec -> tag = 1;
		nodec -> u.entry.row = nodea -> u.entry.row;
		nodec -> u.entry.col = nodeb -> u.entry.col;

		for(i = 0; i < numHeads; i++){
			temp = new MNODE;
			head[i] = temp;
			head[i] -> tag = 0;
			head[i] -> right = temp;
			head[i] -> u.next = temp;
		}

		heada = nodea -> right;
		headb = nodeb -> right;

		//�̧ǳB�z�C�C
		for(i = 0; i < nodea -> u.entry.row; i++){
			last = head[i];

			//�̧ǳB�z�C��
			for(j = 0; j < nodeb -> u.entry.col; j++){

				//���OŪ��������ΦC����
				for(tempa = heada -> right, tempb = headb -> down; tempa != heada && tempb != headb; ){

					//��C���۵�
					if(tempa -> u.entry.col < tempb -> u.entry.row) tempa = tempa -> right;
					else if(tempa -> u.entry.col > tempb -> u.entry.row) tempb = tempb -> down;

					//��C�۵��h�ۭ��[�J�Ȧs
					else{
						value += tempa -> u.entry.value * tempb -> u.entry.value;
						tempa = tempa -> right;
						tempb = tempb -> down;
					}
				}

				//�Y�Ӧ�m���s�J��
				if(value){
					numTerms++;
					temp = new MNODE;
					temp -> tag = 1;
					temp -> u.entry.col = j;
					temp -> u.entry.row = i;
					temp -> u.entry.value = value;
					head[j] -> u.next -> down = temp;
					head[j] -> u.next = temp;
					last -> right = temp;
					last = temp;
					value = 0;
				}
				headb = headb -> u.next;
			}
			headb = nodeb -> right;
			heada = heada -> u.next;
			last -> right = head[i];
		}
		for(i = 0; i < nodeb -> u.entry.col; i++) head[i] -> u.next -> down = head[i];
		for(i = 0; i < numHeads -1; i++) head[i] -> u.next = head[i + 1];
		head[numHeads - 1] -> u.next = nodec;
		nodec -> right = head[0];
		nodec -> u.entry.value = numTerms;
		for(i = 0; i < numHeads; i++) head[i] = NULL;
	}

	return nodec;
}

//�M���x�}
void merase(MNODE **node){

	MNODE *x, *y, *head;
	int i;

	head = (*node) -> right;

	//�̧ǳB�z�C�C
	for(i = 0; i < (*node) -> u.entry.row; i++){
		y = head -> right;

		//�̧ǧR���`�I
		while(y != head){
			x = y;
			y = y -> right;
			delete x;
		}
		x = head;
		head = head -> u.next;
		delete x;
	}
	y = head;

	//�̧ǧR��Head
	while(y != (*node)){
		x = y;
		y = y -> u.next;
		delete x;
	}

	//�R���_�I
	delete (*node);
	*node = NULL;

	return;
}



int main(void){

	MNODE *m[3];
	int i;
	char flag, v1, v2, v3, str[MAX_SIZE];

	for(i = 0; i < 3; i++) m[i] = NULL;

	while(1){

		//�L�X�ܼƪ��p
		system("cls");
		if(m[0]) cout << "x:" << m[0] -> u.entry.row << "x" << m[0] -> u.entry.col << "(" << m[0] -> u.entry.value << ")\t";
		else cout << "x: empty\t";
		if(m[1]) cout << "y:" << m[1] -> u.entry.row << "x" << m[1] -> u.entry.col << "(" << m[1] -> u.entry.value << ")\t";
		else cout << "y: empty\t";
		if(m[2]) cout << "z:" << m[2] -> u.entry.row << "x" << m[2] -> u.entry.col << "(" << m[2] -> u.entry.value << ")\n\n";
		else cout << "z: empty\n\n";

		//�L�X���
		cout << "(a) Read      (b) Print     (c) Erase     (d) Add\n(e) Multiple  (f) Transpose (g) Output    (h) Exit\n";
		cout << "Please select a program to execute: ";
		flag = _getch();
		
		switch(flag){
			case 65:
			case 97:

				//Ū��
				cout << "(a) Read a matrix from a file\nPlease enter the name of the file you want to read: ";
				cin >> str;
				cout << "Please chose a variable to store the matrix: ";
				v1 = _getch();
				if(v1 < 120 || v1 > 122) break;
				m[v1 - 120] = mread(str);
				break;
			case 66:
			case 98:

				//�L�X
				cout << "(b) Print a matrix on screen\nPlease chose a matrix to print: ";
				v1 = _getch();
				if(v1 < 120 || v1 > 122) break;
				cout << '(' << v1 << ") Print " << v1 << "\n\n";
				if(!m[v1 - 120]) break;
				mwrite(m[v1 - 120]);
				cout << "\nPress any key to continue...";
				_getch();
				break;
			case 67:
			case 99:

				//�M��
				cout << "(c) Erase a matrix\nPlease chose a matrix you want to erase: ";
				v1 = _getch();
				if(v1 < 120 || v1 > 122) break;
				if(!m[v1 - 120]) break;
				merase(&m[v1 - 120]);
				break;
			case 68:
			case 100:

				//�[�k
				cout << "(d) Calculate the summation of A and B\nPlease chose the matrix A: ";
				v1 = _getch();
				if(v1 < 120 || v1 > 122) break;
				cout << '(' << v1 << ") Augend:" << v1 << "\nPlease chose the matrix B: ";
				v2 = _getch();
				if(v2 < 120 || v2 > 122) break;
				cout << '(' << v2 << ") Addend:" << v2 << "\nPlease chose a variable to store the summation: ";
				v3 = _getch();
				if(v3 < 120 || v3 > 122) break;
				if(!m[v1 - 120] || !m[v2 - 120]) break;
				m[v3 - 120] = madd(m[v1 - 120], m[v2 - 120]);
				break;
			case 69:
			case 101:

				//���k
				cout << "(e) Calculate the product of A and B\nPlease chose the matrix A: ";
				v1 = _getch();
				if(v1 < 120 || v1 > 122) break;
				cout << '(' << v1 << ") Multiplicand:" << v1 << "\nPlease chose the matrix B: ";
				v2 = _getch();
				if(v2 < 120 || v2 > 122) break;
				cout << '(' << v2 << ") Multiplicator:" << v2 << "\nPlease chose a variable to store the product: ";
				v3 = _getch();
				if(v3 < 120 || v3 > 122) break;
				if(!m[v1 - 120] || !m[v2 - 120]) break;
				m[v3 - 120] = mmult(m[v1 - 120], m[v2 - 120]);
				break;
			case 70:
			case 102:

				//��m
				cout << "(f) Calculate the transpose of a matrix\nPlease chose a matrix you want to transpose: ";
				v1 = _getch();
				if(v1 < 120 || v1 > 122) break;
				cout << '(' << v1 << ") Transpose of " << v1 << "\nPlease chose a variable to store the transpose: ";
				v2 = _getch();
				if(v2 < 120 || v2 > 122) break;
				if(!m[v1 - 120]) break;
				m[v2 - 120] = mtrans(m[v1 - 120]);
				break;
			case 71:
			case 103:

				//��X
				cout << "(g) Output a matrix to a file\nPlease chose a matrix to output: ";
				v1 = _getch();
				if(v1 < 120 || v1 > 122) break;
				cout << '(' << v1 << ") Output " << v1 << "\nPlease enter the name of the output file: ";
				if(!m[v1 - 120]) break;
				cin >> str;
				moutput(m[v1 - 120], str);
				break;
			case 72:
			case 104:

				//���}
				exit(0);
				break;
			default:
				;
		}
	}

	return 0;
}