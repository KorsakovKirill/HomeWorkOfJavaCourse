
// ������� 1. ��������� if

public class JobOne {
	public static void main(String[] args) {
		int arg1 = Integer.valueOf(args[0]);
		int arg2 = Integer.valueOf(args[1]);
		if(arg1<0|arg2<0) {
			System.out.println("���� ������������� �����");
		} else if(arg2 != 0){
			double a = (double)arg1/arg2;
			
			System.out.println("��������� �������:"+ (a));
		//������� ������ �������� ����� 
			//�������� ���������.... 
			if(arg1>arg2) {
				System.out.println("������ ����� ������ �������");
			} else if(arg1==arg2) {
				System.out.println("����� �����");
			}
			else {
				System.out.println("������ ����� ������ �������");
			}
		//�������� ������� ����� �� ��������
			if(arg1%2==0) {
				System.out.println("����� " + arg1 + " - ������");
			}
		}
			
	}
}
