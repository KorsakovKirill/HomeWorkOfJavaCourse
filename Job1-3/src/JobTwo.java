/**
 * ������ ������� ������, � �������� ��������
 */
public class JobTwo {
	
	public static void main(String args[]) {
		
	/**
	 * ������ ������� ������, � �������� ��������
	 */
	
	/*	int array[] = {15,12,12,15,123,151,635,789};
		int sum = 0;
		boolean ab = false;
		//����, �������� ��������� �������, ���� �� �������� ������ 1000
		for (int j = 0; j < array.length; j++) {
			if(array[j]>=1000) {
				System.out.println("������ ���������");
				ab = true;
				break;
			} 
		}
		//������� � ��������� ������ ����� ���������
		if (ab == false) {
			for (int j = 0; j < array.length; j++) {
				sum = sum + array[j];
			}
			System.out.println("����� ���� ��������� ������� �����:" + sum);		
		} */
	
		
	/**
	 * ������ ������� ������, � ����������� �������
	 */
		int sum = 0;
		boolean ab = false;
	//����, �������� ��������� �������, ���� �� �������� ������ 1000
		for (int j = 0; j < args.length; j++) {
			Integer a = Integer.valueOf(args[j]);
			if(a >=1000) {
				System.out.println("������ ���������");
				ab = true;
				break;
			} 
		}
	//������� � ��������� ������ ����� ���������	
		if (ab == false) {
			for (int j = 0; j < args.length; j++) {
				Integer a = Integer.valueOf(args[j]);
				sum += a;
			}
			System.out.println("����� ���� ��������� ������� �����:" + sum);		
		} 	
	}
}
