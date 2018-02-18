package calculadora;
//test class

/**
 * clase de comprobaci�n del funcionamiento del programa
 * @author Adelin
 * 
 */
import java.util.Scanner;
public class TestRPN {
	/* metodo main */
	public static void main(String args[]) {
		while(true) {
			Scanner in = new Scanner(System.in);
			System.out.println("Introduce expresion Postfija o teclea \"fin\".");
			String linea = in.nextLine( );
			if(linea.equals("fin")) {
				System.out.println("Fin de programa");
				break;
			} else {
				RPN calc = new RPN(linea);
				System.out.printf("El resultado es %f\n",
						calc.resultado( ));
				}
		}
	}
}
