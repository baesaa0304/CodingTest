import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;


public class Main {

	  public static void main(String[] args) throws IOException {
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	        
	        String binary = br.readLine();

	        
	        BigInteger decimal = new BigInteger(binary, 8);

	        
	        String octal = decimal.toString(2);

	        
	        System.out.println(octal);
	    }

}