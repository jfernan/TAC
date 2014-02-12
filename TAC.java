import java.io.FileReader;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class TAC {
  static public void main(String argv[]) {    
    try {
      parser p = new parser(new Yylex(new FileReader(argv[0])));
      if (argv.length>1 && argv[1]!=null) {
    	 Generador.out = new PrintStream(new FileOutputStream(argv[1]));
      }
      Object result = p.parse().value;      
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}


