package calculadora;
/* 
Objetivo: Obtener código refactorizado a partir de otro que no lo está.
Tarea: Para esta tarea, se refactorizará un programa mal escrito, sin
cambiar la forma en que funciona el programa. Este programa, RPN.java
es una calculadora de notación inversa polaca que utiliza una pila.
 Reverse Polish notation (RPN) Notación Polaca inversa, por ejemplo
la expresión: 4 * 5 - 7 / 2 % 3 nos da 1,5 respetando la prioridad de
los operadores en notación RPN seria: 4 5 * 7 2 / - 3 % (pues no podemos
poner los paréntesis para alterar la prioridad)
 Se debe reorganizar este código usando al menos tres de las reglas
vistas en clase.
 */

public class RPN {
	private String commando;
	private NodoPila arriba;
	public void pushPila(double nuevo_dato) {
		NodoPila nuevo_nodo = new NodoPila(nuevo_dato, arriba);
		arriba = nuevo_nodo;
	}
	/** 
	 * Desapila un elemento a la pila, retirándolo de la misma.
	 * @return dato_arriba
	 */
	public double popPila( ) {
		double dato_arriba = arriba.dato;
		arriba = arriba.abajo;
		return dato_arriba;
	}
	/**
	 *  Introduce un comando.
	 * @param commando
	 */
	public RPN(String commando) {
		arriba = null;
		this.commando = commando;
	}
	/**
	 * Recorre el comando y realiza la operación si las comprobaciones se han realizado correctamente.
	 * @return el resultado de la operación  de tipo double
	 *  
	 */
	public double resultado( ) {
		calculo();
		double val = popPila( );
		if(arriba != null) {
			throw new IllegalArgumentException( );
		}
		return val;
	}
	/**
	 * 
	 */
	public void calculo() {
		double a, b;
		int j;
		for(int i = 0; i < commando.length( ); i++) {
			// si es un digito
			if(Character.isDigit(commando.charAt(i))) {
				double numero;
				// obtener un string a partir del numero
				String temp = "";
				for(j = 0; (j < 100) && (Character.isDigit(
						commando.charAt(i)) || (commando.charAt(i) == '.')); j++, i++) {
					temp = temp + String.valueOf(commando.
							charAt(i));
				}
				// convertir a double y añadir a la pila
				convertToDouble(temp);
			} else if(commando.charAt(i) == '+') {
				b = popPila( );
				a = popPila( );
				pushPila(a + b);
			} else if(commando.charAt(i) == '-') {
				b = popPila( );
				a = popPila( );
				pushPila(a - b);
			} else if(commando.charAt(i) == '*') {
				b = popPila( );
				a = popPila( );
				pushPila(a * b);
			} else if(commando.charAt(i) == '/') {
				b = popPila( );
				a = popPila( );
				pushPila(a / b);
			}
			else if(commando.charAt(i) == '^') {
				b = popPila( );
				a = popPila( );
				pushPila(Math.pow(a, b));}
			else if(commando.charAt(i) == '%') {
				b = popPila( );
				a = popPila( );
				pushPila(a%b);
			} else if(commando.charAt(i) != ' ') {
				throw new IllegalArgumentException( );
			}
		}
	}
	/** convierte el numero a double y lo añade a la pila
	 * @param temp
	 */
	public void convertToDouble(String temp) {
		double numero;
		numero = Double.parseDouble(temp);
		pushPila(numero);
	}
}
	

