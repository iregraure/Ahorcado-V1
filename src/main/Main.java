package main;

import java.util.Scanner;

import ahorcado.Ahorcado;

public class Main {

	private static Scanner teclado = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		// Variables
		int fallos = 0;
		boolean encontrado = false;
		char letra;
		int posLetra;
		
		// Creamos el objeto Ahorcado
		Ahorcado ahorcado = new Ahorcado();
		
		// Vamos a pedir letras mientras que no se haya encontrado la frase y haya menos de 10 fallos
		while (!encontrado && fallos < 10) {
			try {
				
				// Mostramos lo que ha adivinado hasta ahora el jugador
				System.out.println(ahorcado.getAdivinado());
				// Pedimos una letra al jugador
				letra = leerCaracter("Introduce una letra: ");
				// Llamamos al método que añade la letra a lo que ya hemos adivinado
				posLetra = ahorcado.aniadeLetra(letra);
				// Si la posición es -1 es que la letra no existe en la frase
				if(posLetra == -1) {
					fallos++;
					System.out.println("La letra no se encuentra en la frase :-(");
				}
				// Si es distinto de -1 es que sí está y tenemos que comprobar si ya tiene la frase completa
				else {
					// Si adivinado y frase son iguales cambiamos encontrado a verdadero para salir del bucle
					if (ahorcado.getAdivinado().equals(ahorcado.getFrase())) {
						encontrado = true;
					}
				}
			}
			catch(Exception e) {
				if(e.getMessage().equals("letra repetida")) {
					System.out.println("Ya has probado con esta letra!!! (Cuenta como fallo por no estar atento :-P)");
					fallos++;
				}
				else {
					System.out.println(e.getMessage());
				}
			}
		}
		
		// Cuando salimos del bucle comprobamos el número de errores para saber si se ha adivinado la palabra o no
		if(fallos == 10) {
			System.out.println("Te has quedado sin intentos...\nLa frase era " + ahorcado.getFrase());
		}
		else {
			System.out.println("Genial!! Has adivinado la frase!!!\n" + ahorcado.getAdivinado());
		}

	}
	
	private static char leerCaracter(String mensaje) {
		System.out.println(mensaje);
		return teclado.nextLine().charAt(0);
	}
	
}
