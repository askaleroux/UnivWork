
public class main {


	public static void main(String[] args) {
		MySet_F74976120_1 a;
		MySet_F74976120_1 b;
		
		if(args.length > 1){
			a = new MySet_F74976120_1(args[0]);
			b = new MySet_F74976120_1(args[1]);
		}
		else if(args.length > 0){
			a = new MySet_F74976120_1(args[0]);
			b = new MySet_F74976120_1();
		}
		else{
			a = new MySet_F74976120_1();
			b = new MySet_F74976120_1();
		}

		System.out.println("========================================");
		System.out.println("��J���X���G " + a.toString() + " " + b.toString());
		System.out.println("�Ĥ@�Ӷ��X�j�p�G " + a.size());
		System.out.println("�Ĥ@�Ӷ��X�O�_���Ŷ��X�G " + a.isEmpty());
		System.out.println("�Ĥ@�Ӷ��X���̤p�ȡG " + a.getMinimalElement());
		System.out.println("�Ĥ@�Ӷ��X���̤j�ȡG " + a.getMaximalElement());
		a.sort();
		System.out.println("�Ĥ@�Ӷ��X�Ƨǵ��G�G " + a.toString());
		System.out.print("�Ĥ@�Ӷ��X�Ҧ��l���X�G ");
		a.showSubset();
		System.out.print("\n�Ĥ@�Ӷ��X�`�M����ƪ��l���X�G ");
		a.showPrimeofSubset();
		System.out.println("\n�Ĥ@�Ӷ��X�P�ĤG�Ӷ��X�O�_�ۦP�G " + a.equals(b));
		System.out.println("�Ĥ@�Ӷ��X�O�_���ĤG�Ӷ��X���W���X�G " + a.superSet(b));
		System.out.println("�Ĥ@�Ӷ��X�O�_���ĤG�Ӷ��X���l���X�G " + a.subSet(b));
		System.out.println("�Ĥ@�Ӷ��X�p���ĤG�Ӷ��X�G " + a.union(b));
		System.out.println("�Ĥ@�Ӷ��X�涰�ĤG�Ӷ��X�G " + a.intersection(b));
		System.out.println("�Ĥ@�Ӷ��X�t���ĤG�Ӷ��X�G " + a.difference(b));
		System.out.println("========================================");
		

	}

}
