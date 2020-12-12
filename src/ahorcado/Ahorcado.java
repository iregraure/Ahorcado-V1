package ahorcado;

// Intrucci�n para generar un n�mero aleatorio entre dos n�meros M y N, siendo M menor que N
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
		// Calculamos un n�mero aleatorio entre 0 y la longitud del array
		aleatorio = (int)Math.floor(Math.random()*(frases.length));
		// Guardamos en frase lo que haya en la posici�n calculada
		this.frase = frases[aleatorio];
		this.adivinado = creaFraseVacia(frase);
		letras = new char[27];
		cont = 0;
	}
	
	// M�todos get
	public String getFrase() {
		return frase;
	}

	public String getAdivinado() {
		return adivinado;
	}
	
	private String creaFraseVacia(String frase) {
		// Creamos un StringBuilder donde vamos a almacenar la frase vac�a
		StringBuilder resul = new StringBuilder();
		// Recorremos todos los caracteres de la frase
		for(int i = 0; i < frase.length(); i++) {
			// Guardamos el caracter que se encuentra en la posici�n i
			char c = frase.charAt(i);
			// Si es un espacio lo a�adimos a resul
			if(c == ' ') {
				resul.append(' ');
			}
			// Si no, a�adimos un _
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
			// Si la letra es igual que la que hay en la posici�n i del array lanzamos una excepci�n
			if(letras[i] == letra) {
				throw new Exception ("letra repetida");
			}
		}
		// Si la letra no est� repetida la a�adimos al array de letras
		letras[cont] = letra;
		cont++;
		// Comprobamos la posici�n de la letra dentro de la frase a encontrar
		int pos = frase.indexOf(letra);
		// Si la posici�n es distinto de -1 (la letra existe) llamamos al m�todo para a�adir la letra a adivinado
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
			// Si la letra es igual se a�ade a aux
			if(frase.charAt(i) == letra) {
				aux.append(letra);
			}
			// Si no, se a�ade lo que hubiese en adivinado
			else {
				aux.append(adivinado.charAt(i));
			}
		}
		// Antes de terminar actualizamos el valos de adivinado al valor de aux
		adivinado = aux.toString();
	}
	
}
