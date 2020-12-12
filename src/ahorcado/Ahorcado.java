package ahorcado;

// Intrucción para generar un número aleatorio entre dos números M y N, siendo M menor que N
// int valorEntero = Math.floor(Math.random()*(N-M+1)+M);

public class Ahorcado implements AhorcadoInterface{

	// Atributos
	String frases[];
	int aleatorio;
	String frase;
	String adivinado;
	char letras[];
	int cont;
	
	// Constructor
	public Ahorcado() {
		// Creamos el array con las posibles frases
		frases = new String[] {"vamos  a  aprobar  todos", "voy  a  ser  mas  positivo", "odio  esta  asignatura", "facil  divertido  y  entretenido",
				"esto  es  muy  facil", "bienvenidos  al  jaracanda", "javi  se  nos  ha  ido", "buena  suerte  en  las  oposiciones"};
		// Calculamos un número aleatorio entre 0 y la longitud del array
		aleatorio = (int)Math.floor(Math.random()*(frases.length));
		// Guardamos en frase lo que haya en la posición calculada
		this.frase = frases[aleatorio];
		this.adivinado = creaFraseVacia(frase);
		letras = new char[27];
		cont = 0;
	}
	
	// Métodos get
	public String getFrase() {
		return frase;
	}

	public String getAdivinado() {
		return adivinado;
	}
	
	private String creaFraseVacia(String frase) {
		// Creamos un StringBuilder donde vamos a almacenar la frase vacía
		StringBuilder resul = new StringBuilder();
		// Recorremos todos los caracteres de la frase
		for(int i = 0; i < frase.length(); i++) {
			// Guardamos el caracter que se encuentra en la posición i
			char c = frase.charAt(i);
			// Si es un espacio lo añadimos a resul
			if(c == ' ') {
				resul.append(' ');
			}
			// Si no, añadimos un _
			else {
				resul.append('_');
			}
		}
		return resul.toString();
	}

	public int aniadeLetra(char letra) throws Exception{
		// Convertimos la letra a minuscula para evitar problemas
		letra = Character.toLowerCase(letra);
		// Recorremos el array de letras para comprobar si ya se ha introducido
		for (int i = 0; i < cont; i++) {
			// Si la letra es igual que la que hay en la posición i del array lanzamos una excepción
			if(letras[i] == letra) {
				throw new Exception ("letra repetida");
			}
		}
		// Si la letra no está repetida la añadimos al array de letras
		letras[cont] = letra;
		cont++;
		// Comprobamos la posición de la letra dentro de la frase a encontrar
		int pos = frase.indexOf(letra);
		// Si la posición es distinto de -1 (la letra existe) llamamos al método para añadir la letra a adivinado
		if(pos != -1) {
			aniadeLetraAdivinado(letra);
		}
		return pos;
	}
	
	private void aniadeLetraAdivinado(char letra) {
		// Definimos un StringBuilder para crear adivinado con la nueva letra
		StringBuilder aux = new StringBuilder();
		// Recorremos la frase
		for (int i = 0; i < frase.length(); i++) {
			// Si la letra es igual se añade a aux
			if(frase.charAt(i) == letra) {
				aux.append(letra);
			}
			// Si no, se añade lo que hubiese en adivinado
			else {
				aux.append(adivinado.charAt(i));
			}
		}
		// Antes de terminar actualizamos el valos de adivinado al valor de aux
		adivinado = aux.toString();
	}
	
}
