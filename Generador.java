import java.io.PrintStream;

public class Generador {
	public static final int MAS = 1;
	public static final int MENOS = 2;
	public static final int POR = 3;
	public static final int DIV = 4;
	public static final int ASIG = 5;
	public static final int GOTO = 6;
	public static final int LABEL = 7;
	public static final int IFEQ = 8;
	public static final int IFLT = 9;
	public static final int PRINT = 10;
    	public final static int HALT = 11; 

	public static int contadorTemp = 0;
	public static int contadorEtiq = 0;
	protected static PrintStream out = System.out;

	public static void gc(int operacion, String arg1, String arg2, String resultado) {
		switch(operacion) {
			case MAS:
				out.println("   " + resultado + " = " + arg1 + " + " + arg2 + ";");
				break;
			case MENOS:
				out.println("   " + resultado + " = " + arg1 + " - " + arg2 + ";");
				break;
			case POR:
				out.println("   " + resultado + " = " + arg1 + " * " + arg2 + ";");
				break;
			case DIV:
				out.println("   " + resultado + " = " + arg1 + " / " + arg2 + ";");
				break;
			case ASIG:
				out.println("   " + resultado + " = " + arg1 + ";");
				break;
			case IFEQ:
				out.println("   if (" + arg1 + " == " + arg2 + ") goto " + resultado + ";");
				break;
			case IFLT:
				out.println("   if (" + arg1 + " < " + arg2 + ") goto " + resultado + ";");
				break;
			case GOTO:
				out.println("   goto " + resultado + ";");
				break;
			case LABEL:
				out.println(resultado + ":");
				break;
			case PRINT:
				out.println("   print " + resultado + ";");
				break;
			case HALT:
            			out.println("   halt;");
	        		break;	      
			default:
				System.err.println("Error en la generación de código");
		}
	}

	public static String nuevaTemp() {
		return "t" + contadorTemp++;
	}

	public static String nuevaEtiq() {
		return "L" + contadorEtiq++;
	}
}
