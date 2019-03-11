/**
 * Первый вариант работы, с заданным массивом
 */
public class JobTwo {
	
	public static void main(String args[]) {
		
	/**
	 * Первый вариант работы, с заданным массивом
	 */
	
	/*	int array[] = {15,12,12,15,123,151,635,789};
		int sum = 0;
		boolean ab = false;
		//Цикл, проверки элементов массива, есть ли элементы больше 1000
		for (int j = 0; j < array.length; j++) {
			if(array[j]>=1000) {
				System.out.println("Массив массивный");
				ab = true;
				break;
			} 
		}
		//условие с вложенным циклом суммы элементов
		if (ab == false) {
			for (int j = 0; j < array.length; j++) {
				sum = sum + array[j];
			}
			System.out.println("Сумма всех элементов массива равна:" + sum);		
		} */
	
		
	/**
	 * Второй вариант работы, с аргументами запуска
	 */
		int sum = 0;
		boolean ab = false;
	//Цикл, проверки элементов массива, есть ли элементы больше 1000
		for (int j = 0; j < args.length; j++) {
			Integer a = Integer.valueOf(args[j]);
			if(a >=1000) {
				System.out.println("Массив массивный");
				ab = true;
				break;
			} 
		}
	//условие с вложенным циклом суммы элементов	
		if (ab == false) {
			for (int j = 0; j < args.length; j++) {
				Integer a = Integer.valueOf(args[j]);
				sum += a;
			}
			System.out.println("Сумма всех элементов массива равна:" + sum);		
		} 	
	}
}
