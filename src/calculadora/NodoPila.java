package calculadora;
//Clase nodo pila
/**
 *  Calculadora mediante la notacion polaca inversa.
 * @author Adelin Todirica
 * @since 18.02.2018
 *@version 1.0
 */
public class NodoPila {
		public NodoPila abajo;
		public double dato;
		/**
		 * método constructor de NodoPila
		 * @param dato  dato double 
		 * @param abajo  dato de tipo object NodoPila
		 */
		public NodoPila(double dato, NodoPila abajo) {
			this.dato = dato;
			this.abajo = abajo;
		}
	}


