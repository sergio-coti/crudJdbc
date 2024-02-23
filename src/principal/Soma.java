package principal;

import java.util.Scanner;

public class Soma {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("ENTRE COM O PRIMEIRO NUMERO:");
		Integer numero1 = Integer.parseInt(scanner.nextLine());
		
		System.out.println("ENTRE COM O SEGUNDO NUMERO: ");
		Integer numero2 = Integer.parseInt(scanner.nextLine());
		
		Integer soma = numero1 + numero2;
		
		System.out.println("\nSOMA: " + soma);
		
		scanner.close();
	}
}
