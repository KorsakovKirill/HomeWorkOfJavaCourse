
public class JobThird {
	
	public static void main(String[] args) {
	/**
	* 
	* ������ �������, �� ��������� ��������
	*/
		int[] array = {100500,112,100500,100500,1253,151,635,749};
		
		//����� Math.max
		int maxValue = 0; 
		for (int i = 0; i < array.length; i++) {
			maxValue = array[i];
			if(array[i] == 100500) {
				continue;
			}
			maxValue = Math.max(maxValue, array[i]);
		}
		System.out.println("����� ����. �������� � ������� \"Math.Max\":" + maxValue);
		
		
		//��� ������������� ������ Math.Max
		int maxValue1 = 0; 
		for(int i = 0; i < array.length; i++) {
			maxValue1 = array[i];
			if(array[i] == 100500) {
				continue;
			}
			if(array[i]>maxValue1) {
				maxValue1 = array[i];
			}
		}
		System.out.println("����� ����. �������� ��� ������ \"Math.Max\":" + maxValue1);
		
	/**
	 * ������ ������� � ����������� ������� - 3 5 8 854 100500 999999
	 */
		int maxValue2 = 0;
		for (int i = 0; i < args.length; i++) {
			maxValue2 = Integer.valueOf(args[i]);
			Integer a = Integer.valueOf(args[i]);
			if(a == 100500) {
				continue;
			}
			maxValue2 = Math.max(maxValue2, a);
		}
		System.out.println("����� ����.�������� �� ���������� ������� � ������� \"Math.Max\" :" + maxValue2);
		
		//��� ������������� ������ Math.Max
		int maxValue3 = 0;
		for(int i = 0; i < args.length; i++) {
			maxValue3 = Integer.valueOf(args[0]);
			Integer a = Integer.valueOf(args[i]);
			if(a == 100500) {
				continue;
			}
			if(a>maxValue3) {
				maxValue3 = a;
			}
		}
		System.out.println("����� ����.�������� �� ���������� ��� ������ \"Math.Max\":" + maxValue3);
		
		
		
	}
}
