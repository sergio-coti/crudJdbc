package principal;

import java.util.Scanner;

public class Tabuada {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("ENTRE COM O NUMERO:");
		Integer numero = Integer.parseInt(scanner.nextLine());
		
		for(int i = 1; i <= 10; i++) {
			
			Integer resultado = numero * i;
			
			System.out.println(numero + " X " + i + " = " + resultado);
		}
		
		scanner.close();
	}
}
