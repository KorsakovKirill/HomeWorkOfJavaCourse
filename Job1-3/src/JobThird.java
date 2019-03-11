
public class JobThird {
	
	public static void main(String[] args) {
	/**
	* 
	* Первый вариант, со статичным массивом
	*/
		int[] array = {100500,112,100500,100500,1253,151,635,749};
		
		//Метод Math.max
		int maxValue = 0; 
		for (int i = 0; i < array.length; i++) {
			maxValue = array[i];
			if(array[i] == 100500) {
				continue;
			}
			maxValue = Math.max(maxValue, array[i]);
		}
		System.out.println("Вывод макс. значения с методом \"Math.Max\":" + maxValue);
		
		
		//Без использования метода Math.Max
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
		System.out.println("Вывод макс. значения без метода \"Math.Max\":" + maxValue1);
		
	/**
	 * Второй вариант с аргументами запуска - 3 5 8 854 100500 999999
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
		System.out.println("Вывод макс.значения из аргументов запуска с методом \"Math.Max\" :" + maxValue2);
		
		//Без использования метода Math.Max
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
		System.out.println("Вывод макс.значения из аргументов без метода \"Math.Max\":" + maxValue3);
		
		
		
	}
}
