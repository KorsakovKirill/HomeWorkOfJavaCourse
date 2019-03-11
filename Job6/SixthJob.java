package ru.mera.korsakovkirill.postman;

public class SixthJob {

	public static void main(String[] args) {
		
		BananaMCM bmcm = new BananaMCM();
		ChocolateMCM chmcm = new ChocolateMCM();
		OrangeMCM omcm = new OrangeMCM();
		
		Object[] mas = {bmcm,chmcm,omcm};
		
		for(int i = 0; i < 1; i++) {
			System.out.println("Приготовление бананового молочного кактейля:");
			bmcm.mix();
			System.out.println("\nПриготовление шоколадного молочного кактейля:");
			chmcm.mix();
			System.out.println("\nПриготовление апельсинового молочного кактейля:");
			omcm.mix();
		}
		
	}

}
