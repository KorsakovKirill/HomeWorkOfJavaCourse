
// Задание 1. Ветвистый if

public class JobOne {
	public static void main(String[] args) {
		int arg1 = Integer.valueOf(args[0]);
		int arg2 = Integer.valueOf(args[1]);
		if(arg1<0|arg2<0) {
			System.out.println("Есть отрицательное число");
		} else if(arg2 != 0){
			double a = (double)arg1/arg2;
			
			System.out.println("Результат деления:"+ (a));
		//Условие вывода большего числа 
			//добавить равенство.... 
			if(arg1>arg2) {
				System.out.println("Первое число больше второго");
			} else if(arg1==arg2) {
				System.out.println("Числа равны");
			}
			else {
				System.out.println("Второе число больше первого");
			}
		//Проверка первого числа на чётность
			if(arg1%2==0) {
				System.out.println("Число " + arg1 + " - четное");
			}
		}
			
	}
}
